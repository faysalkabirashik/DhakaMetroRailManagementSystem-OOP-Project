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
    private String requestedResource;
    private List<String> requestedResourceList;
    
    private String status;
    private String description;

    public ResourceRequest(String requestID, String requestedResource, String status, String description) {
        this.requestID = requestID;
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
        this.description = description;
    }

    public String getRequestID() {
        return requestID;
    }

    public void setRequestID(String requestID) {
        this.requestID = requestID;
    }

    public String getRequestedResource() {
        return requestedResource;
    }

    public void setRequestedResource(String requestedResource) {
        this.requestedResource = requestedResource;
    }

    public List<String> getRequestedResourceList() {
        return requestedResourceList;
    }

    public void setRequestedResourceList(List<String> requestedResourceList) {
        this.requestedResourceList = requestedResourceList;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ResourceRequest{" + "requestID=" + requestID + ", requestedResource=" + requestedResource + ", requestedResourceList=" + requestedResourceList + ", status=" + status + ", description=" + description + '}';
    }


    
    
    
    
}
