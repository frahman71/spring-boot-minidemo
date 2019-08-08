package se.webstep.springbootdemo.dao;

import java.util.List;

import se.webstep.springbootdemo.entities.UserAccount;

public interface UserAccountDAO {

    public void addUserAccount(UserAccount userAccount);
    public void updateUserAccount(UserAccount userAccount);
    public boolean userAccountForUserIdExists(String userName);
    public List<UserAccount> getAllUserAccountsForCustomer(String customerId);
    public void deleteUserAccountForCustomer(String userName);

}
