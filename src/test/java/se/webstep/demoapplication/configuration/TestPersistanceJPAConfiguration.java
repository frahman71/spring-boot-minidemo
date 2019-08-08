package se.webstep.demoapplication.configuration.configuration;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@ActiveProfiles("junittest")
@Configuration
@EnableTransactionManagement
public class TestPersistanceJPAConfiguration {

    @Bean
    public EntityManagerFactory entityManagerFactory() {
        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("hsqldbtest");
        return entityManagerFactory;
    }

    @Bean
    public PlatformTransactionManager transactionManager(){
        JpaTransactionManager transactionManager
                = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory());
        return transactionManager;
    }
}
