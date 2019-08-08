package se.webstep.springbootdemo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import se.webstep.springbootdemo.dao.CustomerDAO;
import se.webstep.springbootdemo.entities.Customer;


@Service
public class CustomerService {

    @Autowired
    CustomerDAO customerDAO;

    public List<Customer> getAllCustomers(){
        return customerDAO.getAllCustomers();
    }

    @Transactional
    public void registerNewCustomer(Customer customer){
        customerDAO.registerNewCustomer(customer);
    }

    @Transactional
    public void deleteCustomer(Customer customer){
        customerDAO.deleteCustomer(customer);
    }

    public boolean customerExists(Customer customer){
       return customerDAO.customerExist(customer);
    }
}
