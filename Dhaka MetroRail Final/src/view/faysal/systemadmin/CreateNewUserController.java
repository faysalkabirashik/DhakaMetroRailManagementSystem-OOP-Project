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
import model.faysal.Address;
//import model.faysal.AutoFilterSupportToComboBox;
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
import model.nayem.TrainOperator;
import model.nayem.Passenger;

/**
 * FXML Controller class
 *
 * @author Faysal Kabir Ashik
 */
public class CreateNewUserController implements Initializable {
 
    @FXML private TextField fullName_textField;
    @FXML private TextArea note_textArea;
    @FXML
    private ToggleGroup userType_toggleGroup;
    @FXML    private TextField road_textField;
    @FXML    private TextField village_textField;
    @FXML    private TextField primaryMobileNo_textField;
    @FXML    private TextField secondaryMobileNo_textField;
    @FXML    private TextField primaryEmail_textField;
    @FXML    private TextField secondaryEmail_textField;
    @FXML    private ToggleGroup gender_toggleGroup;
    @FXML    private CheckBox nid_checkBox;
    @FXML    private CheckBox birthCer_checkBox;
    @FXML    private TextField nid_textField;
    @FXML    private TextField birthCer_textField;
    @FXML    private TextField generatePassengerUsername_textField;
    @FXML
    private ComboBox<String> employeeType_comBox;
    @FXML    private TextField house_textField;
    @FXML    private ComboBox<String> country_comBox;
    @FXML    private Button generateEmployeeId_button;
    @FXML    private Label generateEmployeeId_label;
    @FXML    private PasswordField generatePassword_passwordField;
    @FXML    private Button generatePassengerUsername_button;
    @FXML
    private DatePicker joiningDate_datePicker;
    @FXML    private AnchorPane parentAnchorPane;
    @FXML    private RadioButton employee_radioButton;
    @FXML    private RadioButton passenger_radioButton;
    @FXML    private RadioButton admin_radioButton;
    @FXML    private RadioButton male_radioButton;
    @FXML    private RadioButton female_radioButton;
    @FXML    private RadioButton intersex_radioButton;
    @FXML
    private Label joiningDate_label;
    @FXML    private Label nid_label;
    @FXML    private ComboBox<String> cityComboBox;
    @FXML    private ComboBox<String> divisionComboBox;
    @FXML    private ComboBox<String> districtComboBox;
    @FXML    private CheckBox showPass_checkBox;
    @FXML    private DatePicker dob_datePicker;
    @FXML    private Label showPass_label;  

    //////////////////////////////////////////////////////
    
    private User user;
    private String generatedID = "";

    private DescriptionOnUserCreation descriptionObj ;

