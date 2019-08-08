package se.webstep.demoapplication.service;

import static org.hamcrest.Matchers.is;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.junit4.SpringRunner;

import config.AppConfig;
import se.webstep.springbootdemo.entities.Customer;
import se.webstep.springbootdemo.services.CustomerService;


@Profile("test")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {AppConfig.class, se.webstep.demoapplication.configuration.configuration.TestPersistanceJPAConfiguration.class})
public class CustomerServiceTest {

    @Autowired
    private CustomerService customerService;

    private void initCustomerList() {
        Customer addedTestEntity = new Customer("0001", "Sven", "Svensson", "Testgatan 1", "Testholmen", "111 11");
        customerService.registerNewCustomer(addedTestEntity);
    }

    @Before
    public void initTest() {
        initCustomerList();
    }

    @Test
    public void verifyCustomerRowsCouldBeRetrievedFromDB() {
        List<Customer> allCustomers = customerService.getAllCustomers();
        Assert.assertNotNull(allCustomers);
        Assert.assertThat(allCustomers.isEmpty(),is(false));
    }

    @After
    public void cleanUpEntities(){
        List<Customer> allCustomers = customerService.getAllCustomers();
        for (Customer customer : allCustomers) {
            customerService.deleteCustomer(customer);
        }
    }
}
