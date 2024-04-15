/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package view.nayem.passenger;

import java.net.URL;
import java.time.LocalDate;
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
import model.faysal.Address;
import model.faysal.AddressLists;
import model.faysal.AlertGen;
import model.faysal.DescriptionOnUserCreation;
import model.faysal.Validation;
import model.faysal.users.Accountant;
import model.faysal.users.Employee;
import model.faysal.users.HeadOfHR;
import model.faysal.users.MaintenanceStaff;
import model.faysal.users.PublicServiceProvider;
import model.faysal.users.StationManager;
import model.faysal.users.SystemAdministrator;
import model.faysal.users.User;
import model.nayem.Passenger;
import model.nayem.TrainOperator;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class SignUpSceneController implements Initializable {

    @FXML    private AnchorPane parentAnchorPane;
    @FXML    private TextArea note_textArea;
    @FXML    private TextField fullName_textField;
    @FXML    private ComboBox<String> cityComboBox;
    @FXML    private ComboBox<String> divisionComboBox;
    @FXML    private TextField road_textField;
    @FXML    private TextField village_textField;
    @FXML    private TextField primaryMobileNo_textField;
    @FXML    private TextField secondaryMobileNo_textField;
    @FXML    private TextField primaryEmail_textField;
    @FXML    private TextField secondaryEmail_textField;
    @FXML    private DatePicker dob_datePicker;
    @FXML    private RadioButton male_radioButton;
    @FXML    private ToggleGroup gender_toggleGroup;
    @FXML    private RadioButton female_radioButton;
    @FXML    private RadioButton intersex_radioButton;
    @FXML    private CheckBox nid_checkBox;
    @FXML    private CheckBox birthCer_checkBox;
    @FXML    private TextField nid_textField;
    @FXML    private TextField birthCer_textField;
    @FXML    private TextField generatePassengerUsername_textField;
    @FXML    private TextField house_textField;
    @FXML    private ComboBox<String> country_comBox;
    @FXML    private Button generateEmployeeId_button;
    @FXML    private Label generateEmployeeId_label;
    @FXML    private PasswordField generatePassword_passwordField;
    @FXML    private Button generatePassengerUsername_button;
    @FXML    private ComboBox<String> districtComboBox;
    @FXML    private Label nid_label;
    @FXML    private CheckBox showPass_checkBox;
    @FXML    private Label showPass_label;
    @FXML    private TextField id_textField;
    
    private User user;
    private String generatedID = "";

    private DescriptionOnUserCreation descriptionObj ;

    private SystemAdministrator admin = new SystemAdministrator();
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
        country_comBox.setItems(FXCollections.observableArrayList(countries));

        String[] ep_designations = {"System Administrator", "Station Manager", "Train Operator",
            "Head of HR", "Maintenance Staff", "Public Service Provider", "Accountant"};

        birthCer_checkBox.setDisable(false);
        birthCer_textField.setDisable(false);
        generatePassengerUsername_button.setDisable(false);
        generatePassengerUsername_textField.setDisable(false);
        nid_checkBox.setSelected(false);
        nid_checkBox.setDisable(false);
        generateEmployeeId_button.setDisable(true);
        generateEmployeeId_label.setDisable(true);

        List<String> divisions = AddressLists.getBdDivisions();
        ObservableList<String> divisionItems = FXCollections.observableArrayList(divisions);
        // AutoFilterSupportToComboBox.setTheComboBoxAutoFilterSupported(divisionComboBox, divisions );

        divisionComboBox.setItems(divisionItems);

        // Set up listeners for ComboBoxes
        divisionComboBox.setOnAction(event -> updateDistrictComboBox());
        districtComboBox.setOnAction(event -> updateCityComboBox());
    }    

    @FXML
    private void goBackBtnOnAction(ActionEvent event) {
    }

    @FXML
    private void saveAndCreateUserBtnOnAction(ActionEvent event) 
    {
        RadioButton genderRB = (RadioButton) gender_toggleGroup.getSelectedToggle(); 
        String fullName = fullName_textField.getText();
        String country = country_comBox.getValue();
        String div = divisionComboBox.getValue();
        String district = districtComboBox.getValue() ;
        String city = cityComboBox.getValue();
        if (genderRB == null){AlertGen.unsuccessfulAlert("please select gender first");return ;}
        String gender = genderRB.getText();
        String road = road_textField.getText();
        String house = house_textField.getText() ;
        String village = village_textField.getText();
        String primMobile = primaryMobileNo_textField.getText();
        String primEmail = primaryEmail_textField.getText();
        LocalDate doB = dob_datePicker.getValue();
        String pass = generatePassword_passwordField.getText();
        String nid = nid_textField.getText();
        String description = note_textArea.getText();
        
        if (! secondaryMobileNo_textField.getText().isEmpty() || !secondaryEmail_textField.getText().isEmpty()){
        AlertGen.inforamtion("Work under process!", "Secondary info will not be added for now");
        }
        
        if (fullName == null || country == null || div == null || district == null || city == null || gender == null || 
                road == null || house == null || village  == null ||
                doB == null || primMobile == null || primEmail == null ||  pass == null)

            {
                AlertGen.unsuccessfulAlert("Field can't be empty. Please fill properly.");
                System.out.println("if no 1");
            }
        else if (primMobile.isEmpty() && primEmail.isEmpty()){ System.out.println("else if 1");
            AlertGen.unsuccessfulAlert("Please provide email and mobile number");
        }
        else if (primEmail.isEmpty() )
        {
            AlertGen.unsuccessfulAlert("Please provide primary email"); 
            System.out.println("else if 2");
            
        }
        else if (primMobile.isEmpty() )
                {
                AlertGen.unsuccessfulAlert("Please provide primary mobile");
        
        }
        else if (!Validation.isValidEmail(primEmail)){AlertGen.unsuccessfulAlert("Please provide correct email");
                System.out.println("else if validaion email");
                 }
        else if (!Validation.allDigits(primMobile)){AlertGen.unsuccessfulAlert("Please provide primary mobile No");}
        else // esle 1 
            {   Address address = new Address(district, city, road, village, house);
                System.out.println("esle 1");
                System.out.println(address.toString());
                /// 
            if (Validation.isValidBirthDate(doB)) // if 2
            {
                System.out.println("if 2");
                if (! Validation.isAtLeastEighteenYearsOld(doB)) //if 3
                {
                    AlertGen.unsuccessfulAlert("Age must be at least 18 years older.");
                    System.out.println("if");
                }
                else // else 2
                {
                  // age valid, passenger can be created
                    System.out.println("else 2");
                if (Validation.isValidPassword(pass))// if 4
                {
                    System.out.println("if 4");
                    
                    
                    
                    // user creation for passenger, birth certificate or nid is needed
                    System.out.println("if 5 passenger e dhukse ");
                    String birCer = birthCer_textField.getText();
                    if (birCer.isEmpty() && nid.isEmpty()) //if 6
                    {                                  System.out.println("if 6 e dhukse");
                        AlertGen.unsuccessfulAlert("You have to select NID or Birth Certificate!");
                    }
           
                        
                    else// else 3
                        {   System.out.println("else 3 ");


                          String username = generatePassengerUsername_textField.getText();
                            if (username.isEmpty() || !Validation.isValidUsername(username)) // if 7
                            {
                                AlertGen.unsuccessfulAlert("Select username properly!");
                                System.out.println("if 7");
                            }

                          else // else 4
                          {
                              // can create , vaid type passenger, create one
                              System.out.println("Can create passenger block");
                              System.out.println("else 4 e parbe");


                              boolean confirmation = AlertGen.confirmationAlert("Do you want to confim to add new Passenger?");
                              System.out.println(confirmation);
                              if (confirmation)// if 8
                              {System.out.println("if 8");
                                Passenger passengerObj = new   Passenger(fullName,  primMobile,   
                                        primEmail,  gender,   username,   "Passenger",  
                                        pass,   doB,  address,   true);

                                  System.out.println("passenger created successfully if 8 e");
                                // checks whether nid or certificate is chosen and set value
                                if (Validation.allDigits(nid)){passengerObj.setNid(nid);System.out.println("if 9");} // if9
                                //if (Validation.allDigits(birCer)){ passengerObj.setBirtCertificate(birCer);System.out.println("if10");} //if10

                                boolean  isSuccess = this.admin.createNewUserInstance(passengerObj,"Passenger", true);
                                  System.out.println("isSuccess"+ isSuccess);
                                if ( isSuccess)   // if 11 
                                {   System.out.println("/nif 11/n Passenger added to bin file by admin successfully");
                                    descriptionObj =  new DescriptionOnUserCreation(description);
                                    System.out.println("Creation successfull");
                                    AlertGen.successfulAlert("Passenger scucceesfully added!");
                                    descriptionObj.setUser( passengerObj);
                                    generatePassengerUsername_textField.clear();
                                    generatePassword_passwordField.clear();
                                    secondaryMobileNo_textField.clear();
                                    secondaryEmail_textField.clear();
                                    birthCer_textField.clear();
                                    primaryMobileNo_textField.clear();
                                    primaryEmail_textField.clear();
                                    nid_textField.clear();
                                    gender_toggleGroup.selectToggle(null);
                                    dob_datePicker.getEditor().clear();
                                    generatePassengerUsername_textField.clear();
                                }else{AlertGen.unsuccessfulAlert("Something Gone Wrong!");}//else 5
                              }else // else6
                              {System.out.println("else 6 e nothing");
                                 //nothoing 
                              }
                           }
                       }
                    }else{AlertGen.unsuccessfulAlert("Pass is not valid!");}
                }
              }else{AlertGen.unsuccessfulAlert("Unvalid Date of Birth!");}

            }
    }

    @FXML
    private void generateEmployeeIdBtnOnAction(ActionEvent event) {generatePassengerUsername_textField.setText(Validation.generateUsername());
    }

    @FXML
    private void generatePasswordBtnOnAction(ActionEvent event) {
    }

    @FXML
    private void generatePassengerUsernameBtnOnAction(ActionEvent event) {generatePassengerUsername_textField.setText(Validation.generateUsername());
    }

    @FXML
    private void showPassCheckBoxOnAction(ActionEvent event) {if ( showPass_checkBox.isSelected() ) {
          String pass = generatePassword_passwordField.getText();
          showPass_label.setVisible(true);
          showPass_label.setText(pass);
       }else{
            showPass_label.setVisible(false);
        }
    }
    
}
