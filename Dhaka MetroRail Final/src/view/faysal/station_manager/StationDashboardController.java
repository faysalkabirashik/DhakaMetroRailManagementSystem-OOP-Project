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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
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
    private void LogoutOnAction(ActionEvent event) throws Exception{

        
        FXMLLoader dashLoader1 = new FXMLLoader(getClass().getResource("/view/faysal/login/LoginScene.fxml"));
        System.out.println("Dash");
        Parent root1 = dashLoader1.load();
        System.out.println("loader");
        Stage window1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window1.setScene(new Scene(root1));
        window1.show();
        
        
        
        
    }

    @FXML
    private void makeAnnouncement(ActionEvent event) {
        
        loadUIAtDashBorderPane("MakeAnnouncement");
        
    }

    @FXML
    private void showRules(ActionEvent event) {
        loadUIAtDashBorderPane("ShowRulesType");
    }



    @FXML
    private void reporting(ActionEvent event) {
        loadUIAtDashBorderPane("Reporting");
    }

    @FXML
    private void schedule(ActionEvent event) {
        loadUIAtDashBorderPane("ScheduleShow");
    }

    @FXML
    private void resourceReq(ActionEvent event) {
        
        loadUIAtDashBorderPane("RequestResource");
    }

    @FXML
    private void fareChart(ActionEvent event) {
        loadUIAtDashBorderPane("FareChart");
        
    }

 
    



    
}
