package view.nayem.TrainOperator;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.nayem.Message2;
import model.nayem.TrainOperator;

public class MessageToMaintenanceCrewController implements Initializable {

    @FXML    private TextField trainNumberTextField;
    @FXML    private ComboBox reportTypeComboBox;
    @FXML    private ComboBox problemComboBox;
    @FXML    private TextArea othersTextArea;
    Message2 message;
    @FXML    private ComboBox fuelIndicationComboBox;

    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        reportTypeComboBox.getItems().addAll("Technical Issues", "Equipment Malfunction","Unusual sound and vibration","Fuel level","Emergency repair","Spare parts inventory");
        problemComboBox.getItems().addAll("Engine","Brakes","Signaling","On-board");
        fuelIndicationComboBox.getItems().addAll("Low","Medium","High");
    }    

    @FXML
    private void reportTypeComboBoxOnAction(ActionEvent event) 
    {
        if (reportTypeComboBox.getValue().equals("Technical Issues") || reportTypeComboBox.getValue().equals("Equipment Malfunction") )
        {
            problemComboBox.setDisable(false); fuelIndicationComboBox.setDisable(true); othersTextArea.setDisable(true);
        }
        else if (reportTypeComboBox.getValue().equals("Unusual sound and vibration")||reportTypeComboBox.getValue().equals("Emergency repair")||reportTypeComboBox.getValue().equals("Spare parts inventory"))
        {
            problemComboBox.setDisable(true); fuelIndicationComboBox.setDisable(true); othersTextArea.setDisable(false);
        }
        else
        {
            problemComboBox.setDisable(true); fuelIndicationComboBox.setDisable(false); othersTextArea.setDisable(true);
        }
    }


    @FXML
    private void backButtonOnClick(ActionEvent event) throws IOException 
    {
        TrainOperator to = new TrainOperator();
        to.loadDashBoard(event);
    }

    @FXML
    private void sendButtonOnClick(ActionEvent event) 
    {
        if (reportTypeComboBox.getValue().equals("Technical Issues") || reportTypeComboBox.getValue().equals("Equipment Malfunction") )
        {
            message = new Message2(trainNumberTextField.getText(),reportTypeComboBox.getValue().toString(), problemComboBox.getValue().toString());
        }
        else if (reportTypeComboBox.getValue().equals("Unusual sound and vibration")||reportTypeComboBox.getValue().equals("Emergency repair")||reportTypeComboBox.getValue().equals("Spare parts inventory"))
        {
            message = new Message2(trainNumberTextField.getText(),reportTypeComboBox.getValue().toString(), othersTextArea.getText());
        }
        else
        {
            message = new Message2(trainNumberTextField.getText(),reportTypeComboBox.getValue().toString(), fuelIndicationComboBox.getValue().toString());
        }
        
        TrainOperator to = new TrainOperator();
        to.messageToMaintenanceStaff(message);
    }
    
}
