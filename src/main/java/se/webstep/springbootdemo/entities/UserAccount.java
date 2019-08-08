package se.webstep.springbootdemo.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USER_ACCOUNT")
public class UserAccount {

    @Id
    @Column(name="USER_NAME")
    private String userName;

    @Column(name="ACCOUNT_CREATED_DATE")
    private Date accountCreatedDate;

    @Column(name="ACCOUNT_UPDATED_DATE")
    private Date accountUpdatedDate;

    @Column(name="PASSWORD")
    private String password;

    @Column(name="CUSTOMER_ID")
    private String customerId;

    public UserAccount(){

    }

    public UserAccount(Date accountCreatedDate, String userName, String password, String customerId) {
        this.accountCreatedDate = accountCreatedDate;
        this.userName = userName;
        this.password = password;
        this.customerId = customerId;
    }

    public Date getAccountCreatedDate() {
        return accountCreatedDate;
    }

    public void setAccountCreatedDate(Date accountCreatedDate) {
        this.accountCreatedDate = accountCreatedDate;
    }

    public Date getAccountUpdatedDate() {
        return accountUpdatedDate;
    }

    public void setAccountUpdatedDate(Date accountUpdatedDate) {
        this.accountUpdatedDate = accountUpdatedDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}
