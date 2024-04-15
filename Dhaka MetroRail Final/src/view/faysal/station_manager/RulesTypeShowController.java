/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.faysal.station_manager;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import model.faysal.Rules;
import model.faysal.Total;

/**
 * FXML Controller class
 *
 * @author Ishti
 */

public class RulesTypeShowController implements Initializable {

    @FXML private ComboBox<String> RulesTypeComboBox;
    @FXML private TableView<Total> totalCountTableView;
    @FXML private TableColumn<Total, String> rulesTypeTableColumn;
    @FXML private TableColumn<Total, Integer> totalRulesTableColumn;
    ObservableList<Total>totalTypesList=FXCollections.observableArrayList(); 
    ObservableList<Total>totalTypesList2=FXCollections.observableArrayList(); 
    ObservableList<Total>totalTypesList3=FXCollections.observableArrayList(); 
    int type1=0,type2=0,type3=0;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        RulesTypeComboBox.getItems().addAll("Type1","Type2","Type3");
        totalRulesTableColumn.setCellValueFactory(new PropertyValueFactory<Total,Integer>("no"));
        rulesTypeTableColumn.setCellValueFactory(new PropertyValueFactory<Total,String>("type"));
        //===============
        
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
                    if(emp.getRulesType().equals("Type1"))
                    {
                        type1++;
                    }
                    else if(emp.getRulesType().equals("Type2"))
                    {
                        type2++;
                    }
                    else if(emp.getRulesType().equals("Type3"))
                    {
                        type3++;
                    }
                }
            }//end of nested try
            catch(Exception e){
                //
            }//nested catch     
              
        } catch (IOException ex) { } 
        finally {
            try {
                if(ois != null) ois.close();
            } catch (IOException ex) { }
        }  
        
        //============================
        
        totalTypesList.add(new Total(type1,"Type1"));
        totalTypesList2.add(new Total(type2,"Type2"));
        totalTypesList3.add(new Total(type3,"Type3"));
    }    

    @FXML
    private void loadTableButtonOnClick(MouseEvent event) {
        if(RulesTypeComboBox.getValue().toString().equals("Type1"))
            totalCountTableView.setItems(totalTypesList);
        else if(RulesTypeComboBox.getValue().toString().equals("Type2"))
            totalCountTableView.setItems(totalTypesList2);
        else if(RulesTypeComboBox.getValue().toString().equals("Type3"))
            totalCountTableView.setItems(totalTypesList3);
    }
    
}
