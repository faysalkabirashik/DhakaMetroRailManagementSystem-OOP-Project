
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package login.faysal;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.nayem.Passenger;

import javafx.fxml.Initializable;

import javafx.fxml.FXMLLoader;

public class LoginSceneController implements Initializable {

    @FXML    private TextField userIdentity_textField;
    @FXML    private PasswordField password_passField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void signUpOnAction(ActionEvent event) throws IOException 
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/nayem/passenger/SignupScene.fxml"));
        Parent parent = loader.load();
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene newScene = new Scene(parent);
        currentStage.setScene(newScene);
        currentStage.show();
    }

    @FXML
    private void loginButtonOnAction(ActionEvent event) throws IOException
    {
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        String pass;
        try {
            f = new File("PassegerData.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            Passenger passenger;
            try{
                while(true){
                    passenger = (Passenger)ois.readObject();
                    
                    System.out.println(passenger);
                    pass = passenger.getPassword();
                    System.out.println(pass);
                    System.out.println(password_passField.getText());
                    
                    if (passenger.getPassword().equals(password_passField.getText()))
                    {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/nayem/passenger/PassengerDashBoard.fxml"));
                        Parent parent = loader.load();
                        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        Scene newScene = new Scene(parent);
                        currentStage.setScene(newScene);
                        currentStage.show();
                    }
                }
            }
            catch(Exception e){
                //
            }      
        } catch (IOException ex) {
            System.out.println(ex.toString());
        } 
        finally {
            try {
                if(ois != null) ois.close();
            } catch (IOException ex) { }
        }
    }

    @FXML
    private void forgotButtonOnAction(ActionEvent event) {
    }
    
}
