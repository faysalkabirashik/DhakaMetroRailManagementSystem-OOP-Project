/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package view.faysal.systemadmin;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.faysal.AlertGen;
import model.faysal.Train;
import model.faysal.Validation;
import model.faysal.users.SystemAdministrator;







public class SetNewTrainController implements Initializable {

    @FXML
    private TextField trainID_textField;
    @FXML
    private TextField trainName_txtField;
    @FXML
    private ComboBox<String> startStation_comBox;
    @FXML
    private ComboBox<String> destinationStation_comBox;
    @FXML
    private ComboBox<String> route_comBox;
    @FXML
    private TextField totalCar_txt;
    @FXML
    private TextField carCapacity_txt;
    @FXML
    private TextArea note_area;
    @FXML
    private DatePicker openingDate_datePicker;
    @FXML
    private Label totalCap_label;

    private SystemAdministrator admin = new SystemAdministrator();
    private Train train = new Train();
    
    public SystemAdministrator getSystemAdmin(){
        return admin;
    }
    
    public void setSystemAdmin(SystemAdministrator admin){
        
        this.admin =  admin;
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ObservableList<String> routLlist = FXCollections.observableArrayList("MRT Line 1", "MRT Line 2", "MRT Line 6");
        route_comBox.setItems(routLlist);
    }    

    @FXML
    private void saveBtnOnAction(ActionEvent event) {
        try {
            if (trainID_textField.getText().isEmpty() || trainName_txtField.getText().isEmpty() || totalCar_txt.getText().isEmpty() 
                        || carCapacity_txt.getText().isEmpty() || openingDate_datePicker.getValue() == null) {
                AlertGen.unsuccessfulAlert("Fill all data");
            }
            else if (openingDate_datePicker.getValue() == null){
                AlertGen.unsuccessfulAlert("Select date");
            }
            else  if (  Validation.allDigits(totalCar_txt.getText())   
                   &&  Validation.allDigits(carCapacity_txt.getText()))   {

                try {
                    int carCap = Integer.parseInt(carCapacity_txt.getText());
                    int totalCar = Integer.parseInt(totalCar_txt.getText());
                    String id = trainID_textField.getText();
                    String name = trainID_textField.getText();
                    String startingStation = startStation_comBox.getValue();
                    String destinationStation = destinationStation_comBox.getValue();
                    Train train = new Train(id, name, startingStation, destinationStation,
                            route_comBox.getValue(), carCap, totalCar,openingDate_datePicker.getValue() ,note_area.getText());
                    
                    this.admin.addNewTrain(train);
                    AlertGen.successfulAlert("Train added!");
                    
                }catch(Exception ex){AlertGen.unsuccessfulAlert(ex.toString());}

            }
        }catch(Exception ex)
        {
            AlertGen.unsuccessfulAlert(ex.toString());
        }
        
        }
}
