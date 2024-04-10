
package view.faysal.systemadmin.manageuser;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import model.faysal.AutoFilterSupportToComboBox;
import model.faysal.AddressLists;

/**
 * FXML Controller class
 *
 * @author Faysal Kabir Ashik
 */
public class CreateNewUserController implements Initializable {

    @FXML
    private ComboBox<String> city_comBox;
    @FXML
    private ComboBox<String> district_comBox;
    @FXML
    private TextField fullName_textField;
    
  
    @FXML
    private  ComboBox<String> division_comBox;
    @FXML
    private TextArea note_textArea;
    @FXML
    private ToggleGroup userType_toggleGroup;
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
    private ToggleGroup gender_toggleGroup;
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
    private ComboBox<String> employeeType_comBox;
    @FXML
    private TextField house_textField;
    @FXML
    private ComboBox<String> country_comBox;
    @FXML
    private Button generateEmployeeId_button;
    @FXML
    private Label generateEmployeeId_label;
    @FXML
    private PasswordField generatePassword_passwordField;
    @FXML
    private Button generatePassengerUsername_button;
    @FXML
    private DatePicker joiningDate_datePicker;
    @FXML
    private Button viewUser_button;
    @FXML
    private AnchorPane parentAnchorPane;
    @FXML
    private RadioButton employee_radioButton;
    @FXML
    private RadioButton passenger_radioButton;
    @FXML
    private RadioButton admin_radioButton;
    @FXML
    private RadioButton male_radioButton;
    @FXML
    private RadioButton female_radioButton;
    @FXML
    private RadioButton intersex_radioButton;
    @FXML
    private Label joiningDate_label;
    @FXML
    private Label nid_label;
    
    
     private Map<String, List<String>> districtCityMap;

    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        String[] ep_designations = {"System Administrator", "Station Manager", "Train Operator",
             "Head of HR",  "Maintenance Staff", "Public Service Provider", "Accountant"};
        employeeType_comBox.setItems(FXCollections.observableArrayList(ep_designations));
        
        userType_toggleGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> 
        {
            RadioButton selectedRadioButton = (RadioButton) newValue;
            if (selectedRadioButton == employee_radioButton)
                {
                    employeeType_comBox.getItems().clear();
                    employeeType_comBox.setItems(FXCollections.observableArrayList(ep_designations));
                }
           
            if (newValue == employee_radioButton || newValue == admin_radioButton ) 
            {
                birthCer_checkBox.setDisable(true);
                birthCer_textField.setDisable(true);
                generatePassengerUsername_button.setDisable(true);
                generatePassengerUsername_textField.setDisable(true);
                nid_checkBox.setSelected(true);
                nid_checkBox.setDisable(true);
                
                nid_label.setDisable(false);
                employeeType_comBox.setDisable(false);
                generateEmployeeId_button.setDisable(false);
                generateEmployeeId_label.setDisable(false);
                joiningDate_label.setDisable(false);
                joiningDate_datePicker.setDisable(false);
                
                if (newValue == admin_radioButton)
                {
                    employeeType_comBox.setItems(FXCollections.observableArrayList("System Administrator"));
                    employeeType_comBox.setValue("System Administrator");
        
                }
                else
                {

                    employeeType_comBox.setItems(FXCollections.observableArrayList(ep_designations));
       
                }
            
            }
            
            else if (newValue == passenger_radioButton) 
            {
                birthCer_checkBox.setDisable(false);
                birthCer_textField.setDisable(false);
                generatePassengerUsername_button.setDisable(false);
                generatePassengerUsername_textField.setDisable(false);
                nid_checkBox.setSelected(false);
                nid_checkBox.setDisable(false);
                
                
                employeeType_comBox.setDisable(true);
                generateEmployeeId_button.setDisable(true);
                generateEmployeeId_label.setDisable(true);
                joiningDate_label.setDisable(true);
                joiningDate_datePicker.setDisable(true);
            }      
        });
        
        
        employeeType_comBox.valueProperty().addListener((observable, oldValue, newValue) -> 
        {
            if (newValue != null) 
            {
                if (newValue.equals("System Administrator")) 
                {
                    // If ComboBox value is System Administrator
                    userType_toggleGroup.selectToggle(admin_radioButton);
                }  
            }
        });
        
        // initialize country combo box
        List<String> countries = AddressLists.getCountries();
        AutoFilterSupportToComboBox.setTheComboBoxAutoFilterSupported(country_comBox, FXCollections.observableList(countries));
        
        // initialize division combo box
        List<String> divisions = AddressLists.getBdDivisions();
        AutoFilterSupportToComboBox.setTheComboBoxAutoFilterSupported(division_comBox, FXCollections.observableList(divisions));
         
        // initialize district combo box    based on division selection
        division_comBox.valueProperty().addListener((observable, oldValue, newValue) -> 
        {
            try 
            {
                districtCityMap  = AddressLists.getMap(newValue);

                if (newValue != null && districtCityMap != null && districtCityMap.containsKey(newValue)) 
                {
                    List<String> districts = AddressLists.getBdDistricts(newValue);
                    AutoFilterSupportToComboBox.setTheComboBoxAutoFilterSupportedV2(district_comBox, districts);
                    district_comBox.setDisable(false);
                
                }
                else
                {
                    district_comBox.getItems().clear();
                    city_comBox.getItems().clear();
                    city_comBox.setDisable(true);
                    district_comBox.setDisable(true);
 
                }
            }catch(Exception e){
                System.out.println(e.toString());
            }
        });

        
        district_comBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                // If a district is selected newValue now district
                List<String> cities = AddressLists.getMap(division_comBox.getValue()).get(newValue);
                AutoFilterSupportToComboBox.setTheComboBoxAutoFilterSupportedV2(city_comBox, cities);
                city_comBox.setDisable(false); // Enable comboBox3
            } else {
                // If no district is selected
                city_comBox.getItems().clear();
                city_comBox.setDisable(true);
                
            }
        });        
        
   
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
    private void viewUserBtnOnAction(ActionEvent event) {
    }

    @FXML
    private void employeeRadioButtonOnAction(ActionEvent event) {
        if (employee_radioButton.isSelected()){}
    }

    @FXML
    private void passengerRadioButtonOnAction(ActionEvent event) {
    }

    @FXML
    private void adminRadioButtonOnAction(ActionEvent event) {
    }

}



