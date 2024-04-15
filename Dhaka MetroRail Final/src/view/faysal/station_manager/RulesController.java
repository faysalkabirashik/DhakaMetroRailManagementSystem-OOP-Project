
package view.faysal.station_manager;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.faysal.AppendableObjectOutputStream;
import model.faysal.Rules;

/**
 * FXML Controller class
 *
 * @author Ishti
 */

public class RulesController implements Initializable {
    
    
    //===All initializeer=====//
    @FXML private TableView<Rules> rulesTableView;
    @FXML private TextField addNewRulesTextField;
    @FXML private TextField changeRulesNoTextField;
    @FXML private TextField changeRulesTextField;    
    @FXML private TableColumn<Rules,Integer> noColumn;
    @FXML private TableColumn<Rules,String> rulesColumn;
    public ArrayList<Rules>rulesList;
    private int count=1;
    ObservableList<Rules> createRules=FXCollections.observableArrayList(); 
    @FXML private TableColumn<Rules, LocalDate> dateCoulm;
    @FXML private TableColumn<Rules, String> rulesTypeColumn;
    @FXML private ComboBox<String> rulesTypeComboBox;
    @FXML private DatePicker issuedDate;
    int type1=0,type2=0,type3=0;
        
    /**
     * 
     * Initializes the controller class.
     * 
    **/
    
   
    
    
    //===========initialize method==============/
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
      noColumn.setCellValueFactory(new PropertyValueFactory<Rules,Integer>("no"));
      rulesColumn.setCellValueFactory(new PropertyValueFactory<Rules,String>("rulesName"));
      dateCoulm.setCellValueFactory(new PropertyValueFactory<Rules,LocalDate>("dateIssue"));
      rulesTypeColumn.setCellValueFactory(new PropertyValueFactory<Rules,String>("rulesType"));
      rulesTypeComboBox.getItems().addAll("Type1","Type2","Type3");
    }    
    
    
    //======button on click method starts here==========/
    
    @FXML private void loadRulesMouseOnClick(MouseEvent event) {
        
        rulesTableView.getItems().clear();
        
        
        //======bin file reading========/
        
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        
        try {
            f = new File("rules.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            Rules emp=new Rules();
            try{
                while(true){
                    emp = (Rules)ois.readObject();
                    createRules.add(emp);
                }
            }//end of nested try
            catch(Exception e){
                //
            }//nested catch     
            count=emp.getNo()+1;   
        } catch (IOException ex) { } 
        finally {
            try {
                if(ois != null) ois.close();
            } catch (IOException ex) { }
        }       
        //=============bin file reading end==============   
        rulesTableView.setItems(createRules);
    }

    @FXML private void createRulesButtonOnClick(MouseEvent event) {
        
      
         //======create objects ==========//
        
        
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            f = new File("rules.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            Rules e = new Rules(
                count,
                addNewRulesTextField.getText(),
                issuedDate.getValue(),
                rulesTypeComboBox.getValue()
            
            );
            oos.writeObject(e);
            count++;
            

        } catch (IOException ex) {
            Logger.getLogger(RulesController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(RulesController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    
    }

    @FXML private void changeRulesButtonOnClick(MouseEvent event) {
        
        
        
       
    }

    @FXML
    private void showRulesButtonOnClick(MouseEvent event) throws IOException {
        
        Parent fileChooserViewParent = FXMLLoader.load(getClass().getResource("rulesTypeShow.fxml"));
        Scene fileChooserViewScene = new Scene(fileChooserViewParent);
        Stage newWindow  = new Stage();
        newWindow.setResizable(false);
       // newWindow.setTitle("Add Staff Stage");
        newWindow.setScene(fileChooserViewScene);
        newWindow.show();
    }
}