package view.jubair.Accountant;

 

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import model.faysal.users.Employee;

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
    private ComboBox<String> empDesignationCombobox;
    @FXML
    private TableView<Employee> empPayrollTableView;
    @FXML
    private TableColumn<Employee, Integer> empIDTableColumn;
    @FXML
    private TableColumn<Employee, String> empNameTableColumn;
    @FXML
    private TableColumn<Employee, String> empDesignationTableColumn;
    @FXML
    private TableColumn<Employee, String> empBankAcTableColumn;
    @FXML
    private TableColumn<Employee, Float> empSalaryTableColumn;
    @FXML
    private TableColumn<Employee, String> statusTableColumn;
    @FXML
    private RadioButton paidRadioButton;
    @FXML
    private RadioButton dueRadioButton;

    ArrayList<Employee> employeeList;
    ToggleGroup statusToggleGroup;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        statusToggleGroup = new ToggleGroup();
        paidRadioButton.setToggleGroup(statusToggleGroup);
        dueRadioButton.setToggleGroup(statusToggleGroup);

        empDesignationCombobox.getItems().addAll("HR", "Accountant", "Station Manager", "Train Operator", "Maintenance Staff", "Public Service Provider");

        employeeList = new ArrayList<>();

        empIDTableColumn.setCellValueFactory(new PropertyValueFactory<>("userIdentity"));
        empNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("userName"));
        empDesignationTableColumn.setCellValueFactory(new PropertyValueFactory<>("empDesignation"));
        empBankAcTableColumn.setCellValueFactory(new PropertyValueFactory<>("empBankAc"));
        empSalaryTableColumn.setCellValueFactory(new PropertyValueFactory<>("empSalary"));
        statusTableColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
    }

    @FXML
    private void processPayrollButtonOnClick(ActionEvent event) {
        String status = "";
        if (paidRadioButton.isSelected()) {
            status = "Paid";
        } else if (dueRadioButton.isSelected()) {
            status = "Due";
        }
//
//        EmployeeAc newEmployee = new EmployeeAc(
//                Integer.parseInt(empIDtextField.getText()),
//                bankAcTextField.getText(),
//                empNameTextField.getText(),
//                empDesignationCombobox.getValue(),
//                Float.parseFloat(empSalaryTextField.getText()),
//                status
//        );
//
//        employeeList.add(newEmployee);
//        clearFields();
    }

    @FXML
    private void viewDataButtonOnClick(ActionEvent event) {
        empPayrollTableView.getItems().clear();
        empPayrollTableView.getItems().addAll(employeeList);
    }

    private void clearFields() {
        empIDtextField.clear();
        empNameTextField.clear();
        bankAcTextField.clear();
        empSalaryTextField.clear();
        statusToggleGroup.selectToggle(null);
    }
}
