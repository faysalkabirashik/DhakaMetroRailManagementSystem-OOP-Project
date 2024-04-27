/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.faysal.station_manager;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Acer
 */
public class MakeAnnouncementController implements Initializable {

    @FXML
    private TextField trainNameTextField;
    @FXML
    private TextField platformTextField;
    @FXML
    private TextField arriveTimeTextField;
    @FXML
    private TextField trainIdTextField;
    @FXML
    private Label trainDetailsLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void showResultButtonOnClick(MouseEvent event) {
        trainDetailsLabel.setText(
        "Train Details:"+"Train Name: "+
                trainNameTextField.getText()
                  + " Platform name:"  + " "  +   
               
                platformTextField.getText()
                       
                 + "Arrive Time: " +"/n"+
                arriveTimeTextField.getText()
                     + "Train Id: "  +"/n"+ 
                trainIdTextField.getText()
                
        
        
        );
        
    }
    
}
