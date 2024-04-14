
package model.faysal.users;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.faysal.Address;
import model.faysal.AppendableObjectOutputStream;
import model.nayem.TrainOperator;

/**
 *
 * @author Faysal Kabir Ashik
 */

public class SystemAdministrator extends Employee implements Serializable, Countable{
    
    //// field hidinhg/shawdowing.
    private static int userCount = 0;

    private boolean parentAdmin;

    public SystemAdministrator(String coreUserType, String userIdentity, LocalDate dateOfJoining) {
        super(coreUserType, userIdentity, dateOfJoining);
        userCount++;
    }

    public SystemAdministrator(String nid, String designation, LocalDate dateOfJoining, float salary, String fullName, String primaryMobile, String primaryEmail, String gender, String userIdentity, String coreUserType, String password, LocalDate dateOfBirth, Address address, boolean loginStatus) {
        super(nid, designation, dateOfJoining, salary, fullName, primaryMobile, primaryEmail, gender, userIdentity, coreUserType, password, dateOfBirth, address, loginStatus);
        userCount++;
    }

    public SystemAdministrator(String nid, String designation, LocalDate dateOfJoining, float salary, String fullName, String primaryMobile, String primaryEmail, String gender, String userIdentity, String coreUserType, String password, LocalDate dateOfBirth, Address address, boolean loginStatus, String secondaryMobile, String secondaryEmail) {
        super(nid, designation, dateOfJoining, salary, fullName, primaryMobile, primaryEmail, gender, userIdentity, coreUserType, password, dateOfBirth, address, loginStatus, secondaryMobile, secondaryEmail);
        userCount++;
    }
    
    
    
    @Override
    public void changeDesignation() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void applyForLeave() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void changePassword() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    /////// getter setter to string //////////

    public boolean isParentAdmin() {
        return parentAdmin;
    }

    public void setParentAdmin(boolean parentAdmin) {
        this.parentAdmin = parentAdmin;
    }

    
    
    ///////////////////////////////////////////////////////////////////////////////////
    
    public static int itsTotalMember()
    {
        return userCount;
    }
    
    // I could have write in a method for writing. but I wanted to understand.
    
    // create user instance
    // I can make it as static but it would not be appropriate
    // since by whom admin it is created needs to be check
    // there will be a signature that this admin has created this particular user
    public  boolean createNewUserInstance(User userToBeAdded, String userType, boolean areAllOptionalInfoGiven)    
    {
        // this is desiged in a way thet as the User handle is given, so user must exist
        // then userType must exist
        // hence path will exist too
        
        String path = "";
        
        
        // first check if it's not a passenger then extra file as employee needed to be created to trac employee
        
        if ( !userType.equals( "Passenger"))
            {
            // then the user must be employee, either admin or other type
            // so there will be additional employee file handle 
            File fileEmployee = null;
            FileOutputStream fosEmployee = null;
            ObjectOutputStream oosEmployee = null;
            
            try {
                fileEmployee = new File("EmployeeObjects.bin");
                if (fileEmployee.exists())
                    {
                        fosEmployee = new FileOutputStream(fileEmployee, true);
                        oosEmployee = new AppendableObjectOutputStream(fosEmployee);     
                    }
                else{
                        fosEmployee = new FileOutputStream(fileEmployee);
                        oosEmployee = new ObjectOutputStream(fosEmployee);                   
                    }

                 oosEmployee.writeObject(userToBeAdded);
                        
                }
            catch (IOException iOExc)
                {
                    Logger.getLogger(SystemAdministrator.class.getName()).log(Level.SEVERE, null, iOExc);
                }
            finally
                {
                    try {
                            if (oosEmployee !=null )
                                {
                                    oosEmployee.close();
                                }
                        }
                    catch (IOException iOExc){
                             Logger.getLogger(SystemAdministrator.class.getName()).log(Level.SEVERE, null, iOExc);
                                
                        }
                        
                }
            } // outer if ends
        /*
        if (userType.equals("System Administrator"))
            {
                   path = "SystemAdministrator"; 
            }
        else if (userType.equals("Station Manager"))
            {
                    path = "StationManager"; 
            }
        else if (userType.equals( "Train Operator"))
            {
                    path = "TrainOperator"; 
            }
        else if (userType.equals("Head of HR"))
            {
                    path = "HeadOfHR"; 
            }
        else if (userType.equals("Maintenance Staff"))
            {
                    path = "MaintenanceStaff"; 
            }
        else if (userType.equals("Public Service Provider"))
            {
                    path = "PublicServiceProvider" ; 
            }
        else if (userType.equals("Accountant"))
            {
                    path =  "Accountant"; 
            }
        else if (userType.equals("Passenger"))
            {
                    path =  "Passenger"; 
            }
            */
        
        path = userToBeAdded.getClass().getSimpleName() + "Objects.bin";
        
        File fUser = null;
        FileOutputStream fosUser = null;
        ObjectOutputStream oosUser = null;
        
        File fLoginInfo = null;
        FileOutputStream fosLoginInfo = null;
        ObjectOutputStream oosLoginInfo = null;
        
        File f  = null;
        FileOutputStream fos  = null;
        ObjectOutputStream oos = null;
        
        try {
            fUser = new File("UserObjects.bin");
            if (fUser.exists())
                {
                    fosUser = new FileOutputStream(fUser, true);
                    oosUser = new AppendableObjectOutputStream(fosUser);     
                }
            else{
                    fosUser = new FileOutputStream(fUser);
                    oosUser = new ObjectOutputStream(fosUser);                   
                }
            
            fLoginInfo = new File("LoginInfoObjects.bin");
            if (fLoginInfo.exists())
                {
                    fosLoginInfo = new FileOutputStream(fLoginInfo, true);
                    oosLoginInfo = new AppendableObjectOutputStream(fosLoginInfo);     
                }
            else{
                    fosLoginInfo = new FileOutputStream(fLoginInfo);
                    oosLoginInfo = new ObjectOutputStream(fosLoginInfo);                   
                }

            f = new File(path);
            if(f.exists())
                {
                    fos = new FileOutputStream(f,true);
                    oos = new AppendableObjectOutputStream(fos);                
                }
            else{
                    fos = new FileOutputStream(f);
                    oos = new ObjectOutputStream(fos);               
                }
            
            /// writitng obj
            
            
            LoginInfo temp = new LoginInfo(userToBeAdded.getUserIdentity(), userToBeAdded.getCoreUserType(), userToBeAdded.getPassword());
            
            oosUser.writeObject(userToBeAdded);
            oos.writeObject(userToBeAdded);
            oosLoginInfo.writeObject(temp);
            return true;

            }
        catch (IOException iOExc)
            {
                Logger.getLogger(SystemAdministrator.class.getName()).log(Level.SEVERE, null, iOExc);
            }
        finally
            {
                try {
                        if (oosUser !=null )
                            {
                                oosUser.close();
                            }
                        if (oosLoginInfo !=null )
                            {
                                oosLoginInfo.close();
                            }
                        if (oos !=null )
                            {
                                oos.close();
                            }
                                                
                    }
                catch (IOException iOExc)
                    {
                         Logger.getLogger(SystemAdministrator.class.getName()).log(Level.SEVERE, null, iOExc);
                    }

            }
        return false;
        
    }
    
