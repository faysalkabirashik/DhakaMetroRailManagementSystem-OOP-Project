/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package view.minhaz.maintenanceStaff;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.minhaz.maintenanceStaff.Equipment;

/**
 * FXML Controller class
 *
 * @author User
 */
public class EquipmentRecordsController implements Initializable {

    @FXML
    private TableColumn<Equipment, String> serialTableCol;
    @FXML
    private TableColumn<Equipment, String> maintenaceHistoryTableCol;
    @FXML
    private TableColumn<Equipment, String> currentStatusTableCol;
    @FXML
    private TextField EqipSerialTextField;
    @FXML
    private TextField EqipCurrentStatusTextField;
    @FXML
    private TextField EqipMaintenanceHistorylTextField;
    @FXML
    private TableView<Equipment> equipmentTable;
    
    ArrayList <Equipment> equipmentList;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        equipmentList = new ArrayList<>();
        serialTableCol.setCellValueFactory(new PropertyValueFactory<>("sl"));
        maintenaceHistoryTableCol.setCellValueFactory(new PropertyValueFactory<>("mainHIstory"));
        currentStatusTableCol.setCellValueFactory(new PropertyValueFactory<>("currentStatus"));
        // TODO
    }    

    @FXML
    private void backButtonOnClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MaintenanceStaffDashboard.fxml"));
        Parent parent = loader.load();
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene newScene = new Scene(parent);
        currentStage.setScene(newScene);
        currentStage.show();
    
    }

    @FXML
    private void equiipmentRecordButtonOnClick(ActionEvent event) {
        
        Equipment newEquipment=new Equipment(
        
            Integer.parseInt(EqipSerialTextField.getText()),
                EqipMaintenanceHistorylTextField.getText(),
            EqipCurrentStatusTextField.getText()
            
                
            );
        
        equipmentList.add(newEquipment);
        equipmentTable.getItems().clear();
        equipmentTable.getItems().addAll(equipmentList);
        
    }
    
}
