package se.webstep.springbootdemo.validation;

import java.util.ArrayList;
import java.util.List;

public class PhonenumberValidator {
    private static final String phoneNumberRegularExpression="^(([+]\\d{2}[ ][1-9]\\d{0,2}[ ])|([0]\\d{1,3}[-]))((\\d{2}([ ]\\d{2}){2})|(\\d{3}([ ]\\d{3})*([ ]\\d{2})+))$";

    public static List<ValidationError> validateMobile(String mobileNumber){
        List<ValidationError> allValidationErrors=new ArrayList<>();

        if(!StringValidator.inputStringExistAndNotEmpty(mobileNumber)){
            allValidationErrors.add(new ValidationError(ValidationConstants.mandandoryFieldIsNotSet,"Mobile phone number must be entered","mobile","user"));
        }

        if(!mobileNumber.matches(phoneNumberRegularExpression)){
            allValidationErrors.add(new ValidationError(ValidationConstants.mobilePhonenumberInWrongFormat,String.format("Mobile phone number %s is in wrong format",mobileNumber),"mobile","user"));
        }
        return allValidationErrors;
    }

}
