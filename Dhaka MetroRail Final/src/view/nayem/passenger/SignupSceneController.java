package view.nayem.passenger;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import model.faysal.*;
import model.nayem.Passenger;

public class SignupSceneController implements Initializable {

    @FXML    private TextField enterNameTextField;
    @FXML    private TextField mobileNumberTextBox;
    @FXML    private TextField emailTextBox;
    @FXML    private DatePicker dobDatePicker;
    @FXML    private RadioButton maleRadioButton;
    @FXML    private RadioButton femaleRadioButton;
    @FXML    private RadioButton intersexRadioButton;
    @FXML    private TextField nidTextBox;
    @FXML    private TextField usernameTextField;
    @FXML    private ComboBox nationalityComboBox;
    @FXML    private PasswordField passwordTextFiled;
    @FXML    private TextArea enterAddressTextArea;
    @FXML    private TextField districtTextField;
    @FXML    private TextField cityTextField;
    
    ToggleGroup tg = new ToggleGroup();
    AlertGeneration alert;

    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        nationalityComboBox.getItems().addAll("Bangladeshi","Indian","Canadian","Nepalise","Japanese","American");
        maleRadioButton.setToggleGroup(tg);
        femaleRadioButton.setToggleGroup(tg);
        intersexRadioButton.setToggleGroup(tg);
    }   

    @FXML
    private void goBackButtonOnClick(ActionEvent event) throws IOException 
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/nayem/passenger/PassengerDashBoard.fxml"));
        Parent parent = loader.load();
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene newScene = new Scene(parent);
        currentStage.setScene(newScene);
        currentStage.show();
    }


    @FXML
    private void signUpButtonOnClick(ActionEvent event) 
    {
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;        
        try {
            f = new File("PassegerData.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            Passenger passenger;
            passenger = new Passenger(
                    enterNameTextField.getText(),
                    mobileNumberTextBox.getText(),emailTextBox.getText(),
                    "null",
                    dobDatePicker.getValue(),nidTextBox.getText(), usernameTextField.getText(),passwordTextFiled.getText(), enterAddressTextArea.getText(), false);
            if (maleRadioButton.isSelected())
            {
                passenger.setGender("Male");
            }
            else if (femaleRadioButton.isSelected())
            {
                passenger.setGender("Female");
            }
            else if (intersexRadioButton.isSelected())
            {
                passenger.setGender("Intersex");
            }
            oos.writeObject(passenger);

        } catch (IOException ex) {
            Logger.getLogger(SignupSceneController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(SignupSceneController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}