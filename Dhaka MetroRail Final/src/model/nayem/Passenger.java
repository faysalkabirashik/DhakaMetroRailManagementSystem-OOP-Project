package model.nayem;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.faysal.Address;
import model.faysal.users.User;
import view.nayem.passenger.AppendableObjectOutputStream;



public class Passenger extends User{
    
    public static int userCount = 0;
    public static int itsTotalMember(){return userCount;}

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
    
    
    
    ////////////////////////////// getter setter//////////////////////
    //// all implemented in User class, so no need
    
    

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
}
