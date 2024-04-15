/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package view.jubair.headofHR;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.jubair.hr.Attendance;
import view.jubair.Accountant.EmployeePaayrollController;

/**
 * FXML Controller class
 *
 * @author user
 */
public class dailyAttendanceController implements Initializable {

    @FXML
    private TextField empIDtextField;
    @FXML
    private TextField empNameTextField;
    @FXML
    private ComboBox<String> empDesignationCombobox;
    @FXML
    private DatePicker selectDatepicker;
    @FXML
    private TableView<Attendance> dailyAttendanceTableView;
    @FXML
    private TableColumn<Attendance, String> dateTableColumn;
    @FXML
    private TableColumn<Attendance, String> employeeIdTableColumn;
    @FXML
    private TableColumn<Attendance, String> employeeNameTableColumn;
    @FXML
    private TableColumn<Attendance, String> designationTableColumn;
    @FXML
    private TableColumn<Attendance, String> attendanceTableColumn;
    
    ArrayList<Attendance> attendanceList;
    ToggleGroup statusToggleGroup;
    @FXML
    private RadioButton presentRadioButton;
    @FXML
    private RadioButton absentRadioButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        statusToggleGroup = new ToggleGroup();
        presentRadioButton.setToggleGroup(statusToggleGroup);
        absentRadioButton.setToggleGroup(statusToggleGroup);

        empDesignationCombobox.getItems().addAll("HR", "Accountant", "Station Manager", "Train Operator", "Maintenance Staff", "Public Service Provider");

        attendanceList = new ArrayList<>();
        
        
        dateTableColumn.setCellValueFactory(new PropertyValueFactory<>("attendDate"));
        employeeIdTableColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        employeeNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        designationTableColumn.setCellValueFactory(new PropertyValueFactory<>("Designation"));
        attendanceTableColumn.setCellValueFactory(new PropertyValueFactory<>("satus"));
        

        // TODO
    }    

    @FXML
    private void dailyAttendanceBackButtonOnAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("headofHRDashBoard.fxml"));
        Parent parent = loader.load();
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene newScene = new Scene(parent);
        currentStage.setScene(newScene);
        currentStage.show();
        
        
    }

    @FXML
    private void saveButtonOnClick(ActionEvent event) {
        String satus = "";
        if (presentRadioButton.isSelected()) {
            satus = "Present";
        } else if (absentRadioButton.isSelected()) {
            satus = "Absent";
        }
        
        Attendance newAttendance = new Attendance(
                empIDtextField.getText(),
                empNameTextField.getText(),
                empDesignationCombobox.getValue(),
                satus,
                selectDatepicker.getValue()   
                
        );
        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            f = new File("Attendance.bin");
            if(f.exists()) {fos = new FileOutputStream(f,true);}
            else {fos = new FileOutputStream(f);}
            oos = new ObjectOutputStream(fos);
            oos.writeObject(newAttendance);
        } catch (IOException ex) {
            Logger.getLogger(EmployeePaayrollController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(EmployeePaayrollController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }        
    

        attendanceList.add(newAttendance);
        clearFields();
    }


    @FXML
    private void viewButtonOnClick(ActionEvent event) {
        
        dailyAttendanceTableView.getItems().clear();
        dailyAttendanceTableView.getItems().addAll(attendanceList);
    }
    
    private void clearFields() {
        
        empIDtextField.clear();
        empNameTextField.clear();
        statusToggleGroup.selectToggle(null);
    }
    
    
}
