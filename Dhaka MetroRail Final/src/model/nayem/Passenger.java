package model.nayem;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.faysal.Address;
import model.faysal.users.User;
import model.faysal.AppendableObjectOutputStream;



public class Passenger extends User implements Serializable{
    
    public static int userCount = 0;
    public static int itsTotalMember(){return userCount;}
    private String nid = null;
    private String birtCertificate = null;
    private float balance = 0;

    public Passenger(String coreUserType, String userIdentity) {
        super(coreUserType, userIdentity);
        userCount++;
    }

    public Passenger(String fullName, String primaryMobile, String primaryEmail, String gender, String userIdentity, String coreUserType, String password, LocalDate dateOfBirth, Address address, boolean loginStatus) {
        super(fullName, primaryMobile, primaryEmail, gender, userIdentity, coreUserType, password, dateOfBirth, address, loginStatus);
        userCount++;
    }

    public Passenger(String fullName, String primaryMobile, String primaryEmail, String gender, String userIdentity, String coreUserType, String password, LocalDate dateOfBirth, Address address, boolean loginStatus, String secondaryMobile, String secondaryEmail) {
        super(fullName, primaryMobile, primaryEmail, gender, userIdentity, coreUserType, password, dateOfBirth, address, loginStatus, secondaryMobile, secondaryEmail);
        userCount++;
    }

    public Passenger() {
    }

    ////////////////////////////// getter setter//////////////////////
    //// all implemented in User class, so no need   ////////////////
    /////////////////////////////////////////////////////////////////
    
    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public String getBirtCertificate() {
        return birtCertificate;
    }
 

    public void setBirtCertificate(String birtCertificate) {
        this.birtCertificate = birtCertificate;
    }

    @Override
    public void changePassword() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    
    public void submitReport(Feedback feedback)
    {
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;        
        try {
            f = new File("PassegerFeedback.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            oos.writeObject(feedback);

        } catch (IOException ex) {
            //
        }
    }
    
    public void reportLostAndFound(LostAndFound lostandfound)
    {
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;        
        try {
            f = new File("LostAndFound.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            oos.writeObject(lostandfound);

        } catch (IOException ex) {
            //
        }
    }
    
    public void loadDashBoard(ActionEvent event) throws IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/nayem/passenger/PassengerDashBoard.fxml"));
                        Parent parent = loader.load();
                        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        Scene newScene = new Scene(parent);
                        currentStage.setScene(newScene);
                        currentStage.show();
    }
    /////////////////// 
    
    public static int getCountOfPassenger()
    {
        ObservableList<Passenger> em = FXCollections.observableArrayList();
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        String path = "PassengerObjects.bin";
        try {
                f = new File(path);
                fis = new FileInputStream(f);
                ois = new ObjectInputStream(fis);
                User tempUser = null;
                try {
                    while(true)
                        {
                        tempUser = (Passenger) ois.readObject();
                        em.add((Passenger)      tempUser);
                        }
                    }
                catch(IOException | ClassNotFoundException e){}
            } 
        catch (IOException ex) {}
        finally {
                try {if(ois != null) ois.close();} 
                catch (IOException ex) { }
                }

        return em.size();
    }
    
    public static ObservableList<Passenger> getAllPassenger()
    {
        ObservableList<Passenger> em = FXCollections.observableArrayList();
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        String path = "PassengerObjects.bin";
        try {
                f = new File(path);
                fis = new FileInputStream(f);
                ois = new ObjectInputStream(fis);
                User tempUser = null;
                try {
                    while(true)
                        {
                        tempUser = (Passenger) ois.readObject();
                        em.add((Passenger)      tempUser);
                        }
                    }
                catch(IOException | ClassNotFoundException e){}
            } 
        catch (IOException ex) {}
        finally {
                try {if(ois != null) ois.close();} 
                catch (IOException ex) { }
                }

        return em;
    }  

    public void reportEmergency(Emergency emergency) 
    {
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;        
        try {
            f = new File("PassengerEmergency.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            oos.writeObject(emergency);

        } catch (IOException ex) {
            //
        }
    }

    @Override
    public int getTotalNoOfObjects() {
        return this.getTotalListOfObjects().size();
    }

    @Override
    public ObservableList<Passenger> getTotalListOfObjects() {
        ObservableList<Passenger> list = FXCollections.observableArrayList();
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        String path = "Passenger.bin";
        try {
            f = new File(path);
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            Passenger tempUser = null;
            try{
                System.out.println(" objects of SystemAdministrator");
                while(true){
                    tempUser = (Passenger) ois.readObject();
                    //System.out.println(tempUser.toString());
                    list.add((Passenger)tempUser);
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
