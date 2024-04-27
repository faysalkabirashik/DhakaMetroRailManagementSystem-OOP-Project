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
import model.nayem.Emergency;
import model.nayem.TrainOperator;

public class EmergencySceneController implements Initializable {

    @FXML    private ComboBox emergencyComboBox;
    @FXML    private TextField trainNumberTextField;
    @FXML    private TextArea describeTextArea;
    @FXML    private TextField nextStationTextField;
    TrainOperator to = new TrainOperator();

    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        emergencyComboBox.getItems().addAll("Medical","Fire","Security treats","Tract Obstructions");
    }    

    @FXML
    private void backButtonOnClick(ActionEvent event) throws IOException 
    {
        to.loadDashBoard(event);
    }

    @FXML
    private void submitButtonOnClick(ActionEvent event) throws IOException
    {
        String trainNum = trainNumberTextField.getText();
        String nextStation = nextStationTextField.getText();
        String describe = describeTextArea.getText();
        String type = emergencyComboBox.getItems().toString();
        if (trainNum.isEmpty() || nextStation.isEmpty() || describe.isEmpty()|| type.isEmpty())
        {
            AlertGen.errorAlert("Null Value", "Please Enter Field Values");
        }else{
            Emergency emergency = new Emergency(trainNum,nextStation,
                describe,type);
            to.reportEmergency(emergency);
            AlertGen.successfulAlert("Successfully submitted");
            to.loadDashBoard(event);
        }
    }
    
}
