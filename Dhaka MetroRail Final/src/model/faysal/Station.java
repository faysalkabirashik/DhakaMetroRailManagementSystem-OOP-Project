/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.faysal;

import java.time.LocalDate;

/**
 *
 * @author Faysal Kabir Ashik
 */
public class Station {
    
    private String stationName; 
     private String stationID;
     private int stationSerial;
     private String stationType;
     private String category;
     private String cityName;
     private String description;  
     
     LocalDate configureDate;
     LocalDate openingDate;


    public Station(String stationName, String stationID, int stationSerial, String stationType, String category, String cityName, String description, LocalDate configureDate, LocalDate openingDate) {
        this.stationName = stationName;
        this.stationID = stationID;
        this.stationSerial = stationSerial;
        this.stationType = stationType;
        this.category = category;
        this.cityName = cityName;
        this.description = description;
        this.configureDate = configureDate;
        this.openingDate = openingDate;
    }

    public LocalDate getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(LocalDate openingDate) {
        this.openingDate = openingDate;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getStationID() {
        return stationID;
    }

    public void setStationID(String stationID) {
        this.stationID = stationID;
    }

    public int getStationSerial() {
        return stationSerial;
    }

    public void setStationSerial(int stationSerial) {
        this.stationSerial = stationSerial;
    }

    public String getStationType() {
        return stationType;
    }

    public void setStationType(String stationType) {
        this.stationType = stationType;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getConfigureDate() {
        return configureDate;
    }

    public void setConfigureDate(LocalDate configureDate) {
        this.configureDate = configureDate;
    }

    @Override
    public String toString() {
        return "Station{" + "stationName=" + stationName + ", stationID=" + stationID + ", stationSerial=" + stationSerial + ", stationType=" + stationType + ", category=" + category + ", cityName=" + cityName + ", description=" + description + ", configureDate=" + configureDate + ", openingDate=" + openingDate + ", openingDate=" + openingDate + '}';
    }
     
     
    
}
