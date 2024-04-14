/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.faysal;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Faysal Kabir Ashik
 */
public class TrainSchedule  implements Serializable {
    
     
    private Train train;
    private Station station;
    
    private String arrivalTieme;
    private double stayTime;

    public TrainSchedule(Train train, Station station, String arrivalTieme, double stayTime) {
        this.train = train;
        this.station = station;
        this.arrivalTieme = arrivalTieme;
        this.stayTime = stayTime;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public String getArrivalTieme() {
        return arrivalTieme;
    }

    public void setArrivalTieme(String arrivalTieme) {
        this.arrivalTieme = arrivalTieme;
    }

    public double getStayTime() {
        return stayTime;
    }

    public void setStayTime(double stayTime) {
        this.stayTime = stayTime;
    }

 
 

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TrainSchedule{");
        sb.append("train=").append(train);
        sb.append(", station=").append(station);
        sb.append(", arrivalTieme=").append(arrivalTieme);
        sb.append(", stayTime=").append(stayTime);
  
        sb.append('}');
        return sb.toString();
    }
    
    
}
