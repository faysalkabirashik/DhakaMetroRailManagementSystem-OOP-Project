package model.faysal.users;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.time.LocalDate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.faysal.Address;

/**
 *
 * @author Faysal Kabir Ashik
 */
public abstract class  User implements Serializable, Countable {
    
    private static int  userCount = 0;
    
    public String fullName, primaryMobile, primaryEmail;
    public final String gender;
                          
    protected final String userIdentity, coreUserType;  
    protected String password;
    
    protected LocalDate dateOfBirth;  
    protected Address address;

    protected boolean loginStatus;
    
    protected String secondaryMobile, secondaryEmail ; // Optional

    
    public abstract void changePassword();
    public static int totalUser(){return userCount;}

    
    ///////////// constructors///////////////
    public User(String coreUserType, String userIdentity) {
        this.coreUserType = coreUserType;
        this.userIdentity = userIdentity;
        this.gender = null;
        userCount++;
        
    }

    public User() {
    }

    
    
    // for passenger they will have have userName as userID will not be all numeric, optional field will not be provided
    
    // if they don't want to give secondary info
    public User(String fullName, String primaryMobile, String primaryEmail, String gender, String userIdentity, String coreUserType, String password, LocalDate dateOfBirth, Address address, boolean loginStatus) {
        this.fullName = fullName;
        this.primaryMobile = primaryMobile;
        this.primaryEmail = primaryEmail;
        this.gender = gender;
        this.userIdentity = userIdentity;
        this.coreUserType = coreUserType;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.loginStatus = loginStatus;
        userCount++;
    }
    
    public User(String fullName, String primaryMobile, String primaryEmail, String gender, String userIdentity, String coreUserType, String password, LocalDate dateOfBirth, Address address, boolean loginStatus, String secondaryMobile, String secondaryEmail) {
        this.fullName = fullName;
        this.primaryMobile = primaryMobile;
        this.primaryEmail = primaryEmail;
        this.gender = gender;
        this.userIdentity = userIdentity;
        this.coreUserType = coreUserType;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.loginStatus = loginStatus;
        this.secondaryMobile = secondaryMobile;
        this.secondaryEmail = secondaryEmail;
        userCount++;
    }

    
    ////////// getter setter to string//////////////    

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
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
    

    // getters of final fields
    public String getGender() {
        return gender;
    }

    public String getUserIdentity() {
        return userIdentity;
    }

    public String getCoreUserType() {
        return coreUserType;
    }
    

    @Override
    public String toString() {
        return "User{" + "fullName=" + fullName + ", primaryMobile=" + primaryMobile + ", primaryEmail=" + primaryEmail + ", gender=" + gender + ", userIdentity=" + userIdentity + ", coreUserType=" + coreUserType + ", password=" + password + ", dateOfBirth=" + dateOfBirth + ", address=" + address + '}';
    }
    
    /// own method ///////////

    
        public static int getCountOfAllTypeOfUsers()
    {
        ObservableList<User> allUsers = FXCollections.observableArrayList();
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        String path = "UserObjects.bin";
        try {
                f = new File(path);
                fis = new FileInputStream(f);
                ois = new ObjectInputStream(fis);
                User tempUser = null;
                try {
                    while(true)
                        {
                        tempUser = (User) ois.readObject();
                        allUsers.add((User)tempUser);
                        }
                    }
                catch(IOException | ClassNotFoundException e){}
            } 
        catch (IOException ex) {}
        finally {
                try {if(ois != null) ois.close();} 
                catch (IOException ex) { }
                }

        return allUsers.size();
    }
        
    public static ObservableList<User> getAllUsers(){
        ObservableList<User> users = FXCollections.observableArrayList();
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        String path = "UserObjects.bin";
        try {
            f = new File(path);
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            User tempUser = null;
            try {
                while(true){
                    tempUser = (User) ois.readObject();
                    users.add((User)tempUser);
                    }
                }
            catch(IOException | ClassNotFoundException e){}
            } 
        catch (IOException ex) {}
        finally {
                try {if(ois != null) ois.close();} 
                catch (IOException ex) { }
                }
        return users;
    }    
        
        
}
