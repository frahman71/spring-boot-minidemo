package se.webstep.springbootdemo.restservices;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer/emptymethods")
public class CustomerRestServiceWithEmptyMethods {

    @RequestMapping("/getAllCustomers")
    public ResponseEntity getAllCustomers(){
        return ResponseEntity.ok().body("Running HTTP GET for all Customers");
    }

    @PostMapping("/addCustomer")
    public ResponseEntity addCustomer(){
        return ResponseEntity.ok().body("Running HTTP POST for adding one Customer");
    }

    @PutMapping("/updateCustomer")
    public ResponseEntity updateCustomer(){
        return ResponseEntity.ok().body("Running HTTP PUT for updating one Customer");
    }

    @DeleteMapping("/deleteCustomer")
    public ResponseEntity deleteCustomer(){
        return ResponseEntity.ok().body("Running HTTP DELETE for deleting one Customer");
    }

}
