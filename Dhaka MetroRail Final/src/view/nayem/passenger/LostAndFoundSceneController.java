package view.nayem.passenger;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.nayem.LostAndFound;
import model.nayem.Passenger;

public class LostAndFoundSceneController implements Initializable {

    @FXML    private TextField firstNameTextField;
    @FXML    private TextField lastNameTextField;
    @FXML    private ComboBox reportTypeComboBox;
    @FXML    private TextField phoneTextField;
    @FXML    private TextField itemNameTextField;
    @FXML    private TextField itemTypeTextField;
    @FXML    private TextArea descriptionTextArea;
    Passenger passenger = new Passenger();
    LostAndFound lf;

    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        reportTypeComboBox.getItems().addAll("Lost","Found");
    }    

    @FXML
    private void cancelButtonOnClicked(ActionEvent event) throws IOException 
    {
        passenger.loadDashBoard(event);
    }

    @FXML
    private void submitButtonOnClicked(ActionEvent event) 
    {
        lf = new LostAndFound(reportTypeComboBox.getValue().toString(),firstNameTextField.getText(),lastNameTextField.getText(),phoneTextField.getText(),
        itemNameTextField.getText(),itemTypeTextField.getText(),descriptionTextArea.getText());
        passenger.reportLostAndFound(lf);
        
    }
    
}
