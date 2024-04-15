
package view.nayem.passenger;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class PurchaseTicketSceneController implements Initializable {

    @FXML    private TableView<?> availableTrainsTableView;
    @FXML    private TableColumn<?, ?> trainNumberTableColumn;
    @FXML    private TableColumn<?, ?> trainNameTableColumn;
    @FXML    private TableColumn<?, ?> departureTimeTableColumn;
    @FXML    private TableColumn<?, ?> availableTrainsTableColumn;
    @FXML    private TableColumn<?, ?> priceTableColumn;
    @FXML    private ComboBox<?> selectTrainComboBox;
    @FXML    private ComboBox<?> numberOfTicketsComboBox;
    @FXML    private ComboBox<?> fromStationComboBox;
    @FXML    private ComboBox<?> toStationComboBox;
    @FXML    private DatePicker dateOfJourneyDatePicker;
    @FXML    private Label totalAmountLabel;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void cancelButtonOnClicked(ActionEvent event) {
    }

    @FXML
    private void proceedToPayButtonOnClicked(ActionEvent event) {
    }

    @FXML
    private void searchButtonOnClicked(ActionEvent event) {
    }
    
}
