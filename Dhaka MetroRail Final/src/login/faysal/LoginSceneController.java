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
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import model.nayem.Passenger;
import model.nayem.TrainOperator;
public class LoginSceneController implements Initializable {

    @FXML    private TextField userIdentity_textField;
    @FXML    private PasswordField password_passField;
    @FXML    private AnchorPane login_anchorPane;
    @FXML    private AnchorPane forgotPass_anchorPane;
    @FXML    private TextField forgetAnchorPane_userIdentity_textField;
    @FXML    private TextField forgetAnchorPane_email_textField;
    @FXML    private Label lopinInfo_label;
    TrainOperator to = new TrainOperator();
    Passenger passen = new Passenger();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void loginButtonOnAction(ActionEvent event) throws IOException
    {
        //to.loadDashBoard(event);
        passen.loadDashBoard(event);
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

    @FXML
    private void signUpButtonOnClick(ActionEvent event) throws IOException
    {
        to.loadDashBoard(event);
    }
    
}
