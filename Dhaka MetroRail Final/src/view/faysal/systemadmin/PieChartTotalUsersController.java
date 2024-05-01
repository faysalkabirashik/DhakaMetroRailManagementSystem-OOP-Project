/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package view.faysal.systemadmin;

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
import model.faysal.users.Accountant;
import model.faysal.users.HeadOfHR;
import model.faysal.users.MaintenanceStaff;
import model.faysal.users.PublicServiceProvider;
import model.faysal.users.StationManager;
import model.faysal.users.SystemAdministrator;
import model.nayem.Passenger;
import model.nayem.TrainOperator;

/**
 * FXML Controller class
 *
 * @author Faysal Kabir Ashik
 */
public class PieChartTotalUsersController implements Initializable {

    @FXML
    private PieChart pieChart;

    /**
     * Initializes the controller class.
     */
    
    private ObservableList <PieChart.Data> list 
            = FXCollections.observableArrayList();
    @FXML
    private Label showLabel;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void loadPieChartButtonOnClick(ActionEvent event) {
        pieChart.getData().clear();
//        SystemAdministrator.getCountOfSystemAdmins();
        showLabel.setText("Select node to total no. of users.");
//        SystemAdministrator admin = new SystemAdministrator();
        list.add( new PieChart.Data("System Administrator",  new SystemAdministrator().getTotalNoOfObjects()) );
        list.add( new PieChart.Data("Passenger",new Passenger().getTotalNoOfObjects()) );
        list.add( new PieChart.Data("Train Operator",new TrainOperator().getTotalNoOfObjects()) );
        list.add( new PieChart.Data("Station Manager",new StationManager().getTotalNoOfObjects()) );
        list.add( new PieChart.Data("Head of HR",new HeadOfHR().getTotalNoOfObjects()) );
        list.add( new PieChart.Data("Maintenance Staff",new MaintenanceStaff().getTotalNoOfObjects()) );
        list.add( new PieChart.Data("Accountant",new Accountant().getTotalNoOfObjects()) );
        list.add( new PieChart.Data("Public Service Provider",new PublicServiceProvider().getTotalNoOfObjects()) );
        
        
//        list.add( new PieChart.Data("Head of HR",new HeadOfHR().getTotalNoOfObjects()) );
        //ObservableList <PieChart.Data> list2 = FXCollections.observableArrayList();
        //list2.add(new PieChart.Data("Java",50));
        //...
        //pieChart.setData(list);
        
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