    private SystemAdministrator admin = new SystemAdministrator();
    @FXML
    private TextField id_textField;
    @FXML
    private CheckBox manuallyGenerateID_checkBox;
<<<<<<< HEAD
    @FXML
    private TextField noOfEmpManged;
=======
>>>>>>> 5bbe4178c3dcd79dadf3d351c0c786fde353c19a
    
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
    /////////////////////////////////////////////////////////////////////
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        List<String> countries = AddressLists.getCountries();
        country_comBox.setItems(FXCollections.observableArrayList(countries));

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

    }

    @FXML
    private void goBackBtnOnAction(ActionEvent event) throws RuntimeException, IOException {

        FXMLLoader dashLoader = new FXMLLoader(getClass().getResource("SystemAdminDashboard.fxml"));
        Parent root = dashLoader.load();
        SystemAdminDashboardController systemAdminDashController = dashLoader.getController();
        systemAdminDashController.loadUIAtDashBorderPane("SystemAdminGoals");
        

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene( new Scene(root));
        window.show();

    }

    @FXML
    private void saveAndCreateUserBtnOnAction(ActionEvent event) throws NullPointerException, RuntimeException {
//        try{
        RadioButton genderRB = (RadioButton) gender_toggleGroup.getSelectedToggle(); 
        
   
        
        RadioButton parentUserTypeRB = (RadioButton) userType_toggleGroup.getSelectedToggle();
        String parentUserType = parentUserTypeRB.getText();
        
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
                    if ("Passenger".equals(parentUserType))    //if 5
                    {   System.out.println("if 5 passenger e dhukse ");
                        String birCer = birthCer_textField.getText();
                        if (birCer.isEmpty() && nid.isEmpty()) //if 6
                        {                                  System.out.println("if 6 e dhukse");
                            AlertGen.unsuccessfulAlert("You have to select NID or Birth Certificate!");
                        }
                
                        else// else 3
                          {   System.out.println("else 3 ");
                              String username = generatePassengerUsername_textField.getText();
                              
                              // user name validation
                              if (username.isEmpty() || !Validation.isValidUsername(username)) // if 7
                              {
                                  AlertGen.unsuccessfulAlert("Select username properly!");
                                  System.out.println("if 7");
                              } else if (SystemAdministrator.checkUserExist(username)){
                                  AlertGen.unsuccessfulAlert("The username already exist");
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
                                        System.out.println("Before set true passenger radio button: ");
                                        passenger_radioButton.setSelected(true);      
                                        System.out.println("After , what happenening? ");
                                    }else{AlertGen.unsuccessfulAlert("Something Gone Wrong!");}//else 5 
                                  }else // else6
                                  {System.out.println("else 6 e nothing");
                                     //nothoing 
                                  }
                               }
                           }
                    }
                    else // if  passsenger is not selected to be added // not passenger type user
                    {   System.out.println("else7");
                        // User creation for all employee type          
                        LocalDate joiningDate = joiningDate_datePicker.getValue();
                        //String employeeID = id_textField.getText();
                        String employeeID = generateEmployeeId_label.getText();
                        String employeeType = employeeType_comBox.getValue();   
                        // CHECKS   if the joining date future date or not
                        if (joiningDate != null && 
                                ! Validation.isValidJoiningDate(joiningDate))
                        {System.out.println("if12");
                            int year =  LocalDate.now().getYear();
                            // the joining date is not valid
                            // it can only be valid if it is not before year 2021 
                            // and not after 4 year from current year.
                            AlertGen.unsuccessfulAlert("The joining date is not valid!" + 
                                    " It should be in between 2021/01 and "
                                   + year);
                        }
                        else
                        {       System.out.println("Else 8");
                            // confirms joining date valid
                            // check employee id and employee type empty or unselected and nid is given or not
                           try{
                               System.out.println("try2");
                               if (employeeID.isEmpty() || employeeType.isEmpty() || nid.isEmpty()){
                                   AlertGen.unsuccessfulAlert("Select all");
                               }
                            
//                         
                            else{
                                // validate nid
                                System.out.println("else 9");
                                if (!Validation.allDigits(nid)){AlertGen.unsuccessfulAlert("NID is not valid");System.out.println("if14");}
                                else{
                                    System.out.println("else 10 ");
                                   boolean confimationEmp = AlertGen.confirmationAlert("Do you want to confim to add new?"+" " +employeeType + " of ID: " + employeeID);
                                    if (!confimationEmp){System.out.println("calcel dise if");}
                                    else
                                    {  System.out.println("else 11 e created object");
                                        // confirmationm done
                                        // can create
                                        // all info given
                                        // now create employe
                                        Employee empObj;
                                        boolean flag;
                                        switch (employeeType) {
                                            case "System Administrator":
                                                empObj = new SystemAdministrator( 
                                                        nid,
                                                        employeeType,
                                                        joiningDate,
                                                        1000000,   fullName,
                                                        primMobile,
                                                        primEmail,
                                                        gender, 
                                                        employeeID,
                                                        employeeType, 
                                                        pass,   doB,   
                                                        address, 
                                                        true);
                                                flag = this.admin.createNewUserInstance(empObj, empObj.getCoreUserType(), true);
                                                
                                                break;
                                            case "Station Manager":
   /////////////////// modified project code///////////
        
                                            String noOfEmpManaged = noOfEmpManged.getText();
                                            int noOfemp;
                                            if (Validation.allDigits(noOfEmpManaged)){
                                                noOfemp = Integer.valueOf(noOfEmpManaged);
                                                System.out.println("no " + noOfemp);
                                            }else{
                                                AlertGen.unsuccessfulAlert("No of employee managed must be all digits");
                                                
                                                return; 
                                            }
    
                                                empObj = new StationManager( noOfemp,
                                                        nid,
                                                        employeeType,
                                                        joiningDate,
                                                        1000000,   fullName,
                                                        primMobile,
                                                        primEmail,
                                                        gender, 
                                                        employeeID,
                                                        employeeType, 
                                                        pass,   doB,   
                                                        address, 
                                                        true);
                                                flag = this.admin.createNewUserInstance(empObj, empObj.getCoreUserType(), true);    
                                                System.out.println(empObj.toString()); /// modified
                                               
 ///////////////////////////////////////////////////////////////                                               
                                                
                                                break;
                                            case "Train Operator":
                                                empObj = new TrainOperator( 
                                                        nid,
                                                        employeeType,
                                                        joiningDate,
                                                        1000000,   fullName,
                                                        primMobile,
                                                        primEmail,
                                                        gender, 
                                                        employeeID,
                                                        employeeType, 
                                                        pass,   doB,   
                                                        address, 
                                                        true);
                                                flag = this.admin.createNewUserInstance(empObj, empObj.getCoreUserType(), true);
                                                break;
                                            case "Head of HR":
                                                empObj = new HeadOfHR( 
                                                        nid,
                                                        employeeType,
                                                        joiningDate,
                                                        1000000,   fullName,
                                                        primMobile,
                                                        primEmail,
                                                        gender, 
                                                        employeeID,
                                                        employeeType, 
                                                        pass,   doB,   
                                                        address, 
                                                        true);
                                                flag = this.admin.createNewUserInstance(empObj, empObj.getCoreUserType(), true);
                                                break;
                                            case "Maintenance Staff":
                                                empObj = new MaintenanceStaff( 
                                                        nid,
                                                        employeeType,
                                                        joiningDate,
                                                        1000000,   fullName,
                                                        primMobile,
                                                        primEmail,
                                                        gender, 
                                                        employeeID,
                                                        employeeType, 
                                                        pass,   doB,   
                                                        address, 
                                                        true);
                                                flag = this.admin.createNewUserInstance(empObj, empObj.getCoreUserType(), true);
                                                break;
                                            case "Public Service Provider":
                                                empObj = new PublicServiceProvider( 
                                                        nid,
                                                        employeeType,
                                                        joiningDate,
                                                        1000000,   fullName,
                                                        primMobile,
                                                        primEmail,
                                                        gender, 
                                                        employeeID,
                                                        employeeType, 
                                                        pass,   doB,   
                                                        address, 
                                                        true);
                                                flag = this.admin.createNewUserInstance(empObj, empObj.getCoreUserType(), true);
                                                break;
                                            case "Accountant":
                                                empObj = new Accountant( 
                                                        nid,
                                                        employeeType,
                                                        joiningDate,
                                                        1000000,   fullName,
                                                        primMobile,
                                                        primEmail,
                                                        gender, 
                                                        employeeID,
                                                        employeeType, 
                                                        pass,   doB,   
                                                        address, 
                                                        true);
                                                flag = this.admin.createNewUserInstance(empObj, empObj.getCoreUserType(), true);
                                                break;
                                            default: flag = false;
                                                    empObj = null;
                                                break;
                                                
                                                
                                        }// get out of switch
                                    
                                        if (flag)
                                        {   descriptionObj = new DescriptionOnUserCreation(description,empObj);
                                            System.out.println("Creation successfull");
                                            AlertGen.successfulAlert("Employee scucceesfully added!");
                                            System.out.println("file wirte done");
                                            generateEmployeeId_label.setText("");
                                             
                                            generatePassword_passwordField.clear();
                                            secondaryMobileNo_textField.clear();
                                            secondaryEmail_textField.clear();
                                            nid_textField.clear();
                                            primaryMobileNo_textField.clear();
                                            primaryEmail_textField.clear();
                                             
                                            gender_toggleGroup.selectToggle(null);
                                            dob_datePicker.getEditor().clear();
                                            joiningDate_datePicker.getEditor().clear();
                                            generatePassengerUsername_textField.clear();
                                            //employee_radioButton.setSelected(true);
                                            userType_toggleGroup.selectToggle(employee_radioButton);
                                        }else{AlertGen.unsuccessfulAlert("Something Gone Wrong!");}
                                    }// empobj access seseh
                                }
 
                                }
                               
                        }catch(NullPointerException ex){AlertGen.unsuccessfulAlert("NullPointer! Please reselect each.");}
                            }
                        }
                    }else{AlertGen.unsuccessfulAlert("Pass is not valid!");}
                }
              }else{AlertGen.unsuccessfulAlert("Unvalid Date of Birth!");}

            }

