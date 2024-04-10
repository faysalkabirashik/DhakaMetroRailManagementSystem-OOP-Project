/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.faysal;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 *
 * @author Faysal Kabir Ashik
 */
public class AlertGeneration {
    public static void successfulAlert(String str){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("Successfull");
            alert.setContentText(str);
            alert.showAndWait();
    }
    public static void unsuccessfulAlert(String str){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("Unsuccessfull!");
            alert.setContentText(str);
            alert.showAndWait(); 
    }
    
    public static boolean confirmationAlert(){
        Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmationAlert.setTitle("Confirmation");
        confirmationAlert.setHeaderText("Your confirmation is needed.");
        confirmationAlert.setContentText("Do you want to confirm?");
        
        ButtonType result = confirmationAlert.showAndWait().orElse(ButtonType.CANCEL);
        
        return result == ButtonType.OK;
    }
    
    public static void crashOrInteruptErrorAlert(String str)
    {
        Alert crashAlert = new Alert(Alert.AlertType.ERROR);
        crashAlert.setTitle("Error");
        crashAlert.setHeaderText("Something has gone wrong");
        crashAlert.setContentText(str);
    }
    public static void warningAlert(String str)
    {
        Alert warningAlert = new Alert(Alert.AlertType.ERROR);
        warningAlert.setTitle("Warning!");
        warningAlert.setHeaderText("Warning! Attention needed.");
        warningAlert.setContentText(str);
    }
    
    
}