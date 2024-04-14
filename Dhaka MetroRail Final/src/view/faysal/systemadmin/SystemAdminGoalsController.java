/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package view.faysal.systemadmin;

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
import javafx.scene.layout.BorderPane;
import model.faysal.users.SystemAdministrator;

/**
 * FXML Controller class
 *
 * @author Faysal Kabir Ashik
 */
public class SystemAdminGoalsController implements Initializable {

    @FXML
     BorderPane adminMainGoals_borderPane;

        private SystemAdministrator admin;
    public SystemAdministrator getSystemAdmin(){
        return admin;
    }
    
    public void setSystemAdmin(SystemAdministrator admin){
        
        this.admin =  admin;
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    
    public void loadUIAtGaolsBorderPane(String ui) throws RuntimeException{
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource(ui+".fxml"));
            adminMainGoals_borderPane.setCenter(root);
            
        }
        catch (IOException ex) {
            Logger.getLogger(SystemAdminGoalsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @FXML
    private void manageTrainConfigBtnOnAction(ActionEvent event) {
        loadUIAtGaolsBorderPane("TrainConfigurationOption");
        
    }

    @FXML
    private void manageStationConfigBtnOnAction(ActionEvent event) {
        loadUIAtGaolsBorderPane("StationConfigurationOption");
    }


    @FXML
    private void manageUserAccountOnAction(ActionEvent event) {
       loadUIAtGaolsBorderPane( "UserAccountManagingOption");
    }

    @FXML
    private void manageTrainScheduleBtnOnAction(ActionEvent event) {
    }

    @FXML
    private void manageRouteAndTripBtnOnAction(ActionEvent event) {
    }

    @FXML
    private void manageFareBtnOnAction(ActionEvent event) {
    }

    @FXML
    private void accessSystemBtnOnAction(ActionEvent event) {
    }

    @FXML
    private void manageEmergencySupportBtnOnAction(ActionEvent event) {
    }

    @FXML
    private void generateReportBtnOnAction(ActionEvent event) {
    }
    
}
