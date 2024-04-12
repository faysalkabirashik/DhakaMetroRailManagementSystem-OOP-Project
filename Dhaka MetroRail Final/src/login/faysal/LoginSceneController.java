package login.faysal;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.fxml.Initializable;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import model.nayem.Passenger;
import model.nayem.TrainOperator;
public class LoginSceneController implements Initializable {

    @FXML    private TextField userIdentity_textField;
    @FXML    private PasswordField password_passField;
    @FXML
    private AnchorPane login_anchorPane;
    @FXML
    private AnchorPane forgotPass_anchorPane;
    @FXML
    private TextField forgetAnchorPane_userIdentity_textField;
    @FXML
    private TextField forgetAnchorPane_email_textField;

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
        TrainOperator to = new TrainOperator();
        to.loadDashBoard(event);
        
//        File f = null;
//        FileInputStream fis = null;
//        ObjectInputStream ois = null;
//        String pass;
//        try {
//            f = new File("PassegerData.bin");
//            fis = new FileInputStream(f);
//            ois = new ObjectInputStream(fis);
//            Passenger passenger;
//            try{
//                while(true){
//                    passenger = (Passenger)ois.readObject();
//                    System.out.println(passenger);
//                    pass = passenger.getPassword();
//                    if (passenger.getPassword().equals(password_passField.getText()))
//                    {
//                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/nayem/passenger/PassengerDashBoard.fxml"));
//                        Parent parent = loader.load();
//                        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//                        Scene newScene = new Scene(parent);
//                        currentStage.setScene(newScene);
//                        currentStage.show();
//                    }
//                }
//            }
//            catch(Exception e){
//                System.out.println("hoy nai");
//            }      
//        } catch (IOException ex) {
//            System.out.println(ex.toString());
//        } 
//        finally {
//            try {
//                if(ois != null) ois.close();
//            } catch (IOException ex) { }
//        }
    }

    @FXML
    private void forgotButtonOnAction(ActionEvent event) {
    }

    @FXML
    private void getPassButtonOnAction(ActionEvent event) {
    }

    @FXML
    private void goBackToLoginBtnOnAction(ActionEvent event) {
    }
    
}
