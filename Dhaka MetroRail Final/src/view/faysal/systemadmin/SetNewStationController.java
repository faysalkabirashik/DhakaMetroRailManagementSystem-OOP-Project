/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package view.faysal.systemadmin;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import model.faysal.AlertGen;
import model.faysal.Station;

/**
 * FXML Controller class
 *
 * @author Faysal Kabir Ashik
 */
public class SetNewStationController implements Initializable {

    @FXML
    private TextField city_textField;
    @FXML
    private TextField id_textField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void saveButtonOnClicked(ActionEvent event) {
        
        List<String> stations = new ArrayList<>();
         
        String serialString = id_textField.getText();
        String city = city_textField.getText();

         
        int serial;
        try {
            serial = Integer.parseInt(serialString);
        } catch (NumberFormatException e) {
            AlertGen.unsuccessfulAlert("Invalid serial number. Please enter a valid integer.");
            return;
        }

        // Check if the station already exists
        for (String station : stations) {
            if (station.startsWith("Station " + serial)) {
                AlertGen.inforamtion(" ", "Station with serial number " + serial + " already exists.");
                return;
                
            }
        }

        // If all checks pass, add the station to your list of stations
        String newStation = "Station " + serial + ": " + city;
        stations.add(newStation);
    }
    
}