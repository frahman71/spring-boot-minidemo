package se.webstep.springbootdemo.validation;

public class AddressValidator {

    private final static String postalCodePattern="[0-9]{3}\\s?[0-9]{2}";

    public static boolean hasValidPostalCode(String postalCode){
        return postalCode !=null && postalCode.matches(postalCodePattern);
    }
}
