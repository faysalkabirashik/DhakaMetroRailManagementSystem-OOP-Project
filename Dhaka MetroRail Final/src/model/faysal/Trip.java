/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.faysal;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 *
 * @author Faysal Kabir Ashik
 */
public class Trip  implements Serializable {
    
    private String tripId;
    private Route route;
    private Train train;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    
    private List<TrainSchedule> schedule;

    public String getTripId() {
        return tripId;
    }

    public void setTripId(String tripId) {
        this.tripId = tripId;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public Trip(String tripId, Route route, Train train, LocalDate date, LocalTime startTime, LocalTime endTime) {
        this.tripId = tripId;
        this.route = route;
        this.train = train;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Trip{");
        sb.append("tripId=").append(tripId);
        sb.append(", route=").append(route);
        sb.append(", train=").append(train);
        sb.append(", date=").append(date);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append('}');
        return sb.toString();
    }

    public List<TrainSchedule> getSchedule() {
        return schedule;
    }

    public void setSchedule(List<TrainSchedule> schedule) {
        this.schedule = schedule;
    }

    
    
    
    
}
