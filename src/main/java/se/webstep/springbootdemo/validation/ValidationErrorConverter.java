package se.webstep.springbootdemo.validation;

import java.util.List;

import org.springframework.boot.configurationprocessor.json.JSONArray;

public class ValidationErrorConverter {

    public static JSONArray convertValidatonErrorsToJSONArray(List<ValidationError> allValidationErrors){
        JSONArray validationErrorsAsJSONArray=new JSONArray();
        for(ValidationError validationError:allValidationErrors){
            validationErrorsAsJSONArray.put(validationError.toJson());
        }
        return  validationErrorsAsJSONArray;
    }

}
