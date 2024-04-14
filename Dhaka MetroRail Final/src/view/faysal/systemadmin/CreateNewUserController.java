package view.faysal.systemadmin;

import java.io.IOException;
 
import java.net.URL;
import java.time.LocalDate;
 
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
 
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

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
import javafx.stage.Stage;
//import model.faysal.AutoFilterSupportToComboBox;
import model.faysal.AddressLists;
import model.faysal.users.SystemAdministrator;

/**
 * FXML Controller class
 *
 * @author Faysal Kabir Ashik
 */
public class CreateNewUserController implements Initializable {

    private ComboBox<String> city_comBox;
    private ComboBox<String> district_comBox;
    @FXML
    private TextField fullName_textField;

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
    @FXML
    private ComboBox<String> cityComboBox;
    @FXML
    private ComboBox<String> divisionComboBox;
    @FXML
    private ComboBox<String> districtComboBox;
    
    private SystemAdministrator admin;
    @FXML
    private DatePicker doB_datePicker;
    
    public SystemAdministrator getSystemAdmin(){
        return admin;
    }
    
    public void setSystemAdmin(SystemAdministrator admin){
        
        this.admin =  admin;
    }
    
    private void updateDistrictComboBox() {
        String selectedDivision = divisionComboBox.getValue();
        if (selectedDivision != null) {
            List<String> districts = AddressLists.getBdDistricts(selectedDivision);
            ObservableList<String> districtItems = FXCollections.observableArrayList(districts);
            districtComboBox.setItems(districtItems);
            //AutoFilterSupportToComboBox.setTheComboBoxAutoFilterSupported(districtComboBox, districts );
            // Reset cityComboBox
            cityComboBox.getItems().clear();
        }
    }

    private void updateCityComboBox() {
        String selectedDistrict = districtComboBox.getValue();
        if (selectedDistrict != null) {
            Map<String, List<String>> districtMap = AddressLists.getMap(divisionComboBox.getValue());
            List<String> cities = districtMap.get(selectedDistrict);
            ObservableList<String> cityItems = FXCollections.observableArrayList(cities);
            cityComboBox.setItems(cityItems);
            //AutoFilterSupportToComboBox.setTheComboBoxAutoFilterSupported(cityComboBox, cityItems );
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        List<String> countries = AddressLists.getCountries();
        employeeType_comBox.setItems(FXCollections.observableArrayList(countries));

        String[] ep_designations = {"System Administrator", "Station Manager", "Train Operator",
            "Head of HR", "Maintenance Staff", "Public Service Provider", "Accountant"};
        employeeType_comBox.setItems(FXCollections.observableArrayList(ep_designations));

        userType_toggleGroup.selectedToggleProperty().addListener((observable, oldValue, newValue)
                -> {
            RadioButton selectedRadioButton = (RadioButton) newValue;
            if (selectedRadioButton == employee_radioButton) {
                employeeType_comBox.getItems().clear();
                employeeType_comBox.setItems(FXCollections.observableArrayList(ep_designations));
            }

            if (newValue == employee_radioButton || newValue == admin_radioButton) {
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

                if (newValue == admin_radioButton) {
                    employeeType_comBox.setItems(FXCollections.observableArrayList("System Administrator"));
                    employeeType_comBox.setValue("System Administrator");

                } else {

                    employeeType_comBox.setItems(FXCollections.observableArrayList(ep_designations));

                }

            } else if (newValue == passenger_radioButton) {
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

        employeeType_comBox.valueProperty().addListener((observable, oldValue, newValue)
                -> {
            if (newValue != null) {
                if (newValue.equals("System Administrator")) {
                    // If ComboBox value is System Administrator
                    userType_toggleGroup.selectToggle(admin_radioButton);
                }
            }
        });

        List<String> divisions = AddressLists.getBdDivisions();
        ObservableList<String> divisionItems = FXCollections.observableArrayList(divisions);
        // AutoFilterSupportToComboBox.setTheComboBoxAutoFilterSupported(divisionComboBox, divisions );

        divisionComboBox.setItems(divisionItems);

        // Set up listeners for ComboBoxes
        divisionComboBox.setOnAction(event -> updateDistrictComboBox());
        districtComboBox.setOnAction(event -> updateCityComboBox());

        /*
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
                    district_comBox.setDisable(true);
                    city_comBox.getItems().clear();                  
                    city_comBox.setDisable(true);
                    
 
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
         */
    }

    @FXML
    private void goBackBtnOnAction(ActionEvent event) throws RuntimeException, IOException {

        FXMLLoader dashLoader = new FXMLLoader(getClass().getResource("SystemAdminDashboard.fxml"));
        Parent root = dashLoader.load();
        SystemAdminDashboardController systemAdminDashController = dashLoader.getController();
        systemAdminDashController.loadUIAtMainBorderPane("SystemAdminGoals");
        

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene( new Scene(root));
        window.show();

    }

    @FXML
    private void saveAndCreateUserBtnOnAction(ActionEvent event) {
        
        RadioButton genderRB = (RadioButton) gender_toggleGroup.getSelectedToggle(); 
        RadioButton parentUserTypeRB = (RadioButton) userType_toggleGroup.getSelectedToggle();
        String fullName = fullName_textField.getText();
        String country = country_comBox.getValue();
        String div = divisionComboBox.getValue();
        String district = districtComboBox.getValue() ;
        String city = cityComboBox.getValue();
        String gender = genderRB.getText();
        String road = road_textField.getText();
        String house = house_textField.getText() ;
        String village = village_textField.getText();
        String primMobile = primaryMobileNo_textField.getText();
        String primEmail = primaryMobileNo_textField.getText();
        
        
        LocalDate doB = doB_datePicker.getValue();
        
        if (fullName == null || country == null || div == null || district == null || city == null || gender == null || 
                road == null || house == null || village  == null ||
                doB == null || primMobile n 
                
                
          
                
                
                
                
                
                
                )
                        

        {
            
        }
        
        
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
    private void employeeRadioButtonOnAction(ActionEvent event) {
        if (employee_radioButton.isSelected()) {
        }
    }

    @FXML
    private void passengerRadioButtonOnAction(ActionEvent event) {
    }

    @FXML
    private void adminRadioButtonOnAction(ActionEvent event) {
    }

}
