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
import model.nayem.Message;
import model.nayem.TrainOperator;

public class MessageToStationManagerController implements Initializable {

    @FXML    private TextField trainNumberTextField;
    @FXML    private ComboBox targetStationComboBox;
    @FXML    private ComboBox messageTypeComboBox;
    @FXML    private TextField estimatedTimeTextField;
    @FXML    private ComboBox passengerLoadComboBox;
    @FXML    private TextArea othersTextArea;
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        messageTypeComboBox.getItems().addAll("Arrival", "Departure","Passenger Load","Late Status","Others");
        targetStationComboBox.getItems().addAll("Uttara","Mirpur","Kichu ekta","Akashe-Batashe");
        passengerLoadComboBox.getItems().addAll("Low","Medium","High","Extreme");
    }    

    @FXML
    private void messageTypeComboBoxOnAction(ActionEvent event) 
    {
        if (messageTypeComboBox.getValue().equals("Others"))
        {
            passengerLoadComboBox.setDisable(true); estimatedTimeTextField.setDisable(true); othersTextArea.setDisable(false);
        }
        else if (messageTypeComboBox.getValue().equals("Passenger Load"))
        {
            passengerLoadComboBox.setDisable(false); estimatedTimeTextField.setDisable(true); othersTextArea.setDisable(true);
        }
        else
        {
            passengerLoadComboBox.setDisable(true); estimatedTimeTextField.setDisable(false); othersTextArea.setDisable(true);
        }
    }

    @FXML
    private void backButtonOnClicked(ActionEvent event) throws IOException 
    {
        TrainOperator to = new TrainOperator();
        to.loadDashBoard(event);
    }

    @FXML
    private void sendButtonOnClicked(ActionEvent event)
    {
        TrainOperator to = new TrainOperator();
        if (messageTypeComboBox.getValue().equals("Others"))
        {
            Message message = new Message(trainNumberTextField.getText(), 
                    targetStationComboBox.getValue().toString(),
                    messageTypeComboBox.getValue().toString(),
                    othersTextArea.getText());
        }
        else if (messageTypeComboBox.getValue().equals("Passenger Load"))
        {
            Message message = new Message(trainNumberTextField.getText(), 
                    targetStationComboBox.getValue().toString(),
                    messageTypeComboBox.getValue().toString(),
                    passengerLoadComboBox.getValue().toString());
        }
        Message message = new Message(trainNumberTextField.getText(), 
                targetStationComboBox.getValue().toString(),
                messageTypeComboBox.getValue().toString(),
                estimatedTimeTextField.getText());
        
       to.messageToStationManager(message);
    }
    
}
