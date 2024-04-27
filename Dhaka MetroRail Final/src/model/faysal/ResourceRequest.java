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
<<<<<<< HEAD
    private String stationName;
  
 
=======
    private String requestedResource;
    private List<String> requestedResourceList;
    
    private String status;
>>>>>>> Jubair-2221134
    private String description;

    public ResourceRequest(String requestID, String stationName, String description) {
        this.requestID = requestID;
<<<<<<< HEAD
        this.stationName = stationName;
=======
        this.requestedResource = requestedResource;
        this.status = status;
        this.description = description;
    }

    public ResourceRequest(String requestID, List<String> requestedResourceList, String status, String description) {
        this.requestID = requestID;
        this.requestedResourceList = requestedResourceList;
        this.status = status;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
>>>>>>> Jubair-2221134
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

<<<<<<< HEAD
    public String getDescription() {
        return description;
=======
    public List<String> getRequestedResourceList() {
        return requestedResourceList;
    }

    public void setRequestedResourceList(List<String> requestedResourceList) {
        this.requestedResourceList = requestedResourceList;
    }

    public String getStatus() {
        return status;
>>>>>>> Jubair-2221134
    }

    public void setDescription(String description) {
        this.description = description;
    }

<<<<<<< HEAD
   
=======
    @Override
    public String toString() {
        return "ResourceRequest{" + "requestID=" + requestID + ", requestedResource=" + requestedResource + ", requestedResourceList=" + requestedResourceList + ", status=" + status + ", description=" + description + '}';
    }


    
>>>>>>> Jubair-2221134
    
    
    
}
