/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package view.minhaz.maintenanceStaff;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.faysal.AppendableObjectOutputStream;
import model.nayem.Message2;

/**
 * FXML Controller class
 *
 * @author User
 */
public class WeatherAndDifficultiesAlertsController implements Initializable {

    @FXML
    private ComboBox<String> typesOfDifficultiesComboBox;
    @FXML
    private TextField massageTextField;
    @FXML
    private TextField trainNoTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        typesOfDifficultiesComboBox.getItems().addAll("Heavy Rain","Line Blockage","Blockade");
        
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
    private void sendButtonOnClick(ActionEvent event) {
        Message2 mg = new Message2(trainNoTextField.getText(),typesOfDifficultiesComboBox.getItems().toString(),massageTextField.getText());
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;        
        try {
            f = new File("WeatherAndDifficultiesAlerts.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            oos.writeObject(mg);
        } catch (IOException ex) {}
    }
    
}
