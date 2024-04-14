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
import javafx.stage.Stage;

public class TrainOperatorDashboradController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void makeAnnouncementButtonOnClicked(ActionEvent event) throws IOException 
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/nayem/TrainOperator/MakeAnnouncement.fxml"));
            Parent parent = loader.load();
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene newScene = new Scene(parent);
            currentStage.setScene(newScene);
            currentStage.show();
    }

    @FXML
    private void messageStationManagerButtonOnClicked(ActionEvent event) throws IOException 
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/nayem/TrainOperator/MessageToStationManager.fxml"));
            Parent parent = loader.load();
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene newScene = new Scene(parent);
            currentStage.setScene(newScene);
            currentStage.show();
    }

    @FXML
    private void messageMaintananceStaffButtonOnClicked(ActionEvent event) throws IOException 
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/nayem/TrainOperator/MessageToMaintenanceCrew.fxml"));
            Parent parent = loader.load();
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene newScene = new Scene(parent);
            currentStage.setScene(newScene);
            currentStage.show();
    }

    @FXML
    private void viewMaintanaceScheduleButtonOnClicked(ActionEvent event) {
    }

    @FXML
    private void notifcationButtonOnClicked(ActionEvent event) {
    }

    @FXML
    private void softwareIssuesButtonOnClicked(ActionEvent event) throws IOException 
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/nayem/TrainOperator/SoftwareIssues.fxml"));
            Parent parent = loader.load();
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene newScene = new Scene(parent);
            currentStage.setScene(newScene);
            currentStage.show();
    }

    @FXML
    private void realTimeUpdateButtonOnClicked(ActionEvent event) throws IOException 
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/nayem/TrainOperator/RealTimeUpdateScene.fxml"));
            Parent parent = loader.load();
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene newScene = new Scene(parent);
            currentStage.setScene(newScene);
            currentStage.show();
    }

    @FXML
    private void emergencyButtonOnClicked(ActionEvent event) {
    }

    @FXML
    private void routeInformationButtonOnCliked(ActionEvent event) {
    }

    @FXML
    private void signOutButtonOnClicked(ActionEvent event) throws IOException 
    {

    }
    
}
