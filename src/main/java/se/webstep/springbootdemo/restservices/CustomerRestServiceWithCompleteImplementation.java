package se.webstep.springbootdemo.restservices;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import se.webstep.springbootdemo.entities.Customer;
import se.webstep.springbootdemo.helpers.JSONHelper;
import se.webstep.springbootdemo.model.PostStatusResponse;
import se.webstep.springbootdemo.services.CustomerService;
import se.webstep.springbootdemo.validation.CustomerValidator;
import se.webstep.springbootdemo.validation.SSNValidator;
import se.webstep.springbootdemo.validation.ValidationConstants;
import se.webstep.springbootdemo.validation.ValidationError;

@RestController
@RequestMapping("/customer")
public class CustomerRestServiceWithCompleteImplementation {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/getAllCustomers")
    public ResponseEntity getAllCustomers() {
        HttpHeaders httpHeaders=new HttpHeaders();
        return ResponseEntity.ok().headers(httpHeaders).body(customerService.getAllCustomers());
    }

    @PostMapping("/addCustomer")
    public ResponseEntity addCustomer(@RequestBody Customer customer) {
        List<ValidationError> allValidationErrors = new ArrayList<>();

        boolean customerIsValid = CustomerValidator.validateCustomer(customer, allValidationErrors);
        HttpHeaders httpHeaders=new HttpHeaders();

        if (customerIsValid) {
            customerService.registerNewCustomer(customer);

            PostStatusResponse customerStatusResponse=new PostStatusResponse(String.format("Kund med personnummer %s lades till !", customer.getCustomerId()),null);

            return ResponseEntity.status(HttpStatus.ACCEPTED).headers(httpHeaders)
                    .body(customerStatusResponse);
        } else {

            PostStatusResponse customerStatusResponse=new PostStatusResponse(String.format("Kund med personnummer %s kunde inte läggas till !", customer.getCustomerId()),allValidationErrors);

            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).headers(httpHeaders).body(customerStatusResponse);
        }
    }

    @DeleteMapping("/deleteCustomer/{customerSSN}")
    public ResponseEntity deleteCustomer(@PathVariable("customerSSN") String customerSSN) throws JSONException {
        List<ValidationError> allValidationErrors = new ArrayList<>();
        Customer customer = new Customer(customerSSN, "", "", "", "", "");

        boolean ssnIsValid = SSNValidator.validateSSN(customerSSN);

        boolean customerIsValid = true;

        if (ssnIsValid) {
            if (customerService.customerExists(customer)) {
                customerService.deleteCustomer(customer);
            } else {
                ValidationError customerDoesntExistValidationError = new ValidationError(ValidationConstants.customerDoesntExist,
                        String.format("Kund med personnummer %s existerar inte i databasen", customer.getCustomerId()), "SSN", "Customer");
                allValidationErrors.add(customerDoesntExistValidationError);
                customerIsValid = false;
            }
        } else {
            allValidationErrors.add(new ValidationError(ValidationConstants.SSNValidationFailedCode,
                    String.format("Personnumret %s är inte giltigt", customer.getCustomerId()), "SSN", "Customer"));
            customerIsValid = false;
        }

        if (customerIsValid) {
            String jsonResponse= JSONHelper.getJSONStringBasedOnInputString("deleteResponse",String.format("Kund med personnummer %s raderades från personregistret !", customer.getCustomerId()));
            return ResponseEntity.status(HttpStatus.OK).body(jsonResponse);
        } else {
            String validationErrorsAsJSON=JSONHelper.getJSONStringBasedOnObjectArrayAndStatus("validationErrors",allValidationErrors.toArray(),"deleteResponse",String.format("Radering av kund med personnummer %s misslyckades !", customer.getCustomerId()));

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(validationErrorsAsJSON);
        }

    }
}
