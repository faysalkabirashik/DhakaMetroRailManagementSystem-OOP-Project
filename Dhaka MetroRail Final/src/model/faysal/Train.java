/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.faysal;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.faysal.users.SystemAdministrator;

/**
 *
 * @author Faysal Kabir Ashik
 */
public class Train  implements Serializable {

    private String  trainId;
    private String trainName;
    private String startingStation ;
    private String destinationStation;
    String routeID; 
    private int totalBogie ;
    private int bogieCapacity; 
    private int totalCapacity ;
    private LocalDate openingdate;
    String description; 
    
    List<Trip> tripList;

    public Train() {
    }
    
    

    public Train(String trainId, String trainName, String startingStation, String destinationStation, String routeID, int totalBogie, int bogieCapacity, LocalDate openingdate, String description) {
        this.trainId = trainId;
        this.trainName = trainName;
        this.startingStation = startingStation;
        this.destinationStation = destinationStation;
        this.routeID = routeID;
        this.totalBogie = totalBogie;
        this.bogieCapacity = bogieCapacity;
        this.openingdate = openingdate;
        this.description = description;
    }



    public String getStartingStation() {
        return startingStation;
    }

    public void setStartingStation(String startingStation) {
        this.startingStation = startingStation;
    }

    public String getDestinationStation() {
        return destinationStation;
    }

    public void setDestinationStation(String destinationStation) {
        this.destinationStation = destinationStation;
    }


    
    public LocalDate getOpeningdate() {
        return openingdate;
    }

    public void setOpeningdate(LocalDate openingdate) {
        this.openingdate = openingdate;
    }
    
    

    public String getTrainId() {
        return trainId;
    }

    public void setTrainId(String trainId) {
        this.trainId = trainId;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

 

    public int getTotalBogie() {
        return totalBogie;
    }

    public void setTotalBogie(int totalBogie) {
        this.totalBogie = totalBogie;
    }

    public int getBogieCapacity() {
        return bogieCapacity;
    }

    public void setBogieCapacity(int bogieCapacity) {
        this.bogieCapacity = bogieCapacity;
    }

    public int getTotalCapacity() {
        return totalCapacity;
    }

    public void setTotalCapacity(int totalCapacity) {
        this.totalCapacity = totalCapacity;
    }

    public String getRouteID() {
        return routeID;
    }

    public void setRouteID(String routeID) {
        this.routeID = routeID;
    }






    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Trip> getTripList() {
        return tripList;
    }

    public void setTripList(List<Trip> tripList) {
        this.tripList = tripList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Train{");
        sb.append("trainId=").append(trainId);
        sb.append(", trainName=").append(trainName);
        sb.append(", startingStation=").append(startingStation);
        sb.append(", destinationStation=").append(destinationStation);
        sb.append(", totalBogie=").append(totalBogie);
        sb.append(", bogieCapacity=").append(bogieCapacity);
        sb.append(", totalCapacity=").append(totalCapacity);
        sb.append(", route=").append(routeID);
        sb.append(", tripList=").append(tripList);
        sb.append(", description=").append(description);
        sb.append('}');
        return sb.toString();
    }


   //////////////////////// Add train to bin //////////////////
    

}
