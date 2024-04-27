
package view.nayem.passenger;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import model.faysal.AlertGen;
import model.nayem.Passenger;
import model.nayem.TransactionHistory;
import model.nayem.TransactionId;

public class PurchaseTicketSceneController implements Initializable {

    @FXML    private ComboBox<String> numberOfTicketsComboBox;
    @FXML    private ComboBox<String> fromStationComboBox;
    @FXML    private ComboBox<String> toStationComboBox;
    @FXML    private DatePicker dateOfJourneyDatePicker;
    @FXML    private Label totalAmountLabel;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        numberOfTicketsComboBox.getItems().addAll("1","2","3","4");
        fromStationComboBox.getItems().addAll("Uttara","Mirpur","Farmgate","DU","Tejgaon");
        toStationComboBox.getItems().addAll("Mirpur","Farmgate","DU","Tejgaon");
    }    

    @FXML
    private void cancelButtonOnClicked(ActionEvent event) throws IOException 
    {
        Passenger pas = new Passenger();
        pas.loadDashBoard(event);
    }

    @FXML
    private void proceedToPayButtonOnClicked(ActionEvent event) 
    {
        if (numberOfTicketsComboBox.getValue().isEmpty()&&fromStationComboBox.getValue().isEmpty()&&toStationComboBox.getItems().isEmpty()&&
                dateOfJourneyDatePicker.getValue()==null)
        {
            AlertGen.errorAlert("Value Error", "Please Enter All Field Values");
        }
        else{
            TransactionId transactionId = new TransactionId();
            String id = transactionId.getTransactionId();
            TransactionHistory th = new TransactionHistory(id,"Purchase Ticket",totalAmountLabel.getText());
            
            File f = null;
            FileOutputStream fos = null;      
            ObjectOutputStream oos = null;        
            try {
                f = new File("TransactionHistory.bin");
                if(f.exists()){
                    fos = new FileOutputStream(f,true);
                    oos = new model.faysal.AppendableObjectOutputStream(fos);                
                }
                else{
                    fos = new FileOutputStream(f);
                    oos = new ObjectOutputStream(fos);               
                }
                oos.writeObject(th);

            } catch (IOException ex) {
                //
            }
        }
    }

    @FXML
    private void numOfTicketOnAction(ActionEvent event) 
    {
        int total = 50 * Integer.parseInt(numberOfTicketsComboBox.getValue());
        totalAmountLabel.setText(Integer.toString(total));
    }
    
}
