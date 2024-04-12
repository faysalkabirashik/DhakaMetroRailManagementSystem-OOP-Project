package view.nayem.passenger;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import model.nayem.Passenger;
import model.nayem.TransactionHistory;

public class RefundRequestSceneController implements Initializable {

    @FXML    private ComboBox actionTypeComboBox;
    @FXML    private TableView<TransactionHistory> transactionHistoryTableView; 
    @FXML    private TableColumn<TransactionHistory, String> dateTableColumn;
    @FXML    private TableColumn<TransactionHistory, String> typeTableColumn;
    @FXML    private TableColumn<TransactionHistory, String> amountTableColumn;
    @FXML    private TableColumn<TransactionHistory, String> transactionIdTableColumn;
    
    @FXML    private ComboBox selectTransactionIdComboBox;
    @FXML    private TextArea reasonTextArea;
    
    //Passenger passenger = new Passenger();

    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        actionTypeComboBox.getItems().addAll("Cancel","Refund");
        dateTableColumn.setCellValueFactory(new PropertyValueFactory<TransactionHistory,String>("Date"));
        typeTableColumn.setCellValueFactory(new PropertyValueFactory<TransactionHistory,String>("Type"));
        amountTableColumn.setCellValueFactory(new PropertyValueFactory<TransactionHistory,String>("Amount"));
        transactionIdTableColumn.setCellValueFactory(new PropertyValueFactory<TransactionHistory,String>("TransactionId"));
    }    

    @FXML
    private void cancelButtonOnClick(ActionEvent event) throws IOException 
    {
        //passenger.loadDashBoard(event);
    }

    @FXML
    private void submitButtonOnClick(ActionEvent event) 
    {
        //
    }   
}