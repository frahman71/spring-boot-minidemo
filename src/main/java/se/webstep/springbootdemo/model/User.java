package se.webstep.springbootdemo.model;

import java.util.Date;

public class User {
    private Date createdDate;
    private String userName;
    private String realName;
    private String mail;
    private String mobile;
    private String userRole;

    public User(String userName, String userRole, String realName, String mobile, String mail, Date createdDate){
        this.userName=userName;
        this.userRole=userRole;
        this.realName=realName;
        this.mobile=mobile;
        this.mail=mail;
        this.createdDate=createdDate;
    }


    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getUserRole(){
        return this.userRole;
    }

    public void setUserRole(String userRole){
        this.userRole=userRole;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }


    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public boolean equals(Object o){
        User compareUser=(User) o;
        return (compareUser !=null && this.userName.equals(compareUser.userName));
    }
}
