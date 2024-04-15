/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package view.faysal.station_manager;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

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
    @FXML
    private HBox dashBoard_hBox;
    @FXML
    private Label dashBoardLabel;
    @FXML
    private HBox addUser;
    @FXML
    private Label profileLabel;
    @FXML
    private HBox logOut_hBox;
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
    private HBox logOut_hBox1;
    @FXML
    private HBox logOut_hBox11;
    @FXML
    private HBox logOut_hBox111;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void dashboardMouseOnClicked(MouseEvent event) {
    }

    @FXML
    private void addUserOnMouseClicked(MouseEvent event) {
    }

    @FXML
    private void addTrainOnMouseClicked(MouseEvent event) {
    }

    @FXML
    private void addTrainOnAction(MouseEvent event) {
    }

    @FXML
    private void addStationOnMouseClicked(MouseEvent event) {
    }

    @FXML
    private void generatePDF(MouseEvent event) {
    }

    @FXML
    private void chartInfoOnMouseClikced(MouseEvent event) {
    }

    @FXML
    private void scheduleOnMouseClicked(MouseEvent event) {
    }

    @FXML
    private void reportOnMouseClicked(MouseEvent event) {
    }

    @FXML
    private void logOutOnMouseClicked(MouseEvent event) {
    }
    
}
