/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package login.faysal;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Faysal Kabir Ashik
 */
public class LoginSceneController implements Initializable {

    @FXML
    private TextField userIdentity_textField;
    @FXML
    private PasswordField password_passField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void signUpOnAction(ActionEvent event) {
    }

    @FXML
    private void loginButtonOnAction(ActionEvent event) {
    }

    @FXML
    private void forgotButtonOnAction(ActionEvent event) {
    }
    
}