//         }catch(NullPointerException ex){
//            AlertGen.inforamtion("NullPointerException", ex.toString());
//        }    
    }

    @FXML
    private void generateEmployeeIdBtnOnAction(ActionEvent event) 
    {
        try{
           if (joiningDate_datePicker.getValue() == null){
               AlertGen.inforamtion("Empty entry", "Please provide joining date first");
           
           }
           else if (employeeType_comBox.getValue().isEmpty() || !Validation.isValidJoiningDate(joiningDate_datePicker.getValue()))
                   {
                   AlertGen.unsuccessfulAlert("\"Please select fields first\" correctly!");
                   }
           else if (employeeType_comBox.getValue().isEmpty()){
               AlertGen.unsuccessfulAlert("Select employee type");
           }
           else{
               generatedID = this.admin.generateEmployeeID(employeeType_comBox.getValue(), joiningDate_datePicker.getValue());
               if (generatedID == null){
                   AlertGen.unsuccessfulAlert("Null id");
                   return;
               }
               generateEmployeeId_label.setText(generatedID);
           }
//            if ( !employeeType_comBox.getValue().isEmpty() && joiningDate_datePicker.getValue() != null)
//            {this.admin.generateEmployeeID(employeeType_comBox.getValue(), joiningDate_datePicker.getValue());
//                }
//            else{AlertGen.unsuccessfulAlert("Please select fields first");}
        }catch(NullPointerException nu){System.out.println("NULLLLLLLLLLLLLL");
        AlertGen.warningAlert("Warning!", nu.toString());}
       
    }
    @FXML
    private void generatePasswordBtnOnAction(ActionEvent event) {
        generatePassword_passwordField.setText(Validation.generatePassword());
    }

    @FXML
    private void generatePassengerUsernameBtnOnAction(ActionEvent event) {
        String username = Validation.generateUsername();
        while (  SystemAdministrator.checkUserExist(username) ){
            username = Validation.generateUsername();
        }
        generatePassengerUsername_textField.setText(username);
    }
    
    @FXML
    private void showPassCheckBoxOnAction(ActionEvent event) {
       if ( showPass_checkBox.isSelected() ) {
          String pass = generatePassword_passwordField.getText();
          showPass_label.setVisible(true);
          showPass_label.setText(pass);
       }else{
            showPass_label.setVisible(false);
        }
          
    }

}
