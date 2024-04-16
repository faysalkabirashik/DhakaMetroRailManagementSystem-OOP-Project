
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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import model.faysal.AlertGen;
import model.faysal.Validation;
import model.nayem.Passenger;
import model.nayem.TrainOperator;
import javafx.scene.layout.AnchorPane;
import model.faysal.AlertGen;
import model.faysal.Validation;
import model.faysal.users.StationManager;
import model.faysal.users.SystemAdministrator;
import model.faysal.users.User;
import view.faysal.systemadmin.SystemAdminDashboardController;

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
    private void loginButtonOnAction(ActionEvent event) throws IOException {
        
        if (userIdentity_textField.getText() == null || userIdentity_textField.getText().trim().isEmpty())
        {
               show_label.setText("UserIdentity field is empty!");
                AlertGen.inforamtion("","UserIdentity field is empty!");
        }

        else if (password_passField.getText() == null || password_passField.getText().trim().isEmpty()) 
        {
           show_label.setText("Password field is empty!");
           AlertGen.inforamtion("","Password not given");}
        else
        {
            String   userID = (userIdentity_textField.getText());
            String pass =  password_passField.getText();
            ///checking for employ 
            if (  !Validation.isValisUserIdentity(userID) || !Validation.isValidPassword(pass))
            {
                AlertGen.unsuccessfulAlert("Not valid entry");
            }else
            {
                show_label.setText("Checking for verificaiton....");
                 ////////////////////////////////////////////////////////////      
                String login = User.loginVerify(userID, pass);
                switch(login){
                    case  "00":
                        FXMLLoader dashLoader = new FXMLLoader(getClass().getResource("SystemAdminDashboard.fxml"));
                        Parent root = dashLoader.load();
                        SystemAdminDashboardController obj = dashLoader.getController();
                        obj.setSystemAdmin((SystemAdministrator) User.getObjectV2(userID, "System Administrator"));

                        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        window.setScene(new Scene(root));
                        window.show();

                        AlertGen.successfulAlert("Login Successfull!");
                        break;
                    case "01":

                        System.out.println("Login succes         ");
                         show_label.setText("Login success     ");
//                                Parent dashBoard = null;
//                                FXMLLoader loader = new FXMLLoader(getClass().getResource(".fxml"));
//                                Parent root = (Parent) loader.load();
//                                Scene scene = new Scene(root);
//                                StationManager obj = loader.getController();
//                                obj.setSystemAdmin((SystemAdministrator) User.getObjectV2(userID, "System Administrator"));
//
//                                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//                                stage.setScene(scene);
//                                stage.show();
//                                AlertGen.successfulAlert("Login Successfull!"); 


                        break;
                    case "02":
                        System.out.println("Login succes         ");
                        show_label.setText("Login success     ");
                        FXMLLoader dashLoader2 = new FXMLLoader(getClass().getResource("/view/nayem/TrainOperator/TrainOperatorDashborad.fxml"));
                        System.out.println("Dash");
                        Parent root2 = dashLoader2.load();
                        System.out.println("loader");
                        Stage window2 = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        window2.setScene(new Scene(root2));
                        window2.show();


                        break;
                    case "03":
                        System.out.println("Login succes         ");
                         show_label.setText("Login success     ");
                         System.out.println("Login succes         ");
                        show_label.setText("Login success     ");
                        FXMLLoader dashLoader3 = new FXMLLoader(getClass().getResource("/view/minhaz/maintenanceStaff/MaintenanceStaffDashboard.fxml"));
                        System.out.println("Dash");
                        Parent root3 = dashLoader3.load();
                        System.out.println("loader");
                        Stage window3 = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        window3.setScene(new Scene(root3));
                        window3.show();


                        break;
                    case "04":
                        System.out.println("Login succes         ");
                         show_label.setText("Login success     ");


                        break;
                    case "05":
                        System.out.println("Login succes         ");
                         show_label.setText("Login success     ");


                        break;
                    case "06":
                        System.out.println("Login succes         ");
                         show_label.setText("Login success     ");
                    case "07":
                            System.out.println("Login not success - Pasenger         ");
                         show_label.setText("Login success     ");

                    break;}// switch break


                
                        }
                        ////////////////////////////////////////////////////////////

     } 
    }
        


    @FXML
    private void forgotButtonOnAction(ActionEvent event) {
        
        forgotPass_anchorPane.setDisable(false);
        forgotPass_anchorPane.setVisible(true);
        
    }

    @FXML
<<<<<<< HEAD
    private void signUpOnAction(ActionEvent event) throws IOException 
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/nayem/passenger/PassengerSignUpScene.fxml"));
            Parent parent = loader.load();
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene newScene = new Scene(parent);
            currentStage.setScene(newScene);
            currentStage.show();

=======
    private void signUpOnAction(ActionEvent event) {
        
>>>>>>> Jubair-2221134
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
