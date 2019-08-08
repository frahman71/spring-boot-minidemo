package se.webstep.demoapplication.validator;

import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import se.webstep.springbootdemo.entities.Customer;
import se.webstep.springbootdemo.validation.CustomerValidator;
import se.webstep.springbootdemo.validation.ValidationConstants;
import se.webstep.springbootdemo.validation.ValidationError;


public class CustomerValidatorTest {

    private String validCustomerSSN = "19910101-0552";
    private String validCustomerFirstname = "Nils";
    private String validCustomerSurname = "Persson";
    private String validAddress = "Testgatan 1";
    private String validPostalAddress = "Testholmen";
    private String validPostalCode = "112 03";

    private Customer getMockedCustomerWithValidDetails() {
        Customer customer = new Customer(validCustomerSSN, validCustomerFirstname, validCustomerSurname, validAddress, validPostalAddress,
                validPostalCode);
        return customer;
    }

    private Customer getMockedCustomerWithInvalidSSN() {
        Customer customer = new Customer("1991-12-1x", validCustomerFirstname, validCustomerSurname, validAddress, validPostalAddress,
                validPostalCode);
        return customer;
    }


    private Customer getMockedCustomerWithEmtpySurname() {
        Customer customer = new Customer(validCustomerSSN, validCustomerFirstname, "", validAddress, validPostalAddress, validPostalCode);
        return customer;
    }

    private Customer getMockedCustomerWithInvalidPostalCode() {
        Customer customer = new Customer(validCustomerSSN, validCustomerFirstname, validCustomerSurname, validAddress, validPostalAddress, "123r56");
        return customer;
    }


    @Test
    public void verifyThatValidCustomerShouldGiveNoValidationErrors() {
        List<ValidationError> allValidationErrors = new ArrayList<>();
        Customer customerWIthValidDetails = getMockedCustomerWithValidDetails();

        boolean customerIsValid = CustomerValidator.validateCustomer(customerWIthValidDetails, allValidationErrors);

        Assert.assertThat(customerIsValid, is(true));
        Assert.assertThat(allValidationErrors, is(empty()));
    }

    @Test
    public void verifyThatNonValidSSNShouldResultInValidationFailure() {
        List<ValidationError> allValidationErrors = new ArrayList<>();
        Customer customerWithInvalidSSN = getMockedCustomerWithInvalidSSN();

        boolean customerIsValid = CustomerValidator.validateCustomer(customerWithInvalidSSN, allValidationErrors);

        Assert.assertThat(customerIsValid, is(false));
        Assert.assertThat(allValidationErrors, hasSize(1));
        ValidationError validationError = allValidationErrors.get(0);
        Assert.assertThat(validationError.getErrorCode(), is(ValidationConstants.SSNValidationFailedCode));
    }


    @Test
    public void verifyThatEmptySurnameShouldResultInValidationFailure() {
        List<ValidationError> allValidationErrors = new ArrayList<>();
        Customer customerWithEmptySurname = getMockedCustomerWithEmtpySurname();

        boolean customerIsValid = CustomerValidator.validateCustomer(customerWithEmptySurname, allValidationErrors);

        Assert.assertThat(customerIsValid, is(false));
        Assert.assertThat(allValidationErrors, hasSize(1));
        Assert.assertThat(allValidationErrors.get(0).getErrorCode(), is(ValidationConstants.mandandoryFieldIsNotSet));
    }

    @Test
    public void verifyThatInvalidPostalCodeResultsInValidationFailure() {
        List<ValidationError> allValidationErrors = new ArrayList<>();
        Customer customerWithInvalidPostalCode = getMockedCustomerWithInvalidPostalCode();

        boolean customerIsValid = CustomerValidator.validateCustomer(customerWithInvalidPostalCode, allValidationErrors);

        Assert.assertThat(customerIsValid, is(false));
        Assert.assertThat(allValidationErrors, hasSize(1));
        Assert.assertThat(allValidationErrors.get(0).getErrorCode(), is(ValidationConstants.postalCodeInWrongFormat));
    }
}
