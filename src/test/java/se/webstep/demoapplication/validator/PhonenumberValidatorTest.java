package se.webstep.demoapplication.validator;

import static org.hamcrest.Matchers.is;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import se.webstep.springbootdemo.validation.PhonenumberValidator;
import se.webstep.springbootdemo.validation.ValidationConstants;
import se.webstep.springbootdemo.validation.ValidationError;


public class PhonenumberValidatorTest {

    private static final String badlyFormattedPhonenumber="07d78293´234";
    private static final String correctlyFormattedPhonenumber="+46 10 100 10 00";

    @Test
    public void verifyThatBadlyFormattedPhonenumberGenerateValidationError(){
        List<ValidationError> allValidationErrors= PhonenumberValidator.validateMobile(badlyFormattedPhonenumber);
        Assert.assertThat(allValidationErrors.size(),is(1));
        Assert.assertThat(allValidationErrors.get(0).getErrorCode(),is(ValidationConstants.mobilePhonenumberInWrongFormat));
    }

    @Test
    public void verifyThatCorrectlyFormattedPhonenumberShouldPass() {
        List<ValidationError> allValidationErrors = PhonenumberValidator.validateMobile(correctlyFormattedPhonenumber);
        Assert.assertThat(allValidationErrors.size(), is(0));
    }

}
