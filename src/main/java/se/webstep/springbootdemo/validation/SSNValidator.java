package se.webstep.springbootdemo.validation;

public class SSNValidator {

    private final static String ssnPattern = "([0-9]{6}|[0-9]{8})-[0-9]{4}";

    public static boolean validateSSN(String ssn){
        return ssn.matches(ssnPattern);
    }
}
