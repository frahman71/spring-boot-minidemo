package se.webstep.demoapplication.service;

import static org.hamcrest.Matchers.is;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.junit4.SpringRunner;

import config.AppConfig;
import se.webstep.springbootdemo.entities.UserAccount;
import se.webstep.springbootdemo.services.UserAccountService;


@Profile("junittest")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {AppConfig.class, se.webstep.demoapplication.configuration.configuration.TestPersistanceJPAConfiguration.class})
public class UserAccountServiceTest {

    public final static String userAccountTestId="19700101-0123";
    public final static String userNameToTest="joetheman";

    @Autowired
    private UserAccountService userAccountService;

    private void initCustomerTestAccount(){
        UserAccount userAccount=new UserAccount(new Date(),userNameToTest,"totallysecret", userAccountTestId);
        userAccountService.registerNewAccount(userAccount);
    }


    @Before
    public void initTest(){
        initCustomerTestAccount();
    }

    @Test
    public void verifyThatUserAccountWasCreated(){
        List<UserAccount> allUserAccountsForTestCustomer=userAccountService.getAllUserAccountsForCustomer( userAccountTestId);
        Assert.assertThat(allUserAccountsForTestCustomer.size(),is(1));
        Assert.assertThat(allUserAccountsForTestCustomer.get(0).getCustomerId(),is(userAccountTestId));
        Assert.assertThat(allUserAccountsForTestCustomer.get(0).getUserName(),is(userNameToTest));
    }

    @After
    public void cleanupAfterTest(){
        userAccountService.deleteUserAccount(userNameToTest);
    }


}
