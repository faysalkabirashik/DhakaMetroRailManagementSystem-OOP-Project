 
package view.faysal.station_manager;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ishti
 */
public class HeadOfSecurityController implements Initializable {

    @FXML
    private BorderPane borderPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loadUI("welcome");
    }    
    private void loadUI(String ui) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource(ui+".fxml"));
            borderPane.setCenter(root);
        }
        catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    @FXML private void rulesAndRegulationButtonOnClick(MouseEvent event) {
        loadUI("HUI1");
    }

    @FXML private void recruitSecurityOnclick(MouseEvent event) {
        loadUI("HUI2");
    }

    @FXML private void policeManagementOnClick(MouseEvent event) {
        loadUI("HUI3");
    }

    @FXML private void verifyingVisitorsOnClick(MouseEvent event) {
        loadUI("HUI4");
    }

    @FXML private void lostAndfoundOnCLick(MouseEvent event) {
        loadUI("HUI5");
    }

    @FXML private void emergencySituationHandlingOnClick(MouseEvent event) {
        loadUI("HUI6");
    }

    @FXML private void planningStrategyOnClick(MouseEvent event) {
        loadUI("HUI7");
    }

    @FXML private void monitoringAndSurveillanceOnClick(MouseEvent event) {
        loadUI("HUI8");
    }

    @FXML private void exitOnClick(MouseEvent event) throws IOException {
        
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    }
    
}
