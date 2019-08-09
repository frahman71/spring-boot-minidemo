package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import se.webstep.springbootdemo.dao.CustomerDAO;
import se.webstep.springbootdemo.dao.CustomerDAOImpl;
import se.webstep.springbootdemo.restservices.CustomerRestServiceWithCompleteImplementation;
import se.webstep.springbootdemo.restservices.CustomerRestServiceWithEmptyMethods;
import se.webstep.springbootdemo.services.CustomerService;

@Configuration
public class AppConfig {

    //Register internal services here
    @Bean
    public CustomerService customerService() {
        return new CustomerService();
    }

    //Register DAO-components here
    @Bean
    CustomerDAO customerDAO() {
        return new CustomerDAOImpl();
    }

    @Bean
    CustomerRestServiceWithEmptyMethods customerRestServiceWithEmptyMethods() {
        return new CustomerRestServiceWithEmptyMethods();
    }

    @Bean
    CustomerRestServiceWithCompleteImplementation customerRestServiceWithCompleteImplementation() { return new CustomerRestServiceWithCompleteImplementation();}
}
