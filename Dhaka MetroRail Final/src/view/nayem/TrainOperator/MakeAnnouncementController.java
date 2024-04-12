package view.nayem.TrainOperator;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.nayem.TrainOperator;
public class MakeAnnouncementController implements Initializable {

    @FXML    private ComboBox announcementTypeComboBox;
    @FXML    private TextField trianNumberTextField;
    @FXML    private Label destinationLabel;
    @FXML    private ComboBox nextStationComboBox;
    @FXML    private TextField runningLateTimeTextBox;
    @FXML    private TextField runningLateCauseTextField;
    @FXML    private ComboBox addUpMessageComboBox;
    @FXML    private ComboBox pregeneratedAlertComboBox;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        announcementTypeComboBox.getItems().addAll("Train Status","Running Late","Alert");
        pregeneratedAlertComboBox.getItems().addAll("Mind your gaps","Platform is left side");
        nextStationComboBox.getItems().addAll("Uttara 1","Mirpur");
    }    

    @FXML
    private void announcementTypeOnAction(ActionEvent event) 
    {
        if (announcementTypeComboBox.getValue().equals("Train Status"))
        {
            nextStationComboBox.setDisable(false);
            runningLateTimeTextBox.setDisable(true); runningLateCauseTextField.setDisable(true); addUpMessageComboBox.setDisable(true);
            pregeneratedAlertComboBox.setDisable(true);    
        }
        else if (announcementTypeComboBox.getValue().equals("Running Late"))
        {
            nextStationComboBox.setDisable(true);
            runningLateTimeTextBox.setDisable(false); runningLateCauseTextField.setDisable(false); addUpMessageComboBox.setDisable(false);
            pregeneratedAlertComboBox.setDisable(true); 
        }
        else if (announcementTypeComboBox.getValue().equals("Alert"))
        {
            nextStationComboBox.setDisable(true);
            runningLateTimeTextBox.setDisable(true); runningLateCauseTextField.setDisable(true); addUpMessageComboBox.setDisable(true);
            pregeneratedAlertComboBox.setDisable(false); 
        }
    String trainNumber = trianNumberTextField.getText();
        if (trainNumber.equals("01"))
        {
            destinationLabel.setText("Motijhil");
        }
        else if (trainNumber.equals("02"))
        {
            destinationLabel.setText("DU");
        }
        else if (trainNumber.equals("03"))
        {
            destinationLabel.setText("Maltapur");
        }
    }

    @FXML
    private void trainNumberTextBoxOnAction(ActionEvent event) 
    {
        //
    }

    @FXML
    private void generateAnnouncementButtonOnClicked(ActionEvent event) throws IOException 
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/view/nayem/TrainOperator/MakeAnnouncement2.fxml"));
        Parent scene2Parent = loader.load();
        Scene scene2 = new Scene(scene2Parent);
        MakeAnnouncement2Controller controller2 = loader.getController();
        if (announcementTypeComboBox.getValue().equals("Train Status"))
        {
            controller2.recieveData(destinationLabel.getText(), (String) nextStationComboBox.getValue());
        }
        else if (announcementTypeComboBox.getValue().equals("Running Late"))
        {
            controller2.recieveData(runningLateTimeTextBox.getText(), runningLateCauseTextField.getText(), (String) addUpMessageComboBox.getValue());
        }
        else if (announcementTypeComboBox.getValue().equals("Alert"))
        {
            controller2.recieveData((String) pregeneratedAlertComboBox.getValue());
        }
        Stage stg2 = (Stage)((Node)event.getSource()).getScene().getWindow();
        stg2.setScene(scene2);
        stg2.show();
    }

    @FXML
    private void backButtonOnClicked(ActionEvent event) throws IOException 
    {
        //TrainOperator TO = new TrainOperator();
       // TO.loadDashBoard(event);
    }
    
}
