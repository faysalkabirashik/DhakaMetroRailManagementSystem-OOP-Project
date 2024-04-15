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
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.jubair.hr.Recruitment;
import view.jubair.Accountant.EmployeePaayrollController;

/**
 * FXML Controller class
 *
 * @author user
 */
public class RecruitmentController implements Initializable {

    @FXML
    private TextField recruitmentDetailsTextField;
    @FXML
    private TextField empSalaryTextField;
    @FXML
    private ComboBox<String> empDesignationCombobox;
    @FXML
    private DatePicker recruitmentDatePicker;
    @FXML
    private TableColumn<Recruitment, String> dateTableColumn;
    @FXML
    private TableColumn<Recruitment, String> recruitmentDetailsTableColumn;
    @FXML
    private TableColumn<Recruitment, String> emSalaryTableColumn;
    @FXML
    private TableColumn<Recruitment, String> recruitmentPositionTableColumn;
    @FXML
    private TableView<Recruitment> RecruitmentTableView;
    
        ArrayList<Recruitment> recruitmentList;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        empDesignationCombobox.getItems().addAll("HR", "Accountant", "Station Manager", "Train Operator", "Maintenance Staff", "Public Service Provider");

        recruitmentList = new ArrayList<>();
        
        
        
        dateTableColumn.setCellValueFactory(new PropertyValueFactory<>("recruitmentDate"));
        recruitmentDetailsTableColumn.setCellValueFactory(new PropertyValueFactory<>("details"));
        emSalaryTableColumn.setCellValueFactory(new PropertyValueFactory<>("salary"));
        recruitmentPositionTableColumn.setCellValueFactory(new PropertyValueFactory<>("designation"));
        
        
        // TODO
    }    

    @FXML
    private void dailyAttendanceBackButtonOnAction(ActionEvent event) {
    }

    @FXML
    private void initiateButtonOnClick(ActionEvent event) {
        
        Recruitment newRecruitment = new Recruitment(
                recruitmentDetailsTextField.getText(),
                empSalaryTextField.getText(),
                empDesignationCombobox.getValue(),
                recruitmentDatePicker.getValue()
                
        );
                
                
                
        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            f = new File("Recruitment.bin");
            if(f.exists()) {fos = new FileOutputStream(f,true);}
            else {fos = new FileOutputStream(f);}
            oos = new ObjectOutputStream(fos);
            oos.writeObject(newRecruitment);
        } catch (IOException ex) {
            Logger.getLogger(EmployeePaayrollController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(EmployeePaayrollController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }        
    

        recruitmentList.add(newRecruitment);
        
        RecruitmentTableView.getItems().clear();
        RecruitmentTableView.getItems().addAll(recruitmentList);
    
        clearFields();
        
    }
    
    private void clearFields() {
        
        recruitmentDetailsTextField.clear();
        empSalaryTextField.clear();
    }

    
}
