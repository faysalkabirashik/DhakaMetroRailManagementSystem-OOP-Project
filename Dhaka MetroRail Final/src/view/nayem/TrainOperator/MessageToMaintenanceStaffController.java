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
import model.faysal.AlertGen;
import model.nayem.Message2;
import model.nayem.TrainOperator;

public class MessageToMaintenanceStaffController implements Initializable {

    @FXML    private TextField trainNumberTextField;
    @FXML    private ComboBox <String>reportTypeComboBox;
    @FXML    private ComboBox <String>problemComboBox;
    @FXML    private TextArea othersTextArea;
    Message2 message;
    @FXML    private ComboBox<String> fuelIndicationComboBox;

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
    private void sendButtonOnClick(ActionEvent event) throws IOException
    {
        String train = trainNumberTextField.getText();
        String rType = reportTypeComboBox.getValue();
        String problem = problemComboBox.getValue();
        String others = othersTextArea.getText();
        String fuel = fuelIndicationComboBox.getValue();
        if(train.isEmpty()&&rType.isEmpty()&&problem.isEmpty()&&others.isEmpty()&&fuel.isEmpty())
        {
            AlertGen.errorAlert("Value Error", "Enter All Field Values");
        }
        else
        {
            if (reportTypeComboBox.getValue().equals("Technical Issues") || reportTypeComboBox.getValue().equals("Equipment Malfunction") )
            {
                if(trainNumberTextField.getText().isEmpty()||reportTypeComboBox.getValue().isEmpty()||problemComboBox.getValue().isEmpty())
                {
                    AlertGen.errorAlert("Value Error", "Enter All Field Values");
                }
                else
                {
                    message = new Message2(trainNumberTextField.getText(),reportTypeComboBox.getValue(), problemComboBox.getValue());
                    TrainOperator to = new TrainOperator();
                    to.messageToMaintenanceStaff(message);
                    AlertGen.successfulAlert("Sent Successfully");
                    to.loadDashBoard(event);
                }
            }
            else if (reportTypeComboBox.getValue().equals("Unusual sound and vibration")||reportTypeComboBox.getValue().equals("Emergency repair")||reportTypeComboBox.getValue().equals("Spare parts inventory"))
            {
                if(trainNumberTextField.getText().isEmpty()||reportTypeComboBox.getValue().isEmpty()||othersTextArea.getText().isEmpty())
                {
                    AlertGen.errorAlert("Value Error", "Enter All Field Values");
                }
                else
                {
                    message = new Message2(trainNumberTextField.getText(),reportTypeComboBox.getValue(), othersTextArea.getText());
                    TrainOperator to = new TrainOperator();
                    to.messageToMaintenanceStaff(message);
                    AlertGen.successfulAlert("Sent Successfully");
                    to.loadDashBoard(event);
                }
            }
            else
            {
                message = new Message2(trainNumberTextField.getText(),reportTypeComboBox.getValue(), fuelIndicationComboBox.getValue());
                TrainOperator to = new TrainOperator();
                to.messageToMaintenanceStaff(message);
                AlertGen.successfulAlert("Sent Successfully");
                to.loadDashBoard(event);
            }
        }
    }
    
}
