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
import model.faysal.AlertGen;
import model.nayem.Passenger;
import model.nayem.TrainOperator;

/**
 *
 * @author Faysal Kabir Ashik
 */
public abstract class  User implements Serializable, Countable {
    
    private static int  userCount = 0;
    
    public String fullName, primaryMobile, primaryEmail;
//    public final String gender;
    public String gender;
//    protected final String userIdentity, coreUserType;  
    protected String userIdentity, coreUserType;
    protected String password;

    protected LocalDate dateOfBirth;
    protected Address address;

    protected boolean loginStatus;

    protected String secondaryMobile, secondaryEmail; // Optional

    
    public abstract void changePassword();
    public abstract int getTotalNoOfObjects();
    public abstract ObservableList<?> getTotalListOfObjects();
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
                            System.out.println("added");
                        }
                    }
                catch(IOException | ClassNotFoundException e){}
            } 
        catch (IOException ex) {}
        finally {
                try {if(ois != null) ois.close();} 
                catch (IOException ex) { }
                }
            System.out.println(allUsers);
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
    
    public static User getObject(String userIdentity){
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
 
        try {
            f = new File("UserObjects.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            User tempUser = null;
            try{
                System.out.println("showing user objects");
                while(true){
                    tempUser = (User) ois.readObject();
                    if (tempUser.getUserIdentity().equals(userIdentity)){
                        System.out.println("User found");
                        System.out.println(tempUser.toString());
                        return tempUser;
                    }
                }
            }
            catch(IOException | ClassNotFoundException e){}
             
        } catch (IOException ex) {}

        finally {
            try {
                if(ois != null) ois.close();
            } catch (IOException ex) { }
        }
        return null;
    }
    
      public static User getObjectV2(String id, String type){
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        String path = "";
        switch(type){
            case "Passenger":
                path="Passenger.bin";
                break;
            case  "System Administrator":
                path="SystemAdministrator.bin";
                break;
            case "Station Manager":
                path="StationManager.bin";
                break;
            case "Train Operator":
                path="TrainOperator.bin";
                break;
            case "Head of HR":
                path="HeadOfHR.bin";
                break;
            case "Maintenance Staff":
                path="MaintenanceStaff.bin";
                break;
            case "Public Service Provider":
                path="PublicServiceProvider.bin";
                break;
            case "Accountant":
                path="Accountant.bin";
                break;
        }
        
        try {
            f = new File(path);
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            User tempUser = null;
            try{
                System.out.println("Printing user objects");
                while(true){
                    switch(type){
                        case "Accountant": 
                            tempUser = (Accountant) ois.readObject();
                            System.out.println("1");
                            System.out.println(tempUser.toString());
                            break;
                        case "Passenger": 
                            tempUser = (Passenger) ois.readObject();
                            System.out.println("Reading pat");
                            System.out.println(tempUser.toString());
                            break;
                        case "System Administrator": 
                            tempUser = (SystemAdministrator) ois.readObject();
                            System.out.println("Reading pharma");
                            System.out.println(tempUser.toString());
                            break;
                        case "Station Manager": 
                            tempUser = (StationManager) ois.readObject();
                            System.out.println("Reading nurse");
                            System.out.println(tempUser.toString());
                            break;
                        case "Train Operator": 
                            tempUser = (TrainOperator) ois.readObject();                            
                            System.out.println("Reading director");
                            System.out.println(tempUser.toString());
                            break;
                        case "Head of HR": 
                            tempUser = (HeadOfHR) ois.readObject();
                            System.out.println("Reading accounts");
                            System.out.println(tempUser.toString());
                            break;
                        case "Maintenance Staff": 
                            tempUser = (MaintenanceStaff) ois.readObject();
                            System.out.println("Reading HR");
                            System.out.println(tempUser.toString());
                            break;
                        case "Public Service Provider": 
                            tempUser = (PublicServiceProvider) ois.readObject();
                            System.out.println("Reading technician");
                            System.out.println(tempUser.toString());
                            break;
                    }
                    if ( id.equals(tempUser.getUserIdentity() )){
                        System.out.println("User found");
 
                        System.out.println(tempUser.toString());
                        return tempUser;
                    }
                }
            }
            catch(IOException | ClassNotFoundException e){
                System.out.println(e.toString());
                System.out.println("IOException | ClassNotFoundException in reading bin file");
            }
            System.out.println("End of file\n");
        } catch (IOException ex) {
            System.out.println("IOException on entire file handling");
        }
        finally {
            try {
                if(ois != null) ois.close();
            } catch (IOException ex) { }
        }
        return null;
    }
    
      
    public static String verifyLogin(String idcheck, String passcheck){
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        int idflag=0;
        int passflag=0;
        String userType = null ;
        try {
            f = new File("LoginInfoObjects.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            LoginInfo tempLogin;
            try{
                System.out.println("Printing login objects");           

                while(true){
                    if (idflag==1){                        
                        System.out.println("User found");
                            break;
                                }
                    tempLogin = (LoginInfo) ois.readObject();
                    System.out.println(tempLogin.toString());
                    if (idcheck.equals(tempLogin.getUserIdentity())){
                        System.out.println("idflag");
                        System.out.println(idflag);
                        idflag=1;
                        if (passcheck.equals(tempLogin.getPassword())){
                            passflag=1;
                            if (tempLogin.getUserType().equals("Passenger")) {
                                userType = "07"; return userType;
                            }      
                            else if (   tempLogin.getUserType().equals("System Administrator")   )
                            {
                                userType = "00";return userType;
                            } else if (tempLogin.getUserType().equals("Station Manager")) {
                                userType = "01"; return userType;
                            } else if (tempLogin.getUserType().equals("Train Operator")) {
                                userType = "02"; return userType;
                            } else if (tempLogin.getUserType().equals("Head of HR")) {
                                userType = "03"; return userType;
                            } else if (tempLogin.getUserType().equals("Accountant")) {
                                userType = "04"; return userType;
                            } else if (tempLogin.getUserType().equals("Maintenance Staff")) {
                                userType = "05"; return userType;
                            } else if (tempLogin.getUserType().equals("Public Service Provider")) {
                                userType = "06"; return userType;
                            }
                            else{}
                            
                        }
                    }
                }
            }
            catch(IOException | ClassNotFoundException e){
                e.toString();
            }
            System.out.println("End of file\n");
            
            if (idflag==1){
                if(passflag==1){
 
                    return userType;
                }
                else{AlertGen.unsuccessfulAlert(("No such user"));return "Wrong Pass";}
               
            }
            else{AlertGen.unsuccessfulAlert(("No such user"));return "Not found";}
                
        
        } catch (IOException ex) {
            System.out.println("IOException on entire file handling");
            return null;
        }
        finally {
            try {
                if(ois != null) ois.close();
                return userType;
            } catch (IOException ex) { ex.toString();}
        }
       
    }
        
}
