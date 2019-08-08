package se.webstep.springbootdemo.validation;

public class StringValidator {

    public static boolean inputStringExistAndNotEmpty(String inputString){
        return (inputString !=null && inputString.length()>0);
    }

    public static boolean inputStringDoesNotExceedMaxLength(String inputString,Integer maxLength){
        return (inputString !=null && inputString.length()<=maxLength);
    }
}
