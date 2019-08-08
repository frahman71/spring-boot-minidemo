package se.webstep.springbootdemo.validation;

import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;

public class ValidationError {
    private Integer errorCode;
    private String errorText;
    private String inputField;
    private String informationEntity;

    public ValidationError(Integer errorCode, String errorText, String inputField, String informationEntity) {
        this.errorCode = errorCode;
        this.errorText = errorText;
        this.inputField = inputField;
        this.informationEntity = informationEntity;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorText() {
        return errorText;
    }

    public void setErrorText(String errorText) {
        this.errorText = errorText;
    }

    public void setInputField(String inputField) {
        this.inputField=inputField;
    }

    public String getInputField(){
        return this.inputField;
    }


    public String getInformationEntity() {
        return informationEntity;
    }

    public void setInformationEntity(String informationEntity) {
        this.informationEntity = informationEntity;
    }

    public String toString(){
        return String.format("Valideringsfel med felkod [%s], för inputfält [%s] och objekt [%s] med feltexten: %s",getErrorCode(), getInputField(),getInformationEntity(),getErrorText());
    }

    public JSONObject toJson(){
        JSONObject jsonObject=new JSONObject();

        try {
            jsonObject.put("errorCode",errorCode);

        jsonObject.put("errorText",errorText);
        jsonObject.put("inputField",inputField);
        jsonObject.put("informationEntity",informationEntity);

        return jsonObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
