package se.webstep.springbootdemo.validation;

import java.util.List;

public class MailValidator {

    private static final String mailValidationPattern="^[\\w-\\.]+@[a-zA-Z]+?\\.[a-zA-Z]{2,3}$";

    public static boolean mailAddressValidatesOK(List<ValidationError> allValidationErrors, String mailAddress){

        if(FieldValidator.validateInputIsSetAndLengthOK(allValidationErrors,"User","mail",mailAddress,255)) {
            if (!mailAddress.matches(mailValidationPattern)) {
                allValidationErrors.add(new ValidationError(ValidationConstants.emailAddressInWrongFormat,
                        "Email address in wrong format, verify that the format name.surname@orgname.topname is used", "mail", "user"));
                return false;
            }else{
               return true;
            }
        }else{
            allValidationErrors.add(new ValidationError(ValidationConstants.mandandoryFieldIsNotSet,"Email address must be given","mail","user"));
            return false;
        }
    }

}
