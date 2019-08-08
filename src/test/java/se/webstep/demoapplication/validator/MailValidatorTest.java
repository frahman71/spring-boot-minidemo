package se.webstep.demoapplication.validator;



import static org.hamcrest.Matchers.is;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import se.webstep.springbootdemo.validation.MailValidator;
import se.webstep.springbootdemo.validation.ValidationConstants;
import se.webstep.springbootdemo.validation.ValidationError;


public class MailValidatorTest {

    private final String badlyFormattedEmail="jkl_9wed@wqsqs";
    private final String correctlyFormattedEmail="test.testsson@test.nu";

    @Test
    public void verifyThatMailValidatorWillFailWrongFormatOnMailAddress(){
        List<ValidationError> allValidationErrors=new ArrayList<>();
        Assert.assertThat(MailValidator.mailAddressValidatesOK(allValidationErrors, badlyFormattedEmail),is(false));
        Assert.assertThat(allValidationErrors.size(),is(1));
        Assert.assertThat(allValidationErrors.get(0).getErrorCode(),is(ValidationConstants.emailAddressInWrongFormat));
    }

    @Test
    public void verifyThatMailValidatorWillSucceedOnCorrectFormat(){
        List<ValidationError> allValidationErrors=new ArrayList<>();
        Assert.assertThat(MailValidator.mailAddressValidatesOK(allValidationErrors,correctlyFormattedEmail),is(true));
        Assert.assertThat(allValidationErrors.size(),is(0));
    }

}
