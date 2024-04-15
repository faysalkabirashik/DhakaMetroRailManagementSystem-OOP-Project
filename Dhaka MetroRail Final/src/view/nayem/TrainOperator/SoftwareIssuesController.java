package view.nayem.TrainOperator;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.faysal.AlertGen;
import model.nayem.TrainOperator;
import model.nayem.SystemFeedback;

public class SoftwareIssuesController implements Initializable {

    @FXML    private TextField employeeIdTextField;
    @FXML    private TextArea descriptionTextArea;
    @FXML    private TextArea suggesionTextArea;
    @FXML    private DatePicker incidentDatePicker;
    TrainOperator to = new TrainOperator();
    SystemFeedback sf;

    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        // TODO
    }    

    @FXML
    private void backButtonOnClick(ActionEvent event) throws IOException 
    {
        to.loadDashBoard(event);
    }

    @FXML
    private void submitButtonOnClick(ActionEvent event) throws IOException 
    {
        String empId = employeeIdTextField.getText();
        LocalDate date = incidentDatePicker.getValue();
        String description =descriptionTextArea.getText() ;
        String suggestion = suggesionTextArea.getText();
        
        if (empId.isEmpty()||date==null||description.isEmpty()||suggestion.isEmpty())
        {
            AlertGen.errorAlert("Value Error", "Enter All The Field Values");
        }
        else
        {
            sf = new SystemFeedback(empId,date.toString(),descriptionTextArea.getText(),
        suggesionTextArea.getText());
        to.systemFeedback(sf);
        AlertGen.successfulAlert("Submitted Successfully");
        to.loadDashBoard(event);
        }
    }
    
}
