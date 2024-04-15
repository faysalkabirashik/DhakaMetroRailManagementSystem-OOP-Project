/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package view.nayem.passenger;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class SignUpSceneController implements Initializable {

    @FXML
    private AnchorPane parentAnchorPane;
    @FXML
    private TextArea note_textArea;
    @FXML
    private TextField fullName_textField;
    @FXML
    private ComboBox<?> cityComboBox;
    @FXML
    private ComboBox<?> divisionComboBox;
    @FXML
    private TextField road_textField;
    @FXML
    private TextField village_textField;
    @FXML
    private TextField primaryMobileNo_textField;
    @FXML
    private TextField secondaryMobileNo_textField;
    @FXML
    private TextField primaryEmail_textField;
    @FXML
    private TextField secondaryEmail_textField;
    @FXML
    private DatePicker dob_datePicker;
    @FXML
    private RadioButton male_radioButton;
    @FXML
    private ToggleGroup gender_toggleGroup;
    @FXML
    private RadioButton female_radioButton;
    @FXML
    private RadioButton intersex_radioButton;
    @FXML
    private CheckBox nid_checkBox;
    @FXML
    private CheckBox birthCer_checkBox;
    @FXML
    private TextField nid_textField;
    @FXML
    private TextField birthCer_textField;
    @FXML
    private TextField generatePassengerUsername_textField;
    @FXML
    private TextField house_textField;
    @FXML
    private ComboBox<?> country_comBox;
    @FXML
    private Button generateEmployeeId_button;
    @FXML
    private Label generateEmployeeId_label;
    @FXML
    private PasswordField generatePassword_passwordField;
    @FXML
    private Button generatePassengerUsername_button;
    @FXML
    private ComboBox<?> districtComboBox;
    @FXML
    private Label nid_label;
    @FXML
    private CheckBox showPass_checkBox;
    @FXML
    private Label showPass_label;
    @FXML
    private TextField id_textField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void goBackBtnOnAction(ActionEvent event) {
    }

    @FXML
    private void saveAndCreateUserBtnOnAction(ActionEvent event) {
    }

    @FXML
    private void generateEmployeeIdBtnOnAction(ActionEvent event) {
    }

    @FXML
    private void generatePasswordBtnOnAction(ActionEvent event) {
    }

    @FXML
    private void generatePassengerUsernameBtnOnAction(ActionEvent event) {
    }

    @FXML
    private void showPassCheckBoxOnAction(ActionEvent event) {
    }
    
}
