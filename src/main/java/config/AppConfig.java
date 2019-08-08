package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import se.webstep.springbootdemo.dao.CustomerDAO;
import se.webstep.springbootdemo.dao.CustomerDAOImpl;
import se.webstep.springbootdemo.dao.SystemPriviledgesDAO;
import se.webstep.springbootdemo.dao.SystemPriviledgesDAOImpl;
import se.webstep.springbootdemo.dao.UserAccountDAO;
import se.webstep.springbootdemo.dao.UserAccountDAOImpl;
import se.webstep.springbootdemo.restservices.CustomerRestServiceWithCompleteImplementation;
import se.webstep.springbootdemo.restservices.CustomerRestServiceWithEmptyMethods;
import se.webstep.springbootdemo.services.CustomerService;
import se.webstep.springbootdemo.services.SystemPriviledgeService;
import se.webstep.springbootdemo.services.UserAccountService;

@Configuration
public class AppConfig {

    //Register internal services here
    @Bean
    public SystemPriviledgeService systemPriviledgeService() { return new SystemPriviledgeService();}


    @Bean
    public UserAccountService userAccountService() { return new UserAccountService();}

    @Bean
    public CustomerService customerService() {
        return new CustomerService();
    }




    //Register DAO-components here
    @Bean
    SystemPriviledgesDAO systemPriviledgesDAO() {
        return new SystemPriviledgesDAOImpl();
    }



    @Bean
    UserAccountDAO userAccountDAO() {return new UserAccountDAOImpl();}

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
