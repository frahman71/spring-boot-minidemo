package se.webstep.springbootdemo.validation;

public class ValidationConstants {

    //Field related
    public final static Integer mandandoryFieldIsNotSet=102;
    public final static Integer fieldExceedsMaxlength=103;

    //Address related
    public final static Integer postalCodeInWrongFormat=201;
    public final static Integer emailAddressInWrongFormat=202;
    public final static Integer mobilePhonenumberInWrongFormat=203;

    //Customer related
    public final static Integer SSNValidationFailedCode=301;
    public final static Integer customerAlreadyExists=302;
    public final static Integer customerDoesntExist=303;

}
