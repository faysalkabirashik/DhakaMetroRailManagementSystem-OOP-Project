/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.faysal;

import java.io.*;
import java.time.LocalDate;

/**
 *
 * @author Faysal Kabir Ashik
 */
public abstract class  User  implements Serializable {
    
    protected String fullName, primaryMobile,  primaryEmail, gender; 
    protected LocalDate dateOfBirth;
    protected String userType, userIdentity, password;
    
    protected Address address;
    protected String address2;
    protected boolean loginStatus;
    
    protected String secondaryMobile, secondaryEmail ;

    public User(String fullName, String primaryMobile, String primaryEmail, String gender, LocalDate dateOfBirth, String userType, String userIdentity, String password, Address address, boolean loginStatus) {
        this.fullName = fullName;
        this.primaryMobile = primaryMobile;
        this.primaryEmail = primaryEmail;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.userType = userType;
        this.userIdentity = userIdentity;
        this.password = password;
        this.address = address;
        this.loginStatus = loginStatus;
    }

    public User(String fullName, String primaryMobile, String primaryEmail, String gender, LocalDate dateOfBirth, String userType, String userIdentity, String password, Address address, boolean loginStatus, String secondaryMobile, String secondaryEmail) {
        this.fullName = fullName;
        this.primaryMobile = primaryMobile;
        this.primaryEmail = primaryEmail;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.userType = userType;
        this.userIdentity = userIdentity;
        this.password = password;
        this.address = address;
        this.loginStatus = loginStatus;
        this.secondaryMobile = secondaryMobile;
        this.secondaryEmail = secondaryEmail;
    }

    public User(String fullName, String primaryMobile, String primaryEmail, String gender, LocalDate dateOfBirth, String userType, String userIdentity, String password, String address2, boolean loginStatus) {
        this.fullName = fullName;
        this.primaryMobile = primaryMobile;
        this.primaryEmail = primaryEmail;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.userType = userType;
        this.userIdentity = userIdentity;
        this.password = password;
        this.address2 = address2;
        this.loginStatus = loginStatus;
    }

    
    public abstract void changePassword();
    public abstract void loginToDashboard();
    
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPrimaryMobile() {
        return primaryMobile;
    }

    public void setPrimaryMobile(String primaryMobile) {
        this.primaryMobile = primaryMobile;
    }

    public String getPrimaryEmail() {
        return primaryEmail;
    }

    public void setPrimaryEmail(String primaryEmail) {
        this.primaryEmail = primaryEmail;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserIdentity() {
        return userIdentity;
    }

    public void setUserIdentity(String userIdentity) {
        this.userIdentity = userIdentity;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public boolean isLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(boolean loginStatus) {
        this.loginStatus = loginStatus;
    }

    public String getSecondaryMobile() {
        return secondaryMobile;
    }

    public void setSecondaryMobile(String secondaryMobile) {
        this.secondaryMobile = secondaryMobile;
    }

    public String getSecondaryEmail() {
        return secondaryEmail;
    }

    public void setSecondaryEmail(String secondaryEmail) {
        this.secondaryEmail = secondaryEmail;
    }

    @Override
    public String toString() {
        return "User{" + "fullName=" + fullName + ", primaryMobile=" + primaryMobile + ", primaryEmail=" + primaryEmail + ", gender=" + gender + ", dateOfBirth=" + dateOfBirth + ", userType=" + userType + ", userIdentity=" + userIdentity + ", password=" + password + ", address=" + address + ", loginStatus=" + loginStatus + '}';
    }
    
    
    public String toString2() {
        return "User{" + "fullName=" + fullName + ", primaryMobile=" + primaryMobile + ", primaryEmail=" + primaryEmail + ", gender=" + gender + ", dateOfBirth=" + dateOfBirth + ", userType=" + userType + ", userIdentity=" + userIdentity + ", password=" + password + ", address=" + address + ", loginStatus=" + loginStatus + ", secondaryMobile=" + secondaryMobile + ", secondaryEmail=" + secondaryEmail + '}';
    }
    
}
