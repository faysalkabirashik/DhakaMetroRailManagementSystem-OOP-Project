/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package view.faysal.systemadmin;

import java.net.URL;
 
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
 
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
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
    @FXML
    private ListView<String> station_listView;
    
    List<String> stations = Station.getList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
        
        station_listView.setItems(FXCollections.observableArrayList(stations));
      
    }    


    @FXML
    private void saveButtonOnClicked(ActionEvent event) {
 
        String serialString = id_textField.getText();
        String city = city_textField.getText();

 
        int serial;
        try {
            serial = Integer.parseInt(serialString);
        } catch (NumberFormatException e) {

            AlertGen.unsuccessfulAlert("Invalid serial number. Please enter a valid integer.");
            return;
        }

 
        for (String station : stations) {
            if (station.startsWith("Station " + serial)) {
        
 
                AlertGen.unsuccessfulAlert("Station with serial number " + serial + " already exists.");
                return;
            }
        }

 
        String newStation = "Station " + serial + ": " + city;
        stations.add(newStation);

 
        station_listView.setItems(FXCollections.observableList(stations));
    }
}
    
