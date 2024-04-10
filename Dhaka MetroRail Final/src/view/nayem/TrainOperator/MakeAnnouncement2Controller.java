package view.nayem.TrainOperator;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import model.nayem.TrainOperator;

public class MakeAnnouncement2Controller implements Initializable {

    @FXML
    private Label label;
    public void recieveData(String destination, String nextStation)
    {
        label.setText("Our destination is " + destination + ". We are approaching to "+nextStation+ ". Thank you.");
    }
    public void recieveData(String lateTime, String cause, String message)
    {
        label.setText("We are sorry to inform that "+cause+" took place. We will be late for "+lateTime+message);
    }
    public void recieveData(String alert)
    {
        label.setText(alert);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void backButtonOnClick(ActionEvent event) throws IOException 
    {
        TrainOperator TO = new TrainOperator();
        TO.loadDashBoard(event);
    }
    
}
