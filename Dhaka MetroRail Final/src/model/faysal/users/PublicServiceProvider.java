
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
public class PublicServiceProvider extends Employee implements Serializable, Countable{
    
    private static int userCount = 0;
    public static int itsTotalMember(){return userCount;}
    
    public PublicServiceProvider(){}

    public PublicServiceProvider(String coreUserType, String userIdentity, LocalDate dateOfJoining) {
        super(coreUserType, userIdentity, dateOfJoining);
        userCount++;
    }

    public PublicServiceProvider(String nid, String designation, LocalDate dateOfJoining, float salary, String fullName, String primaryMobile, String primaryEmail, String gender, String userIdentity, String coreUserType, String password, LocalDate dateOfBirth, Address address, boolean loginStatus) {
        super(nid, designation, dateOfJoining, salary, fullName, primaryMobile, primaryEmail, gender, userIdentity, coreUserType, password, dateOfBirth, address, loginStatus);
        userCount++;
    }

    public PublicServiceProvider(String nid, String designation, LocalDate dateOfJoining, float salary, String fullName, String primaryMobile, String primaryEmail, String gender, String userIdentity, String coreUserType, String password, LocalDate dateOfBirth, Address address, boolean loginStatus, String secondaryMobile, String secondaryEmail) {
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
    
        public static int getCountOfPublicServiceProvider()
    {
        ObservableList<PublicServiceProvider> sm = FXCollections.observableArrayList();
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        String path = "PublicServiceProviderObjects.bin";
        try {
                f = new File(path);
                fis = new FileInputStream(f);
                ois = new ObjectInputStream(fis);
                User tempUser = null;
                try {
                    while(true)
                        {
                        tempUser = (PublicServiceProvider) ois.readObject();
                        sm.add((PublicServiceProvider)tempUser);
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
    
        
    public static ObservableList<PublicServiceProvider> getAllPublicServiceProvider()
    {
        ObservableList<PublicServiceProvider> sm = FXCollections.observableArrayList();
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        String path = "PublicServiceProviderObjects.bin";
        try {
                f = new File(path);
                fis = new FileInputStream(f);
                ois = new ObjectInputStream(fis);
                User tempUser = null;
                try {
                    while(true)
                        {
                        tempUser = (PublicServiceProvider) ois.readObject();
                        sm.add((PublicServiceProvider)tempUser);
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

    @Override
    public int getTotalNoOfObjects() {
        return this.getTotalListOfObjects().size();
    }

    @Override
    public ObservableList<PublicServiceProvider> getTotalListOfObjects() {
        ObservableList<PublicServiceProvider> list = FXCollections.observableArrayList();
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        String path = "PublicServiceProvider.bin";
        try {
            f = new File(path);
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            PublicServiceProvider tempUser = null;
            try{
                System.out.println(" objects of SystemAdministrator");
                while(true){
                    tempUser = (PublicServiceProvider) ois.readObject();
                    //System.out.println(tempUser.toString());
                    list.add((PublicServiceProvider)tempUser);
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
    
}
