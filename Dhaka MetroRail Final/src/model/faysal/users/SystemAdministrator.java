
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
import model.faysal.AlertGen;
import model.faysal.AppendableObjectOutputStream;
import model.faysal.Train;
import model.faysal.Validation;
import model.nayem.Passenger;
import model.nayem.TrainOperator;

/**
 *
 * @author Faysal Kabir Ashik
 */

public class SystemAdministrator extends Employee implements Serializable, Countable{
    
    //// field hidinhg/shawdowing.
    private static int userCount = 0;

    private boolean parentAdmin;

    public SystemAdministrator() {
    }
    
    

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
      
        path = path + ".bin";
       
        
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
    
    public  boolean addNewUser(User userToBeAdded, String userType, boolean areAllOptionalInfoGiven)    
    {
 
        String path2 = "";

        
        if (userType.equals("System Administrator"))
            {
                   path2 = "SystemAdministrator.bin"; 
            }
        else if (userType.equals("Station Manager"))
            {
                    path2 = "StationManager.bin"; 
            }
        else if (userType.equals( "Train Operator"))
            {
                    path2 = "TrainOperator.bin"; 
            }
        else if (userType.equals("Head of HR"))
            {
                    path2 = "HeadOfHR.bin"; 
            }
        else if (userType.equals("Maintenance Staff"))
            {
                    path2 = "MaintenanceStaff.bin"; 
            }
        else if (userType.equals("Public Service Provider"))
            {
                    path2 = "PublicServiceProvider.bin" ; 
            }
        else if (userType.equals("Accountant"))
            {
                    path2 =  "Accountant.bin"; 
            }
        else if (userType.equals("Passenger"))
            {
                    path2 =  "Passenger.bin"; 
            }

        
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        File f2 = null;
        FileOutputStream fos2 = null;      
        ObjectOutputStream oos2 = null;

        try {
            f = new File(path2);
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            f2 = new File("LoginInfoObjects.bin");
            if (f2.exists()) {
                fos2 = new FileOutputStream(f2, true);
                oos2 = new AppendableObjectOutputStream(fos2);
            } else {
                fos2 = new FileOutputStream(f2);
                oos2 = new ObjectOutputStream(fos2);
            }
            LoginInfo login = new LoginInfo(userToBeAdded.getUserIdentity(), userType, userToBeAdded.getPassword());
            oos.writeObject(userToBeAdded);
            oos2.writeObject(login);
            oos.close();
            oos2.close();
            System.out.println("Added");
            AlertGen.successfulAlert("User added successfully to bin");
            
            return true;
        } catch (IOException ex) {
            Logger.getLogger(SystemAdministrator.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
                if (oos2 != null) {
                    oos2.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(SystemAdministrator.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return false;
      
    }
    public  static int getCountOfSystemAdmins()
    {
        ObservableList<SystemAdministrator> admins = FXCollections.observableArrayList();
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        String path = "SystemAdministrator.bin";
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
    
    
    public  ObservableList<SystemAdministrator> getAllSystemAdmins()
    {
        ObservableList<SystemAdministrator> admins = FXCollections.observableArrayList();
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        String path = "SystemAdministrator.bin";
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
    
    public  String generateEmployeeID(String userType, LocalDate dateOfJoining)
    {   
        
        int total = -1;
        String year, label, key = userType;
        label = MAP_CLASSIFICATION_LABEL.get(key);
        System.out.println("This is all: " + label+ key + total);
        try{
            
            if (key != null && MAP_CLASSIFICATION_LABEL.containsKey(key)) 
            {        
                year = String.valueOf(dateOfJoining.getYear()).substring(2, 4);
                System.out.println("year: "+ year);
                switch (key) {
                case "System Administrator":
                    System.out.println("admin ");      
                    total = this.getTotalNoOfObjects();
                    System.out.println(total);
                    break;
                case "Station Manager":
                    System.out.println("MANAGER users: ");   
                    total =new StationManager().getTotalNoOfObjects() ;
                    System.out.println(total);
                    break;
                case "Train Operator":
                    System.out.println("train operator users: ");   
                    total = new TrainOperator().getTotalNoOfObjects();
                    System.out.println(total);
                    break;
                case "Head of HR":
                    System.out.println("HR users: ");   
                    total = new HeadOfHR().getTotalNoOfObjects();
                    System.out.println(total);
                    break;
                case "Maintenance Staff":
                    total = new MaintenanceStaff().getTotalNoOfObjects();
                    System.out.println(total);
                    break;
                case "Public Service Provider":
                    total = new PublicServiceProvider().getTotalNoOfObjects();
                    System.out.println(total);
                    break;
                case "Accountant":
                    total = new Accountant().getTotalNoOfObjects();
                    System.out.println(total);
                    break;
                default:
                    System.out.println("Default block");
                    System.out.println(total);
                    break;     
                }
                try{    
                    System.out.println("try 2");
                    String id = year + label;
                    total++;
                    System.out.println("initial id " + id);
                    if (total == 0){
                        System.out.println("total 0");     
                        id = id + "000";
                        System.out.println("id "+ id);
                    }else if( total < 10){     
                        id = id + "00" + String.valueOf(total);
                    }else if (total > 10 && total < 100){
                         id = id + "0" + String.valueOf(total);
                    }else{
                         id = id + String.valueOf(total);
                    }System.out.println(id);
                    return id;  
                    }catch(Exception ex){AlertGen.unsuccessfulAlert(ex.toString());}
                    
                }else{
                    AlertGen.unsuccessfulAlert("Couldn't generate ID");
                }
            }catch (Exception ex){AlertGen.unsuccessfulAlert(ex.toString());}
        if (total == -1){AlertGen.errorAlert("Error", "Something went wrong!");}
        return null;
    }
    public void addNewTrain(Train train){
        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            f = new File("TrainObjects");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }

            oos.writeObject(train);
        } catch (IOException iOExc) {
            Logger.getLogger(SystemAdministrator.class.getName()).log(Level.SEVERE, null, iOExc);
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException iOExc) {
                Logger.getLogger(SystemAdministrator.class.getName()).log(Level.SEVERE, null, iOExc);
            }

        }

    }

    @Override
    public int getTotalNoOfObjects() {
        return this.getTotalListOfObjects().size();
    }

    @Override
    public ObservableList<SystemAdministrator> getTotalListOfObjects() {
        ObservableList<SystemAdministrator> list = FXCollections.observableArrayList();
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        String path = "SystemAdministrator.bin";
        try {
            f = new File(path);
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            SystemAdministrator tempUser = null;
            try{
                System.out.println(" objects of SystemAdministrator");
                while(true){
                    tempUser = (SystemAdministrator) ois.readObject();
                    //System.out.println(tempUser.toString());
                    list.add((SystemAdministrator)tempUser);
                }
            }catch(IOException | ClassNotFoundException e){
                //System.out.println(e.toString());
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
        System.out.println(list );        
        return list;        

    }
    
       public static boolean checkUserExist( String idCheck) {
        
        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        String path = null;
        boolean foundFlag = false;
        
        ////////////////////////////////////////////////////
        if (Validation.allDigits(idCheck )){
            // i could have checked isValidUserIdentity() . but as it validate both for passenger and employee
            // I checked first it all digits -  to confirtm employee type then validate employee ID
            if (Validation.isValidUserIdentity(idCheck)){
                String empLabel = idCheck.substring(2, 4);
                switch (empLabel) {
                    case "00":
                        path = "SystemAdministrator.bin";
                        break;
                    case "01":
                        path = "StationManager.bin";
                        break;
                    case "02":
                        path = "TrainOperator.bin";
                        break;
                    case "03":
                        path = "HeadOfHR.bin";
                        break;
                    case "05":
                        path = "MaintenanceStaff.bin"; 
                        break;
                    case "06":
                        path = "PublicServiceProvider.bin";
                        break;
                    case "04":
                        path = "Accountant.bin";
                        break;
                    default:
                        break;
                } 
            }else {AlertGen.unsuccessfulAlert("Not valid employee ID!!"); return false;}
        } else if (Validation.isValidUsername(idCheck)){
            path = "Passenger.bin";
        } else {
            AlertGen.unsuccessfulAlert("invalid User Identity!!");
            return false;
        }
 
        ///////////////////////////////////////////////
        try {
            f = new File(path);
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            
            /////////////////////////////////////////////////                        
            try {
                System.out.println(" objects of SystemAdministrator");
                if (path.equals("SystemAdministrator.bin")) {
                    SystemAdministrator tempUser ;
                    while (true){
                        if (foundFlag == true){
                            System.out.println("user exists || System Admin");
                            break;
                        }
                        tempUser = (SystemAdministrator) ois.readObject();
                        if (idCheck.equals(tempUser.getUserIdentity())) {
                            foundFlag = true;
                            System.out.println(tempUser.getUserIdentity() +" = "+ idCheck);
                            return true;
                        }
                    }
                } else if (path.equals("StationManager.bin")) {
                    StationManager tempUser;
                    while (true){
                        if (foundFlag == true){
                            System.out.println("user exists || Station Manager");
                            break;
                        }
                        tempUser = (StationManager) ois.readObject();
                        if (idCheck.equals(tempUser.getUserIdentity())) {
                            foundFlag = true;
                            System.out.println(tempUser.getUserIdentity() +" = "+ idCheck);
                            return true;
                        }
                    }
                } else if (path.equals("Passenger.bin")) {
                    Passenger tempUser;
                    while (true){
                        if (foundFlag == true){
                            System.out.println("user exists || Passenger");
                            break;
                        }
                        tempUser = (Passenger) ois.readObject();
                        if (idCheck.equals(tempUser.getUserIdentity())) {
                            foundFlag = true;
                            System.out.println(tempUser.getUserIdentity() +" = "+ idCheck);
                            return true;
                        }
                    }
                    
                } else if (path.equals("TrainOperator.bin")) {
                    TrainOperator tempUser;
                    while (true){
                        if (foundFlag == true){
                            System.out.println("user exists || Train Operator");
                            break;
                        }
                        tempUser = (TrainOperator) ois.readObject();
                        if (idCheck.equals(tempUser.getUserIdentity())) {
                            foundFlag = true;
                            System.out.println(tempUser.getUserIdentity() +" = "+ idCheck);
                            return true;
                        }
                    }
                } else if (path.equals("HeadOfHR.bin")) {
                    HeadOfHR tempUser;
                    while (true){
                        if (foundFlag == true){
                            System.out.println("user exists || Head Of HR");
                            break;
                        }
                        tempUser = (HeadOfHR) ois.readObject();
                        if (idCheck.equals(tempUser.getUserIdentity())) {
                            foundFlag = true;
                            System.out.println(tempUser.getUserIdentity() +" = "+ idCheck);
                            return true;
                        }
                    }
                } else if (path.equals("Accountant.bin")) {
                    Accountant tempUser;
                    while (true){
                        if (foundFlag == true){
                            System.out.println("user exists || Accountant");
                            break;
                        }
                        tempUser = (Accountant) ois.readObject();
                        if (idCheck.equals(tempUser.getUserIdentity())) {
                            foundFlag = true;
                            System.out.println(tempUser.getUserIdentity() +" = "+ idCheck);
                            return true;
                        }
                    }
                } else if (path.equals("MaintenanceStaff.bin")) {
                   MaintenanceStaff tempUser;
                   while (true){
                        if (foundFlag == true){
                            System.out.println("user exists || MaintenanceS taff ");
                            break;
                        }
                        tempUser = (MaintenanceStaff) ois.readObject();
                        if (idCheck.equals(tempUser.getUserIdentity())) {
                            foundFlag = true;
                            System.out.println(tempUser.getUserIdentity() +" = "+ idCheck);
                            return true;
                        }
                    }
                } else if (path.equals("PublicServiceProvider.bin")){
                    PublicServiceProvider tempUser;
                    while (true){
                        if (foundFlag == true){
                            System.out.println("user exists || Public Service Provider");
                            break;
                        }
                        tempUser = (PublicServiceProvider) ois.readObject();
                        if (idCheck.equals(tempUser.getUserIdentity())) {
                            foundFlag = true;
                            System.out.println(tempUser.getUserIdentity() +" = "+ idCheck);
                            return true;
                        }
                    }
                }

                //System.out.println(tempUser.toString());
            } catch (IOException | ClassNotFoundException e) {
                //System.out.println(e.toString());
                System.out.println("IOException | ClassNotFoundException in reading bin file");
            }
            System.out.println("End of file\n");
            ////////////////////////////////////////////

        } catch (IOException ex) {
            System.out.println("IOException on entire file handling");
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException ex) {
            }
        }
        
        return foundFlag;

    }
    
    
    
    public static boolean checkUserExist(String userType, String idCheck) {
        
        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        String path = null;
        boolean foundFlag = false;
        if (userType.equals("System Administrator")) {
            path = "SystemAdministrator.bin";
        } else if (userType.equals("Station Manager")) {
            path = "StationManager.bin";
        } else if (userType.equals("Train Operator")) {
            path = "TrainOperator.bin";
        } else if (userType.equals("Head of HR")) {
            path = "HeadOfHR.bin";
        } else if (userType.equals("Maintenance Staff")) {
            path = "MaintenanceStaff.bin";
        } else if (userType.equals("Public Service Provider")) {
            path = "PublicServiceProvider.bin";
        } else if (userType.equals("Accountant")) {
            path = "Accountant.bin";
        } else if (userType.equals("Passenger")) {
            path = "Passenger.bin";
        }

        try {
            f = new File(path);
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            
            /////////////////////////////////////////////////                        
            try {
                System.out.println(" objects of SystemAdministrator");

                if (path.equals("SystemAdministrator.bin")) {
                    SystemAdministrator tempUser ;
                    while (true){
                        if (foundFlag == true){
                            System.out.println("user exists");
                            break;
                        }
                        tempUser = (SystemAdministrator) ois.readObject();
                        if (idCheck.equals(tempUser.getUserIdentity())) {
                            foundFlag = true;
                            System.out.println(tempUser.getUserIdentity() +" = "+ idCheck);
                            return true;
                        }
                    }
                } else if (path.equals("StationManager.bin")) {
                    StationManager tempUser;
                    while (true){
                        if (foundFlag == true){
                            System.out.println("user exists");
                            break;
                        }
                        tempUser = (StationManager) ois.readObject();
                        if (idCheck.equals(tempUser.getUserIdentity())) {
                            foundFlag = true;
                            System.out.println(tempUser.getUserIdentity() +" = "+ idCheck);
                            return true;
                        }
                    }
                } else if (path.equals("Passenger.bin")) {
                    Passenger tempUser;
                    while (true){
                        if (foundFlag == true){
                            System.out.println("user exists");
                            break;
                        }
                        tempUser = (Passenger) ois.readObject();
                        if (idCheck.equals(tempUser.getUserIdentity())) {
                            foundFlag = true;
                            System.out.println(tempUser.getUserIdentity() +" = "+ idCheck);
                            return true;
                        }
                    }
                    
                } else if (path.equals("TrainOperator.bin")) {
                    TrainOperator tempUser;
                    while (true){
                        if (foundFlag == true){
                            System.out.println("user exists");
                            break;
                        }
                        tempUser = (TrainOperator) ois.readObject();
                        if (idCheck.equals(tempUser.getUserIdentity())) {
                            foundFlag = true;
                            System.out.println(tempUser.getUserIdentity() +" = "+ idCheck);
                            return true;
                        }
                    }
                } else if (path.equals("HeadOfHR.bin")) {
                    HeadOfHR tempUser;
                    while (true){
                        if (foundFlag == true){
                            System.out.println("user exists");
                            break;
                        }
                        tempUser = (HeadOfHR) ois.readObject();
                        if (idCheck.equals(tempUser.getUserIdentity())) {
                            foundFlag = true;
                            System.out.println(tempUser.getUserIdentity() +" = "+ idCheck);
                            return true;
                        }
                    }
                } else if (path.equals("Accountant.bin")) {
                    Accountant tempUser;
                    while (true){
                        if (foundFlag == true){
                            System.out.println("user exists");
                            break;
                        }
                        tempUser = (Accountant) ois.readObject();
                        if (idCheck.equals(tempUser.getUserIdentity())) {
                            foundFlag = true;
                            System.out.println(tempUser.getUserIdentity() +" = "+ idCheck);
                            return true;
                        }
                    }
                } else if (path.equals("MaintenanceStaff.bin")) {
                   MaintenanceStaff tempUser;
                   while (true){
                        if (foundFlag == true){
                            System.out.println("user exists");
                            break;
                        }
                        tempUser = (MaintenanceStaff) ois.readObject();
                        if (idCheck.equals(tempUser.getUserIdentity())) {
                            foundFlag = true;
                            System.out.println(tempUser.getUserIdentity() +" = "+ idCheck);
                            return true;
                        }
                    }
                } else if (path.equals("PublicServiceProvider.bin")){
                    PublicServiceProvider tempUser;
                    while (true){
                        if (foundFlag == true){
                            System.out.println("user exists");
                            break;
                        }
                        tempUser = (PublicServiceProvider) ois.readObject();
                        if (idCheck.equals(tempUser.getUserIdentity())) {
                            foundFlag = true;
                            System.out.println(tempUser.getUserIdentity() +" = "+ idCheck);
                            return true;
                        }
                    }
                }

                //System.out.println(tempUser.toString());
            } catch (IOException | ClassNotFoundException e) {
                //System.out.println(e.toString());
                System.out.println("IOException | ClassNotFoundException in reading bin file");
            }
            System.out.println("End of file\n");
            ////////////////////////////////////////////

        } catch (IOException ex) {
            System.out.println("IOException on entire file handling");
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException ex) {
            }
        }
        
        return foundFlag;

    }

    
}
