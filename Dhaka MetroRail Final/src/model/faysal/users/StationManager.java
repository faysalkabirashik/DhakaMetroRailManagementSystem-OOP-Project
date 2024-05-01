 
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
import model.faysal.Report;
import model.faysal.ResourceRequest;
import model.faysal.Train;
import model.faysal.users.Countable;
import model.faysal.users.Employee;
import model.faysal.users.SystemAdministrator;
import model.faysal.users.User;

/**
 *
 * @author Faysal Kabir Ashik
 */
public class StationManager extends Employee implements Serializable , Countable{
    
    //// field hidinhg/shawdowing.
    private static int userCount = 0;
    public static int itsTotalMember(){return userCount;}
    private int noOfEmpManaged;

    
    public StationManager() {
    }

    public StationManager(int noOfEmpManaged, String nid, String designation, LocalDate dateOfJoining, float salary, String fullName, String primaryMobile, String primaryEmail, String gender, String userIdentity, String coreUserType, String password, LocalDate dateOfBirth, Address address, boolean loginStatus) {
        super(nid, designation, dateOfJoining, salary, fullName, primaryMobile, primaryEmail, gender, userIdentity, coreUserType, password, dateOfBirth, address, loginStatus);
        this.noOfEmpManaged = noOfEmpManaged;
    }
    
    

    public StationManager(String coreUserType, String userIdentity, LocalDate dateOfJoining) {
        super(coreUserType, userIdentity, dateOfJoining);
        userCount++;
    }

    public StationManager(String nid, String designation, LocalDate dateOfJoining, float salary, String fullName, String primaryMobile, String primaryEmail, String gender, String userIdentity, String coreUserType, String password, LocalDate dateOfBirth, Address address, boolean loginStatus) {
        super(nid, designation, dateOfJoining, salary, fullName, primaryMobile, primaryEmail, gender, userIdentity, coreUserType, password, dateOfBirth, address, loginStatus);
        userCount++;
    }

    public StationManager(String nid, String designation, LocalDate dateOfJoining, float salary, String fullName, String primaryMobile, String primaryEmail, String gender, String userIdentity, String coreUserType, String password, LocalDate dateOfBirth, Address address, boolean loginStatus, String secondaryMobile, String secondaryEmail) {
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

    public int getNoOfEmpManaged() {
        return noOfEmpManaged;
    }

    public void setNoOfEmpManaged(int noOfEmpManaged) {
        this.noOfEmpManaged = noOfEmpManaged;
    }

    @Override
    public String toString() {
        return "StationManager{" + "noOfEmpManaged=" + noOfEmpManaged + '}';
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public LocalDate getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(LocalDate dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

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

    public String getUserIdentity() {
        return userIdentity;
    }

    public void setUserIdentity(String userIdentity) {
        this.userIdentity = userIdentity;
    }

    public String getCoreUserType() {
        return coreUserType;
    }

    public void setCoreUserType(String coreUserType) {
        this.coreUserType = coreUserType;
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



    
/////////////////////////////////////////////////////////////////////
    
        public static int getCountOfStationManager()
    {
        ObservableList<StationManager> sm = FXCollections.observableArrayList();
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        String path = "StationManagerObjects.bin";
        try {
                f = new File(path);
                fis = new FileInputStream(f);
                ois = new ObjectInputStream(fis);
                User tempUser = null;
                try {
                    while(true)
                        {
                        tempUser = (StationManager) ois.readObject();
                        sm.add((StationManager)tempUser);
                        }
                    }
                catch(IOException | ClassNotFoundException e){}
            } 
        catch (IOException ex) {}
        finally {
                try {if(ois != null) ois.close();} 
                catch (IOException ex) { }
                }

        return sm.size();
    }
    
    
    public static ObservableList<StationManager> getAllStationManager()
    {
        ObservableList<StationManager> sm = FXCollections.observableArrayList();
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        String path = "StationManagerObjects.bin";
        try {
                f = new File(path);
                fis = new FileInputStream(f);
                ois = new ObjectInputStream(fis);
                User tempUser = null;
                try {
                    while(true)
                        {
                        tempUser = (StationManager) ois.readObject();
                        sm.add((StationManager)tempUser);
                        }
                    }
                catch(IOException | ClassNotFoundException e){}
            } 
        catch (IOException ex) {}
        finally {
                try {if(ois != null) ois.close();} 
                catch (IOException ex) { }
                }

        return sm;
    }
    
        public void makeReport(String title, String message) {

        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {

            f = new File("StationReport.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }

            Report report = new Report(title, message);
            oos.writeObject(report);

        } catch (IOException iOExc) {
                Logger.getLogger(StationManager.class.getName()).log(Level.SEVERE, null, iOExc);
            }
        finally
            {
                try { if (oos !=null ){  oos.close(); }
                }
                catch (IOException iOExc)
                    {
                         Logger.getLogger(SystemAdministrator.class.getName()).log(Level.SEVERE, null, iOExc);
                    }     

            }
 
    }
    
    public void requestResource(String id, String name,  String message) {

        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {

            f = new File("ResourceRequests.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }

            ResourceRequest req = new ResourceRequest(id,name, message);
            oos.writeObject(req);

        } catch (IOException iOExc) {
                Logger.getLogger(StationManager.class.getName()).log(Level.SEVERE, null, iOExc);
            }
        finally
            {
                try { if (oos !=null ){  oos.close(); }
                }
                catch (IOException iOExc)
                    {
                         Logger.getLogger(SystemAdministrator.class.getName()).log(Level.SEVERE, null, iOExc);
                    }     

            }
 
    }

    @Override
    public int getTotalNoOfObjects() {
        return this.getTotalListOfObjects().size();
    }
    ////////////////////// modification method //////////////
    @Override
    public ObservableList<StationManager> getTotalListOfObjects() {
        ObservableList<StationManager> list = FXCollections.observableArrayList();
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        String path = "StationManager.bin";
        try {
            f = new File(path);
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            StationManager tempUser = null;
            try{
                System.out.println(" objects of StaitonManagers");
                while(true){
                    tempUser = (StationManager) ois.readObject();
                    //System.out.println(tempUser.toString());
                    list.add((StationManager)tempUser);
                }
            }
            catch(IOException | ClassNotFoundException e){
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
        System.out.println(list);        
        return list;        

    }   
    
    
    //////////////////   
    
    
    
}
