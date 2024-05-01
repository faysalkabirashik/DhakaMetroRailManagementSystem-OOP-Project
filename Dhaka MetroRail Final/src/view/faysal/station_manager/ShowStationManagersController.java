/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import model.faysal.AlertGen;
import model.faysal.users.StationManager;

/**
 * FXML Controller class
 *
 * @author Guest user
 */
public class ShowStationManagersController implements Initializable {

    @FXML
    private TableView<StationManager> tableView;
    @FXML
    private TableColumn<StationManager, String> userIdentity_TC;
    @FXML
    private TableColumn<StationManager, String> fullName_TC;
    @FXML
    private TableColumn<StationManager, Integer> empManaged_TC;
    @FXML
    private RadioButton male_radio;
    @FXML
    private ToggleGroup gender_toggle;
    @FXML
    private RadioButton female_radio;
    

    @FXML
    private TableColumn<StationManager, String> gender_TC;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        userIdentity_TC.setCellValueFactory(new PropertyValueFactory<StationManager, String>("userIdentity"));
        fullName_TC.setCellValueFactory(new PropertyValueFactory<StationManager, String>("fullName"));
        empManaged_TC.setCellValueFactory(new PropertyValueFactory<StationManager, Integer>("noOfEmpManaged"));
        gender_TC.setCellValueFactory(new PropertyValueFactory<StationManager, String>("gender"));
 
    }    

    @FXML
    private void loadOnAction(ActionEvent event) {
      ObservableList <StationManager> list = FXCollections.observableArrayList();
      ObservableList <StationManager> listMale = FXCollections.observableArrayList();
      ObservableList <StationManager> listFemale = FXCollections.observableArrayList();
      
        list = new StationManager().getTotalListOfObjects();
        //System.out.println(list);
        
        if (list.isEmpty()){
            System.out.println("'Empyt r");
            AlertGen.inforamtion("EMpty", "There are no station Managers");
            return;
        }
        
        for (StationManager sm1: list){
            if ( sm1.getGender().equals("Male") ) {
                System.out.println("eta male");
                listMale.add(sm1);
                
               //tableView.setItems( listMale);
           } else if (sm1.getGender().equals("Female") ) {
                System.out.println("object ta female");
                listFemale.add(sm1);
                //tableView.setItems( listFemale);
           }
        }
        System.out.println(listMale);
        System.out.println(listFemale);
        
        // this can show all even without selection
        if (!male_radio.isSelected() && !female_radio.isSelected() ){
            tableView.setItems( list);
            // this will only give selected male
        } else if (male_radio.isSelected()   ) {
            tableView.setItems( listMale);
            
        } else if (female_radio.isSelected() ) {
            tableView.setItems( listFemale);
        }
        

        
    }
    
}



/*

        System.out.println("kaj kore");
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        
        try {
            StationManager sm;
            f = new File("StationManager.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            System.out.println("kaj kore");
             
            while(true){
                System.out.println("kaj kore while er vitor");
                sm = (StationManager) ois.readObject();
                System.out.println(sm.toString());
                System.out.println("While e dhukse");
                list.add(sm);
                if (sm.getGender().equals("Male")){
                    listMale.add(sm);
                    System.out.println("male e ");
                } else if (sm.getGender().equals("Female")){
                    System.out.println("female e");
                    listFemale.add(sm);
                }
            }
        }
        catch(RuntimeException e){
            e.printStackTrace();
        }
        catch (Exception ex) {
            try {
                if(ois!=null)
                    ois.close();
            } catch (IOException ex1) {  }           
        }


*/