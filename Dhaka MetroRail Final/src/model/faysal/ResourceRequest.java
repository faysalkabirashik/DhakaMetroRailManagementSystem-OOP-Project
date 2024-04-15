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
public class ResourceRequest  implements Serializable {
    
    private String requestID;
    private String stationName;
  
 
    private String description;

    public ResourceRequest(String requestID, String stationName, String description) {
        this.requestID = requestID;
        this.stationName = stationName;
        this.description = description;
    }

    public String getRequestID() {
        return requestID;
    }

    public void setRequestID(String requestID) {
        this.requestID = requestID;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

   
    
    
    
}
