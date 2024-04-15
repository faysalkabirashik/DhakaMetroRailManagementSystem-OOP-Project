/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package view.faysal.station_manager;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.faysal.AlertGen;
import model.faysal.users.StationManager;

/**
 * FXML Controller class
 *
 * @author Faysal Kabir Ashik
 * 
 * 
 * 
 */
public class ReportingController implements Initializable {

    @FXML
    private TextField titile;
    @FXML
    private TextArea report;

    
    private StationManager sm = new StationManager();
            
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void sumbitOnAction(ActionEvent event) {
        
        if (!titile.getText().isEmpty() || !report.getText().isEmpty() ){
            AlertGen.successfulAlert("Successfull");
            this.sm.makeReport(titile.getText(), report.getText());
            
        } 
        else{
        AlertGen.unsuccessfulAlert("Unsuccessfull");
        }
    }
    
}
