package se.webstep.springbootdemo.validation;

import java.util.List;

public class FieldValidator {

    public static boolean validateInputIsSetAndLengthOK(List<ValidationError> validationErrors, String informationEntity,String fieldName, String fieldValue,int maxLength){
        boolean validatesOK=true;

        if(!StringValidator.inputStringExistAndNotEmpty(fieldValue)){
            validationErrors.add(new ValidationError(ValidationConstants.mandandoryFieldIsNotSet,fieldName+" cannot be empty",fieldName,informationEntity));
            validatesOK=false;
        }else if(!StringValidator.inputStringDoesNotExceedMaxLength(fieldValue, maxLength)){
            validationErrors.add(new ValidationError(ValidationConstants.fieldExceedsMaxlength,String.format(fieldName+" is not allowed to be more than %d characters", maxLength),fieldName,informationEntity));
            validatesOK=false;
        }
        return validatesOK;
    }

}