    public static int getCountOfSystemAdmins()
    {
        ObservableList<SystemAdministrator> admins = FXCollections.observableArrayList();
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        String path = "SystemAdministratorObjects.bin";
        try {
                f = new File(path);
                fis = new FileInputStream(f);
                ois = new ObjectInputStream(fis);
                User tempUser = null;
                try {
                    while(true)
                        {
                        tempUser = (SystemAdministrator) ois.readObject();
                        admins.add((SystemAdministrator) tempUser);
                        }
                    }
                catch(IOException | ClassNotFoundException e){}
            } 
        catch (IOException ex) {}
        finally {
                try {if(ois != null) ois.close();} 
                catch (IOException ex) { }
                }

        return admins.size();
    }
    
    
    public static ObservableList<SystemAdministrator> getAllSystemAdmins()
    {
        ObservableList<SystemAdministrator> admins = FXCollections.observableArrayList();
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        String path = "SystemAdministratorObjects.bin";
        try {
                f = new File(path);
                fis = new FileInputStream(f);
                ois = new ObjectInputStream(fis);
                User tempUser = null;
                try {
                    while(true)
                        {
                        tempUser = (SystemAdministrator) ois.readObject();
                        admins.add((SystemAdministrator) tempUser);
                        }
                    }
                catch(IOException | ClassNotFoundException e){}
            } 
        catch (IOException ex) {}
        finally {
                try {if(ois != null) ois.close();} 
                catch (IOException ex) { }
                }

        return admins;
    }
    
