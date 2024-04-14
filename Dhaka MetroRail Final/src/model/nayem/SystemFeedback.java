package model.nayem;

import java.io.Serializable;

public class SystemFeedback implements Serializable
{
    String employeeId;
    String dateOfIncident;
    String description;
    String suggestion;

    public SystemFeedback(String employeeId, String dateOfIncident, String description, String suggestion) {
        this.employeeId = employeeId;
        this.dateOfIncident = dateOfIncident;
        this.description = description;
        this.suggestion = suggestion;
    }

    @Override
    public String toString() {
        return "SystemFeedback{" + "employeeId=" + employeeId + ", dateOfIncident=" + dateOfIncident + ", description=" + description + ", suggestion=" + suggestion + '}';
    }
    
    
}
