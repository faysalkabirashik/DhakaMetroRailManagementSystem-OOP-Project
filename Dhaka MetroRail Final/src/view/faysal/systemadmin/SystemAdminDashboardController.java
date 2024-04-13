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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author Faysal Kabir Ashik
 */
public class SystemAdminDashboardController implements Initializable {

    @FXML
    BorderPane adminMainDashboard_borderPane;
    @FXML
    private TextField note_textField;
    @FXML
    private Label name_label;
    @FXML
    private HBox dashBoard_hBox;
    @FXML
    private Label dashBoardLabel;
    @FXML
    private HBox profile_hBox;
    @FXML
    private Label profileLabel;
    @FXML
    private HBox goals_hBox;
    @FXML
    private Label expencesLID;
    @FXML
    private HBox download_Hbox;
    @FXML
    private Label downloadLid;
    @FXML
    private HBox notifications_hBox;
    @FXML
    private Label downloadLid1;
    @FXML
    private HBox logOut_hBox;

    /**
     * Initializes the controller class.
     * @param url
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void loadUIAtMainBorderPane(String ui) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource(ui+".fxml"));
            adminMainDashboard_borderPane.setCenter(root);
        }
        catch (IOException ex) {
            Logger.getLogger(SystemAdminDashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    @FXML
    private void noteTextFieldKeyReleased(KeyEvent event) {
    }

    @FXML
    private void dashboardMouseOnClicked(MouseEvent event) {
       
    }

    @FXML
    private void profileMouseOnClicked(MouseEvent event) {
    }

    @FXML
    private void goalsOnMouseClicked(MouseEvent event) {
        loadUIAtMainBorderPane("SystemAdminGoals");
    }

    @FXML
    private void downloadOnMouseClicked(MouseEvent event) {
        loadUIAtMainBorderPane("CreateNewUser");
    }

    @FXML
    private void notificationsOnMouseClicked(MouseEvent event) {
    }

    @FXML
    private void logOutOnMouseClicked(MouseEvent event) {
    }
    
}
