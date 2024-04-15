/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package view.jubair.Accountant;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author user
 */
public class EmployeePaayrollController implements Initializable {

    @FXML
    private TextField empIDtextField;
    @FXML
    private TextField empNameTextField;
    @FXML
    private TextField bankAcTextField;
    @FXML
    private TextField empSalaryTextField;
    @FXML
    private ComboBox<?> empDesignationCombobox;
    @FXML
    private TableView<?> empPayrollTableView;
    @FXML
    private TableColumn<?, ?> empIDTableColumn;
    @FXML
    private TableColumn<?, ?> empNameTableColumn;
    @FXML
    private TableColumn<?, ?> empDesignationTableColumn;
    @FXML
    private TableColumn<?, ?> empBankAcTableColumn;
    @FXML
    private TableColumn<?, ?> empSalaryTableColumn;
    @FXML
    private TableColumn<?, ?> statusTableColumn;
    @FXML
    private RadioButton paidRadioButton;
    @FXML
    private RadioButton dueRadioButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void employeePayBackButtonOnAction(ActionEvent event) {
    }

    @FXML
    private void processPayrollButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void viewDataButtonOnClick(ActionEvent event) {
    }
    
}
