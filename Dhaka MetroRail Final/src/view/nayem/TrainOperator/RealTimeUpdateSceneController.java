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
import model.nayem.TrainOperator;
import model.nayem.Update;

public class RealTimeUpdateSceneController implements Initializable {

    @FXML    private TextField trainNumberTextField;
    @FXML    private ComboBox<String> updateTypeComboBox;
    @FXML    private TextField timeTextField;
    @FXML    private ComboBox <String>selectStationComboBox;
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
        }
    }

    @FXML
    private void bakButtonOnClick(ActionEvent event) throws IOException 
    {
        to.loadDashBoard(event);
    }

    @FXML
    private void updateButtonOnClick(ActionEvent event) 
    {
        if (updateTypeComboBox.getItems().equals("Others"))
        {
            update = new Update(trainNumberTextField.getText(),timeTextField.getText(),updateTypeComboBox.getValue(),remarkTextArea.getText());
        }
        else{
            update = new Update(trainNumberTextField.getText(),timeTextField.getText(),updateTypeComboBox.getValue(),selectStationComboBox.getValue());
        }
        
        to.realTimeUpdate(update);
    }
    
}
