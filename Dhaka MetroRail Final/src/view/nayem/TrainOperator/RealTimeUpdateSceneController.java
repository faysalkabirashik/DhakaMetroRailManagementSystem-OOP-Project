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
import model.nayem.TrainOperator;
import model.nayem.Update;

public class RealTimeUpdateSceneController implements Initializable {

    @FXML    private TextField trainNumberTextField;
    @FXML    private ComboBox updateTypeComboBox;
    @FXML    private TextField timeTextField;
    @FXML    private ComboBox selectStationComboBox;
    @FXML    private TextArea remarkTextArea;
    
    TrainOperator to = new TrainOperator();
    Update update;

    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        updateTypeComboBox.getItems().addAll("Arrival","Depurture","Others","Crossed");
        selectStationComboBox.getItems().addAll("Uttora","Mirpur","DU","Tejgaon");
    }    

    @FXML
    private void updateTypeComboBoxOnAction(ActionEvent event) 
    {
        if (updateTypeComboBox.getItems().equals("Others"))
        {
            selectStationComboBox.setDisable(true);
            remarkTextArea.setDisable(false);
        }
        else{
            selectStationComboBox.setDisable(false);
            remarkTextArea.setDisable(true);
        }
    }

    @FXML
    private void bakButtonOnClick(ActionEvent event) throws IOException 
    {
        to.loadDashBoard(event);
    }

    @FXML
    private void updateButtonOnClick(ActionEvent event) throws IOException 
    {
        if (trainNumberTextField.getText().isEmpty() || timeTextField.getText().isEmpty()||updateTypeComboBox.getValue()==null||remarkTextArea.getText().isEmpty()
                    || selectStationComboBox.getValue()==null)
        {
            AlertGen.errorAlert("Value Error", "Enter All Value Fields.");
        }else{
            if(updateTypeComboBox.getItems().equals("Others"))
        {
            
            if(trainNumberTextField.getText().isEmpty() || timeTextField.getText().isEmpty()||updateTypeComboBox.getValue()==null||remarkTextArea.getText().isEmpty()
                    )
            {
                AlertGen.errorAlert("Value Error", "Enter All Value Fields.");
            }
            else
            {
                update = new Update(trainNumberTextField.getText(),timeTextField.getText(),updateTypeComboBox.getValue().toString(),remarkTextArea.getText());
                to.realTimeUpdate(update);
                AlertGen.successfulAlert("Updated Successfully");
                to.loadDashBoard(event);
            }
        }
        else{
            if(trainNumberTextField.getText().isEmpty() || timeTextField.getText().isEmpty()||updateTypeComboBox.getValue()==null||
                    selectStationComboBox.getItems()==null||remarkTextArea.getText().isEmpty())
            {
                AlertGen.errorAlert("Value Error", "Enter All Value Fields.");
            }
            else
            {
                update = new Update(trainNumberTextField.getText(),timeTextField.getText(),updateTypeComboBox.getValue().toString(),selectStationComboBox.getValue().toString());
                to.realTimeUpdate(update);
                AlertGen.successfulAlert("Updated Successfully");
                to.loadDashBoard(event);
            }
        }
        }
    }
    
}
