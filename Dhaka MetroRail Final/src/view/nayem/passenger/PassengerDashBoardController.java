
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
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class PassengerDashBoardController implements Initializable {

    @FXML
    private Label welcomeTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void purchaseButtonOnClicked(ActionEvent event) {
    }

    @FXML
    private void viewTrainsButtonOnClicked(ActionEvent event) {
    }

    @FXML
    private void transactionHistoryButtonOnClicked(ActionEvent event) {
    }

    @FXML
    private void managePassButtonOnClicked(ActionEvent event) {
    }

    @FXML
    private void viewBalanceButtonOnClicked(ActionEvent event) {
    }

    @FXML
    private void refundOrCancelButtonOnClicked(ActionEvent event) {
    }

    @FXML
    private void lostAndFoundButtonOnClicked(ActionEvent event) throws IOException 
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/nayem/passenger/LostAndFoundScene.fxml"));
        Parent parent = loader.load();
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene newScene = new Scene(parent);
        currentStage.setScene(newScene);
        currentStage.show();
    }

    @FXML
    private void feedbackButtonOnClicked(ActionEvent event) throws IOException 
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/nayem/passenger/FeedbackScene.fxml"));
        Parent parent = loader.load();
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene newScene = new Scene(parent);
        currentStage.setScene(newScene);
        currentStage.show();
    }

    @FXML
    private void signOutButtonOnClicked(ActionEvent event) {
    }
    
}
