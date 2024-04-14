
package login.faysal;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.fxml.Initializable;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import model.faysal.AlertGen;
import model.faysal.Validation;
import model.nayem.Passenger;
import model.nayem.TrainOperator;
import javafx.scene.layout.AnchorPane;
import model.faysal.AlertGen;
import model.faysal.Validation;

/**
 * FXML Controller class
 *
 * @author Faysal Kabir Ashik
 */
public class LoginSceneController implements Initializable {

    @FXML    private TextField userIdentity_textField;
    @FXML    private PasswordField password_passField;
    @FXML    private AnchorPane forgotPass_anchorPane;
    @FXML    private TextField forgetAnchorPane_userIdentity_textField;
    @FXML    private TextField forgetAnchorPane_email_textField;
    @FXML    private Label lopinInfo_label;
    TrainOperator to = new TrainOperator();
    Passenger passen = new Passenger();
    @FXML
    private AnchorPane login_anchorPane;
 
 
  
 
    @FXML    private Label show_label;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        forgotPass_anchorPane.setVisible(false);
        forgotPass_anchorPane.setDisable(true);
        show_label.setText("");
    }    


//    private void loginButtonOnAction(ActionEvent event) throws IOException 
//    {
//        //to.loadDashBoard(event);
//        passen.loadDashBoard(event);
        @FXML
    private void loginButtonOnAction(ActionEvent event) {
        
     if (userIdentity_textField.getText() == null || userIdentity_textField.getText().trim().isEmpty())
     {
            show_label.setText("UserIdentity field is empty!");
             AlertGen.inforamtion("","UserIdentity field is empty!");
     }
  
     else 
     {
         if (password_passField.getText() == null || password_passField.getText().trim().isEmpty()) 
         {
            show_label.setText("Password field is empty!");
            AlertGen.inforamtion("","Password not given");
            
         }
         else
         {
                String   userID = (userIdentity_textField.getText().trim());
                String pass =  password_passField.getText().trim();
                if (Validation.allDigits((userID)))
                {
                    ///checking for employ 
                    if (Validation.isValisUserIdentity(userID))
                    {
                        
                        if (Validation.isValidPassword(pass))
                        {
                        show_label.setText("Checking for verificaiton....");
                        ////////////////////////////////////////////////////////////
                        
                        
                        
                        
                        }
                        ////////////////////////////////////////////////////////////
                        else{
                        AlertGen.unsuccessfulAlert("Not a valid password given");
                        }
                        
                    }
                    else
                    {
                        AlertGen.unsuccessfulAlert("Not a valid UserIdentity");
                    }
                }
                else
                {
                    ////////////// checking for passenger ///////////////////////////////////// verification
                    if (Validation.isValidUsername(userID) && Validation.isValidPassword(pass))
                    {
                        AlertGen.inforamtion("Successfull" , "You have to wait! An Email will be sent or Contact Admin");

                    ////////// only for passenger, just verify that user exist, and correct pass
                    /////////// then 
                    
                    
                    
                    }
                    /////////////////////////////////////////////////////////////////////////////////////
                    else{
                    AlertGen.unsuccessfulAlert("Not valid entry. Please check!");
                    }
                }
         }
       
     }   
        
    }

    @FXML
    private void forgotButtonOnAction(ActionEvent event) {
        
        forgotPass_anchorPane.setDisable(false);
        forgotPass_anchorPane.setVisible(true);
        
    }

    @FXML
    private void signUpOnAction(ActionEvent event) {
        
    }

    @FXML
    private void getPassButtonOnAction(ActionEvent event) {
        
        if (forgetAnchorPane_userIdentity_textField.getText() == null || forgetAnchorPane_userIdentity_textField.getText().trim().isEmpty())
            {
            show_label.setText("UserIdentity field is empty!");
            }

        else 
            {
            
            if (forgetAnchorPane_email_textField.getText() == null || forgetAnchorPane_email_textField.getText().trim().isEmpty())
                {
                show_label.setText("Email field is empty!");
                }

            else
            {
              // neither one empty
                // check validat
               String   userID = (forgetAnchorPane_userIdentity_textField.getText().trim());
               String email =  forgetAnchorPane_email_textField.getText().trim();
                if (Validation.allDigits((userID)))
                {
                    if (Validation.isValisUserIdentity(userID))
                    {
                        
                        if (Validation.isValidEmail(email)){
                        AlertGen.inforamtion("Successfull" , "You have to wait! An Email will be sent or Contact Admin");
                        }
                        else{
                        AlertGen.unsuccessfulAlert("Not a valid email");
                        }
                        
                    }
                    else
                    {
                        AlertGen.unsuccessfulAlert("Not a valid UserIdentit");
                    }
                }
                else
                {
                    if (Validation.isValidUsername(userID) && Validation.isValidEmail(email))
                    {
                    AlertGen.inforamtion("Successfull" , "You have to wait! An Email will be sent or Contact Admin");

                    }
                    else{
                    AlertGen.unsuccessfulAlert("Not valid");
                    }
                }
                
            }
               
            }
    
        
    
    }

    @FXML
    private void goBackToLoginBtnOnAction(ActionEvent event) {
        
        forgotPass_anchorPane.setVisible(false);
        forgotPass_anchorPane.setDisable(true);
        show_label.setText("");
        
    }

    @FXML
    private void one(ActionEvent event) {
        AlertGen.inforamtion("", "Work under maintanance!");
    }

    @FXML
    private void two(ActionEvent event) {
        AlertGen.inforamtion("", "Work under maintanance!");
    }

    @FXML
    private void three(ActionEvent event) {
        AlertGen.inforamtion("", "Work under maintanance!");
    }

    @FXML
    private void four(ActionEvent event) {
        AlertGen.inforamtion("", "Work under maintanance!");
    }

    @FXML
    private void signUpButtonOnClick(ActionEvent event) throws IOException
    {
        to.loadDashBoard(event);
    }
    
}