    public  String generateEmployeeID(String userSelectedOptionFromcomBoxStringValue, LocalDate dateOfJoining)
    {   
        try{
            String key = userSelectedOptionFromcomBoxStringValue;
            if (key != null && MAP_CLASSIFICATION_LABEL.containsKey(key)) 
                {        
                    String  year = String.valueOf(dateOfJoining.getYear()).substring(2,4);
                    String label = MAP_CLASSIFICATION_LABEL.get(key);
                    int total = 0;
                    switch (key) {
                        case "System Administrator":
                            total = SystemAdministrator.getCountOfSystemAdmins();
                            break;
                        case "Station Manager":
                            total =StationManager.getCountOfStationManager() ;
                            break;
                        case "Train Operator":
                            total = TrainOperator.getCountOfTrainOperator();
                            break;
                        case "Head of HR":
                            total = HeadOfHR.getCountOfHeadOfHR();
                            break;
                        case "Maintenance Staff":
                            total = MaintenanceStaff.getCountOfMaintenanceStaff();
                            break;
                        case "Public Service Provider":
                            total = PublicServiceProvider.getCountOfPublicServiceProvider();
                            break;
                        case "Accountant":
                            total = Accountant.getCountOfAccountant();
                            break;
                        default:
                            break;
                    }
                    
                    String id = year + label;
                    if( total < 10){
                         id = id + "00" + String.valueOf(total);
                        }
                     else if (total > 10 && total < 100){
                         id = id + "0" + String.valueOf(total);
                        } 
                     else{
                         id = id + String.valueOf(total);
                        }
                    return id;    
                }
            }
        catch (Exception ex){}
        return null;
    }
    /*
    public Employee createEmployeeInstance(String employeeType ){
        
        Employee empObj;
                                        boolean flag;
                                        switch (employeeType) {
                                            case "System Administrator":
                                                empObj = new SystemAdministrator( 
                                                        nid,
                                                        employeeType,
                                                        joiningDate,
                                                        1000000,   fullName,
                                                        primMobile,
                                                        primEmail,
                                                        gender, 
                                                        employeeID,
                                                        employeeType, 
                                                        pass,   doB,   
                                                        address, 
                                                        true);
                                                flag = this.admin.createNewUserInstance(empObj, empObj.getCoreUserType(), true);
                                                
                                                break;
                                            case "Station Manager":
                                                empObj = new StationManager( 
                                                        nid,
                                                        employeeType,
                                                        joiningDate,
                                                        1000000,   fullName,
                                                        primMobile,
                                                        primEmail,
                                                        gender, 
                                                        employeeID,
                                                        employeeType, 
                                                        pass,   doB,   
                                                        address, 
                                                        true);
                                                flag = this.admin.createNewUserInstance(empObj, empObj.getCoreUserType(), true);    
                                                break;
                                            case "Train Operator":
                                                empObj = new TrainOperator( 
                                                        nid,
                                                        employeeType,
                                                        joiningDate,
                                                        1000000,   fullName,
                                                        primMobile,
                                                        primEmail,
                                                        gender, 
                                                        employeeID,
                                                        employeeType, 
                                                        pass,   doB,   
                                                        address, 
                                                        true);
                                                flag = this.admin.createNewUserInstance(empObj, empObj.getCoreUserType(), true);
                                                break;
                                            case "Head of HR":
                                                empObj = new HeadOfHR( 
                                                        nid,
                                                        employeeType,
                                                        joiningDate,
                                                        1000000,   fullName,
                                                        primMobile,
                                                        primEmail,
                                                        gender, 
                                                        employeeID,
                                                        employeeType, 
                                                        pass,   doB,   
                                                        address, 
                                                        true);
                                                flag = this.admin.createNewUserInstance(empObj, empObj.getCoreUserType(), true);
                                                break;
                                            case "Maintenance Staff":
                                                empObj = new MaintenanceStaff( 
                                                        nid,
                                                        employeeType,
                                                        joiningDate,
                                                        1000000,   fullName,
                                                        primMobile,
                                                        primEmail,
                                                        gender, 
                                                        employeeID,
                                                        employeeType, 
                                                        pass,   doB,   
                                                        address, 
                                                        true);
                                                flag = this.admin.createNewUserInstance(empObj, empObj.getCoreUserType(), true);
                                                break;
                                            case "Public Service Provider":
                                                empObj = new PublicServiceProvider( 
                                                        nid,
                                                        employeeType,
                                                        joiningDate,
                                                        1000000,   fullName,
                                                        primMobile,
                                                        primEmail,
                                                        gender, 
                                                        employeeID,
                                                        employeeType, 
                                                        pass,   doB,   
                                                        address, 
                                                        true);
                                                flag = this.admin.createNewUserInstance(empObj, empObj.getCoreUserType(), true);
                                                break;
                                            case "Accountant":
                                                empObj = new Accountant( 
                                                        nid,
                                                        employeeType,
                                                        joiningDate,
                                                        1000000,   fullName,
                                                        primMobile,
                                                        primEmail,
                                                        gender, 
                                                        employeeID,
                                                        employeeType, 
                                                        pass,   doB,   
                                                        address, 
                                                        true);
                                                flag = this.admin.createNewUserInstance(empObj, empObj.getCoreUserType(), true);
                                                break;
                                            default: flag = false;
                                                    empObj = null;
                                                break;
        
        return empObj;
    
    }*/
    
}
