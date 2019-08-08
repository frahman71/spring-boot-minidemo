package se.webstep.demoapplication.validator;

import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import se.webstep.springbootdemo.model.User;
import se.webstep.springbootdemo.validation.UserValidator;
import se.webstep.springbootdemo.validation.ValidationError;


public class UserValidatorTest {

    public User createMockedUserWithCorrectDetails(){
        return new User("testuser","normal_user","Test Testsson","+46 010 10 10 10","test.mail@mailhost.com",new Date());
    }


    @Test
    public void verifyThatUserWithCorrectUserDetailsWillPassValidation(){
        List<ValidationError> allValidationErrors=new ArrayList<>();
        Assert.assertThat(UserValidator.userValidatesOK(allValidationErrors,createMockedUserWithCorrectDetails()),is(true));
        Assert.assertThat(allValidationErrors,is(empty()));
    }

    @Test
    public void verifyThatUserWithNoUserNameWillFail(){
        List<ValidationError> allValidationErrors=new ArrayList<>();
        User user=createMockedUserWithCorrectDetails();
        user.setUserName(null);

        Assert.assertThat(UserValidator.userValidatesOK(allValidationErrors,user),is(false));
        Assert.assertThat(allValidationErrors.size(),is(1));
    }

}
