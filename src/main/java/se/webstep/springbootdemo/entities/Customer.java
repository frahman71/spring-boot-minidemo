package se.webstep.springbootdemo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMER")
public class Customer {
    @Id
    @Column(name="CUSTOMER_ID")
    private String customerId;
    @Column(name="FIRST_NAME")
    private String firstName;
    @Column(name="SURNAME")
    private String surName;
    @Column(name="ADDRESS")
    private String address;
    @Column(name="POSTAL_ADDRESS")
    private String postalAddress;
    @Column(name="POSTAL_NUMBER")
    private String postalCode;


    public Customer(){

    }

    public Customer(String customerId, String firstName, String surName, String address, String postalAddress, String postalCode) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.surName = surName;
        this.address = address;
        this.postalAddress = postalAddress;
        this.postalCode = postalCode;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(String postalAddress) {
        this.postalAddress = postalAddress;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
