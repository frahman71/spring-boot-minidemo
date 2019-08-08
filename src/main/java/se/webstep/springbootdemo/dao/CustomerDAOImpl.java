package se.webstep.springbootdemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import se.webstep.springbootdemo.entities.Customer;


@Repository
public class CustomerDAOImpl implements CustomerDAO {

    @PersistenceContext
    private EntityManager em;

    public List<Customer> getAllCustomers() {
        Query query = em.createQuery("SELECT c from Customer c", Customer.class);
        return (List<Customer>) query.getResultList();
    }

    @Override
    @Transactional
    public void registerNewCustomer(Customer customer) {
        em.merge(customer);
    }

    public boolean customerExist(Customer customer) {
        Query query=em.createQuery("SELECT c from Customer c where c.customerId=:customerId", Customer.class);
        query.setParameter("customerId", customer.getCustomerId());

        return query.getResultList() !=null && query.getResultList().size()>0;
    }

    @Override
    @Transactional
    public void deleteCustomer(Customer customer) {
        em.remove(em.contains(customer) ? customer : em.merge(customer));
    }

}
