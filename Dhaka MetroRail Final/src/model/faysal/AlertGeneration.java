

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
    
    public static void errorAlert(String headerStr, String contentStr)
    {
        Alert crashAlert = new Alert(Alert.AlertType.ERROR);
        crashAlert.setTitle("Error");
        crashAlert.setHeaderText(headerStr);
        crashAlert.setContentText(contentStr);
        crashAlert.showAndWait();
    }
    public static void warningAlert(String headerStr, String contentStr)
    {
        Alert warningAlert = new Alert(Alert.AlertType.ERROR);
        warningAlert.setTitle("Warning!");
        warningAlert.setHeaderText(headerStr);
        warningAlert.setContentText(contentStr);
        warningAlert.showAndWait();
    }

    static void errorAlert(Exception e) 
    {
        Alert crashAlert = new Alert(Alert.AlertType.ERROR);
        crashAlert.setTitle("Error");
        crashAlert.setHeaderText(e.toString());
        crashAlert.showAndWait();   
    }

}