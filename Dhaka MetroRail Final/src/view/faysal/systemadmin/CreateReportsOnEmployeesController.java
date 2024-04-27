/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package view.faysal.systemadmin;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Faysal Kabir Ashik
 */
public class CreateReportsOnEmployeesController implements Initializable {

    @FXML
    private TableView<?> emp_TableView;
    @FXML
    private TableColumn<?, ?> id_tC;
    @FXML
    private TableColumn<?, ?> name_tC;
    @FXML
    private TableColumn<?, ?> designation_tC;
    @FXML
    private ComboBox<?> employeeType_comBox;
    @FXML
    private TextField enter_textF;
    @FXML
    private TextArea enterDetails_textArea;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void selectEmployeeOnClick(ActionEvent event) {
    }

    @FXML
    private void submitReportOnClick(ActionEvent event) {
    }

    @FXML
    private void typeComBoxOnAction(ActionEvent event) {
    }
    
}
