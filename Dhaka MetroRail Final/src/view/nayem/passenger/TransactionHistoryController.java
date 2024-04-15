package view.nayem.passenger;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.nayem.Passenger;
import model.nayem.TransactionHistory;

public class TransactionHistoryController implements Initializable {

    @FXML    private TableView<TransactionHistory> transactionHistoryTableView;
    @FXML    private TableColumn<TransactionHistory, String> transactionTypeTableColumn;
    @FXML    private TableColumn<TransactionHistory, String> transactionIdTableColumn;
    @FXML    private TableColumn<TransactionHistory, String> amountTableColumn;

    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        transactionTypeTableColumn.setCellValueFactory(new PropertyValueFactory<TransactionHistory,String>("transType"));
        transactionIdTableColumn.setCellValueFactory(new PropertyValueFactory<TransactionHistory,String>("transID"));
        amountTableColumn.setCellValueFactory(new PropertyValueFactory<TransactionHistory,String>("amount"));
        
        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        String train;
        try {
            f = new File("TransactionHistory.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            TransactionHistory th;
            transactionHistoryTableView.getItems().clear();
            try{
                while(true){
                    th = (TransactionHistory)ois.readObject();
                    transactionHistoryTableView.getItems().add(th);
                }
            }
            catch(Exception e){
                
            }//nested catch              
        } catch (IOException ex) {
            
        } 
        finally {
            try {
                if(ois != null) ois.close();
            } catch (IOException ex) { }
        }
    }    


    @FXML
    private void backButtonOnClicked(ActionEvent event) throws IOException 
    {
        Passenger pas = new Passenger();
        pas.loadDashBoard(event);
    }
    
}
