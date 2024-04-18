package view.nayem.passenger;

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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.nayem.Feedback;
import model.nayem.Passenger;

public class FeedbackSceneController implements Initializable {

    @FXML    private ComboBox reportTypeComboBox;
    @FXML    private TextField firstNameTextField;
    @FXML    private TextField lastNameTextField;
    @FXML    private TextField phoneNumberTextField;
    @FXML    private TextArea descriptionTextArea;
    Feedback feedback;
    Passenger passenger;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        reportTypeComboBox.getItems().addAll("Objection","Query","Advice");
    }    

    @FXML
    private void backButtonOnClicked(ActionEvent event) throws IOException 
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/nayem/passenger/PassengerDashBoard.fxml"));
        Parent parent = loader.load();
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene newScene = new Scene(parent);
        currentStage.setScene(newScene);
        currentStage.show();
    }

    @FXML
    private void submitButtonOnClicked(ActionEvent event) 
    {
        feedback = new Feedback(reportTypeComboBox.getValue().toString(),
                firstNameTextField.getText(),lastNameTextField.getText(),phoneNumberTextField.getText(),
                descriptionTextArea.getText());
        passenger = new Passenger();
        passenger.submitReport(feedback);
        
    }
    
}
