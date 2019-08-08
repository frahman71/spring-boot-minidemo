package se.webstep.springbootdemo.validation;

import java.util.List;

import se.webstep.springbootdemo.model.User;

public class UserValidator {

    private final static Integer usernameMaxLength=20;
    private final static Integer mobileNumberMaxLength=20;
    private final static Integer realNameMaxLength=100;


    public static boolean userValidatesOK(List<ValidationError> validationErrors, User user){

        boolean userValidatesOK=true;


        if(!FieldValidator.validateInputIsSetAndLengthOK(validationErrors,"User","username",user.getUserName(),usernameMaxLength)){
            userValidatesOK=false;
        }

        if(!FieldValidator.validateInputIsSetAndLengthOK(validationErrors,"User","Real name",user.getRealName(),realNameMaxLength)){
            userValidatesOK=false;
        }

        if(!FieldValidator.validateInputIsSetAndLengthOK(validationErrors,"User","Mobile",user.getMobile(),20)){
            userValidatesOK=false;
        }

        if(!MailValidator.mailAddressValidatesOK(validationErrors,user.getMail())){
            userValidatesOK=false;
        }

        return userValidatesOK;
    }

}
