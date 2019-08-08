package se.webstep.demoapplication.service;


import static org.hamcrest.Matchers.is;

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
import se.webstep.springbootdemo.entities.SystemPriviledge;
import se.webstep.springbootdemo.services.SystemPriviledgeService;


@Profile("junittest")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {AppConfig.class, se.webstep.demoapplication.configuration.configuration.TestPersistanceJPAConfiguration.class})
public class SystemPriviledgesTest {

    public final String roleNameToTest="THE_ROLE_TO_TEST";
    public final String addedAdminFunctionToTest="ADD_USER";

    @Autowired
    SystemPriviledgeService systemPriviledgeService;

    public void setupTestPriviledges(){
        SystemPriviledge systemPriviledge=new SystemPriviledge();
        systemPriviledge.setRoleName(roleNameToTest);
        systemPriviledge.setPriviledgeDescription("Superuser or administrator with full permissions");
        systemPriviledge.setSystemFunctionName(addedAdminFunctionToTest);
        systemPriviledgeService.addSystemPriviledge(systemPriviledge);
    }

    @Before
    public void initTest(){
        setupTestPriviledges();
    }

    @Test
    public void verifyThatSystemPriviledgesCouldBeFetched(){
        List<SystemPriviledge> allPriviledges= systemPriviledgeService.getAllSystemPriviledgesForRole(roleNameToTest);
        Assert.assertThat(allPriviledges.size(),is(1));
        Assert.assertThat(allPriviledges.get(0).getSystemFunctionName(),is(addedAdminFunctionToTest));
    }


    @After
    public void cleanupTest(){

        List<SystemPriviledge> allPriviledges=systemPriviledgeService.getAllSystemPriviledgesForRole(roleNameToTest);

        SystemPriviledge systemPriviledge=!allPriviledges.isEmpty() ? allPriviledges.get(0) : null;

        if(systemPriviledge !=null) {
            systemPriviledgeService.removePriviledgeWithPriviledgeId(systemPriviledge.getPriviledgeId());
        }
    }
}
