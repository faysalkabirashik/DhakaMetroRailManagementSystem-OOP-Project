/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.faysal;

import java.util.List;

/**
 *
 * @author Faysal Kabir Ashik
 */
public class Train {

    private String  trainId;
    private String trainName;
    private Station startingStation ;
    private Station destinationStation;  
    private int totalBogie ;
    private int bogieCapacity; 
    private int totalCapacity ;
    Route route; 
    List<Trip> tripList;
    
    String description; 

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

    public Station getStartingStation() {
        return startingStation;
    }

    public void setStartingStation(Station startingStation) {
        this.startingStation = startingStation;
    }

    public Station getDestinationStation() {
        return destinationStation;
    }

    public void setDestinationStation(Station destinationStation) {
        this.destinationStation = destinationStation;
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

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
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
        sb.append(", route=").append(route);
        sb.append(", tripList=").append(tripList);
        sb.append(", description=").append(description);
        sb.append('}');
        return sb.toString();
    }


   


    
    
    
    
    
}
