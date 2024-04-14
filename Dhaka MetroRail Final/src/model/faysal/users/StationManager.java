 
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
public class StationManager extends Employee implements Serializable , Countable{
    
    //// field hidinhg/shawdowing.
    private static int userCount = 0;
    public static int itsTotalMember(){return userCount;}

    public StationManager() {
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
    
        
}
