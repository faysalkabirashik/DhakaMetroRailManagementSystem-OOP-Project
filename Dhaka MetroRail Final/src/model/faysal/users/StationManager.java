 
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
            
}
