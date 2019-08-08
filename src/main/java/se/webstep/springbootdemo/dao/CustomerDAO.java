package se.webstep.springbootdemo.dao;

import java.util.List;

import se.webstep.springbootdemo.entities.Customer;

public interface CustomerDAO {
    public List<Customer> getAllCustomers();

    public void registerNewCustomer(Customer customer);

    public boolean customerExist(Customer customer);

    public void deleteCustomer(Customer customer);
}
