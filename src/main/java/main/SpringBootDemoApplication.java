package main;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import config.AppConfig;
import config.PersistenceJPAConfig;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@ComponentScan(basePackageClasses = {AppConfig.class, PersistenceJPAConfig.class})
public class SpringBootDemoApplication {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(SpringBootDemoApplication.class);
        app.setDefaultProperties(Collections
                .singletonMap("server.port", "8080"));
        app.run(args);
    }
}
