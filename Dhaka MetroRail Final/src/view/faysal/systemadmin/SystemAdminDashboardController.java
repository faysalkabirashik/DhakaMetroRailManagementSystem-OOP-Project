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
import model.faysal.users.SystemAdministrator;

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
    @FXML
    private HBox addUser;
    @FXML
    private HBox logOut_hBox1;
    @FXML
    private HBox logOut_hBox11;
    @FXML
    private HBox logOut_hBox111;

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
    
    public void loadUIAtDashBorderPane(String ui) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource(ui+".fxml"));
            adminMainDashboard_borderPane.setCenter(root);
        }
        catch (IOException ex) {
            Logger.getLogger(SystemAdminDashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    



//    private void goalsOnMouseClicked(MouseEvent event) {
//        loadUIAtMainBorderPane("SystemAdminGoals");
//    }
//
//    private void downloadOnMouseClicked(MouseEvent event) {
//        loadUIAtMainBorderPane("CreateNewUser");
//    }

    @FXML
    private void noteTextFieldKeyReleased(KeyEvent event) {
    }

    @FXML
    private void dashboardMouseOnClicked(MouseEvent event) {
        loadUIAtDashBorderPane("SystemAdminGoals");
    }

    @FXML
    private void addUserOnMouseClicked(MouseEvent event) {
        loadUIAtDashBorderPane("CreateNewUser");
    }

    @FXML
    private void addTrainOnMouseClicked(MouseEvent event) {
    }

    @FXML
    private void addTrainOnAction(MouseEvent event) {
    }

    @FXML
    private void addStationOnMouseClicked(MouseEvent event) {
        loadUIAtDashBorderPane("SetNewStation");
    }

    @FXML
    private void generatePDF(MouseEvent event) {
    }

    @FXML
    private void chartInfoOnMouseClikced(MouseEvent event) {
        loadUIAtDashBorderPane("/view/faysal.station_manager/FareChart");
    }

    @FXML
    private void scheduleOnMouseClicked(MouseEvent event) {
         loadUIAtDashBorderPane("/view/faysal.station_manager/ScheduleShow");
    }

    @FXML
    private void reportOnMouseClicked(MouseEvent event) {
        loadUIAtDashBorderPane("/view/faysal.station_manager/Reporting");
    }

    @FXML
<<<<<<< HEAD
    private void logOutOnMouseClicked(MouseEvent event  ) throws Exception{
        
        FXMLLoader dashLoader3 = new FXMLLoader(getClass().getResource("/view/faysal/login/LoginScene.fxml"));
        System.out.println("Dash");
        Parent root1 = dashLoader3.load();
        System.out.println("loader");
        Stage window1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window1.setScene(new Scene(root1));
        window1.show();
        
        
        
=======
    private void logOutOnMouseClicked(MouseEvent event) {
>>>>>>> Jubair-2221134
    }


}
