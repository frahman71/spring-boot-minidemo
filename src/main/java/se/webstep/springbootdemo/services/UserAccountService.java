package se.webstep.springbootdemo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import se.webstep.springbootdemo.dao.UserAccountDAO;
import se.webstep.springbootdemo.entities.UserAccount;


@Service
public class UserAccountService {

    @Autowired
    UserAccountDAO userAccountDAO;

    public void registerNewAccount(UserAccount userAccount){
        userAccountDAO.addUserAccount(userAccount);
    }

    public void updateUserAccount(UserAccount userAccount){
        userAccountDAO.updateUserAccount(userAccount);
    }

    public boolean userAccountExist(String userName){
        return userAccountDAO.userAccountForUserIdExists(userName);
    }

    public List<UserAccount> getAllUserAccountsForCustomer(String customerId){
        return userAccountDAO.getAllUserAccountsForCustomer(customerId);
    }

    public void deleteUserAccount(String userName){
        userAccountDAO.deleteUserAccountForCustomer(userName);
    }
}
