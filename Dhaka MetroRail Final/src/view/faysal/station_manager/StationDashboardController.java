/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package view.faysal.station_manager;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import view.faysal.systemadmin.SystemAdminDashboardController;

/**
 * FXML Controller class
 *
 * @author Faysal Kabir Ashik
 */
public class StationDashboardController implements Initializable {

    @FXML
    private BorderPane adminMainDashboard_borderPane;
    @FXML
    private TextField note_textField;
    @FXML
    private Label name_label;

    public void loadUIAtDashBorderPane(String ui) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource(ui+".fxml"));
            adminMainDashboard_borderPane.setCenter(root);
        }
        catch (IOException ex) {
            Logger.getLogger(StationDashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void rulesOnAction(ActionEvent event) {
        
        loadUIAtDashBorderPane("Rules");
    }

    @FXML
    private void LogoutOnAction(ActionEvent event) {
        
    }


    
}
