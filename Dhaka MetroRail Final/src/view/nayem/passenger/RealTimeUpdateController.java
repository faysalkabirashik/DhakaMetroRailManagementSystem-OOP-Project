package view.nayem.passenger;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.nayem.Update;

public class RealTimeUpdateController implements Initializable {

    @FXML    private TextField trainId;
    @FXML    private TableView<Update> realTimeTableVIew;
    @FXML    private TableColumn<Update, String> timeTableColumn;
    @FXML    private TableColumn<Update, String> updateTimeTableColumn;
    @FXML    private TableColumn<Update, String> updateTableColumn;

    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        timeTableColumn.setCellValueFactory(new PropertyValueFactory<Update,String>("time"));
        updateTimeTableColumn.setCellValueFactory(new PropertyValueFactory<Update,String>("updateType"));
        updateTableColumn.setCellValueFactory(new PropertyValueFactory<Update,String>("update"));
    }    

    @FXML
    private void searhButtonOnClick(ActionEvent event) throws IOException 
    {
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        String train;
        try {
            f = new File("RealTimeUpdate.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            Update update;
            realTimeTableVIew.getItems().clear();
            try{
                while(true){
                    System.out.println("Printing objects.");
                    update = (Update)ois.readObject();  // emp.
                    System.out.println(update);
                    train = update.getTrainId();
                    if (train.equals(trainId.getText()))
                    {
                        realTimeTableVIew.getItems().add(update);
                    }
                }
            }
            catch(Exception e){
                System.out.println("Hoy nai");
            }//nested catch              
        } catch (IOException ex) {
            System.out.println("Hoy nai 2");
        } 
        finally {
            try {
                if(ois != null) ois.close();
            } catch (IOException ex) { }
        }
    }

    @FXML
    private void backButtononClick(ActionEvent event) {
    }
    
}
