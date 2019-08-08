package se.webstep.springbootdemo.validation;

import java.util.List;

import se.webstep.springbootdemo.entities.Customer;


public class CustomerValidator {

    /**
     * Validate all form parameters set on Customer object
     * @param customer
     * @param validationErrors
     * @return
     */
    public static boolean validateCustomer(Customer customer, List<ValidationError> validationErrors){
        boolean validationSucceeded=true;

        if(!SSNValidator.validateSSN(customer.getCustomerId())){
            validationErrors.add(new ValidationError(ValidationConstants.SSNValidationFailedCode,String.format("Personnumret %s är inte giltigt",customer.getCustomerId()),"SSN","Customer"));
            validationSucceeded=false;
        }

        if(!StringValidator.inputStringExistAndNotEmpty(customer.getFirstName())){
            validationErrors.add(new ValidationError(ValidationConstants.mandandoryFieldIsNotSet,"Förnamn måste anges","Firstname","Customer"));
            validationSucceeded=false;
        }

        if(!StringValidator.inputStringDoesNotExceedMaxLength(customer.getFirstName(),50)){
            validationErrors.add(new ValidationError(ValidationConstants.fieldExceedsMaxlength,String.format("Förnamnet %s överskrider tillåten längd",customer.getFirstName()),"Firstname","Customer"));
            validationSucceeded=false;
        }

        if(!StringValidator.inputStringExistAndNotEmpty(customer.getSurName())){
            validationErrors.add(new ValidationError(ValidationConstants.mandandoryFieldIsNotSet,"Efternamn måste anges","Surname","Customer"));
            validationSucceeded=false;
        }

        if(!StringValidator.inputStringDoesNotExceedMaxLength(customer.getSurName(),50)){
            validationErrors.add(new ValidationError(ValidationConstants.fieldExceedsMaxlength,String.format("Efternamnet %s överskrider tillåten längd",customer.getSurName()),"Surname","Customer"));
            validationSucceeded=false;
        }

        if(!StringValidator.inputStringExistAndNotEmpty(customer.getPostalCode())){
            validationErrors.add(new ValidationError(ValidationConstants.mandandoryFieldIsNotSet,"Postnummer måste anges","PostalCode","Customer"));
            validationSucceeded=false;
        }

        if(!AddressValidator.hasValidPostalCode(customer.getPostalCode())){
            validationErrors.add(new ValidationError(ValidationConstants.postalCodeInWrongFormat,String.format("Postnumret %s har fel format", customer.getPostalCode()),"PostalCode","Customer"));
            validationSucceeded=false;
        }

        return validationSucceeded;
    }

}
