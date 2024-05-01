/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package charttest;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Guest user
 */
public class ChartController implements Initializable {

    @FXML
    private PieChart pieChart;
    @FXML
    private Label showLabel;
    
    private ObservableList <PieChart.Data> list 
            = FXCollections.observableArrayList();
   
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         //comBox.getItems().add("Option");
         //comBox.getItems().clear();
        
        list.add(new PieChart.Data("the ditcher", 32));
        list.add(new PieChart.Data("ultimate ditcher", 323));
        list.add(new PieChart.Data("Extreme Ditcher", 87));
        list.add(new PieChart.Data("Java", 322));
         
        
        
    }    

    @FXML
    private void laodOnAction(ActionEvent event) {
        
  
        pieChart.setData(list);
        
        
        
        for(PieChart.Data data: pieChart.getData()){
            data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, 
                new EventHandler<MouseEvent>(){
                    @Override
                    public void handle(MouseEvent event) {
                        showLabel.setText(String.valueOf("Total no of users: " + data.getPieValue()));
                        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                }
            );
            
        }
    }
    
}
