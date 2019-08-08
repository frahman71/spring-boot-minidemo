package se.webstep.springbootdemo.model;

import java.util.List;

import se.webstep.springbootdemo.validation.ValidationError;

public class PostStatusResponse {
    private String addResponse;
    private List<ValidationError> validationErrors;

    public PostStatusResponse(String addResponse, List<ValidationError> validationErrors) {
        this.addResponse = addResponse;
        this.validationErrors = validationErrors;
    }

    public String getAddResponse() {
        return addResponse;
    }

    public void setAddResponse(String addResponse) {
        this.addResponse = addResponse;
    }

    public List<ValidationError> getValidationErrors() {
        return validationErrors;
    }

    public void setValidationErrors(List<ValidationError> validationErrors) {
        this.validationErrors = validationErrors;
    }
}
