package model.nayem;

import java.io.Serializable;

public class LostAndFound implements Serializable
{
    public String reportType;
    public String firstName;
    public String lastName;
    public String phoneNumber;
    public String itemName;
    public String itemType;
    public String description;

    public LostAndFound(String reportType, String firstName, String lastName, String phoneNumber, String itemName, String itemType, String description) {
        this.reportType = reportType;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.itemName = itemName;
        this.itemType = itemType;
        this.description = description;
    }

    

    @Override
    public String toString() {
        return "LostAndFound{" + "reportType=" + reportType + ", firstName=" + firstName + ", lastName=" + lastName + ", itemName=" + itemName + ", itemType=" + itemType + ", description=" + description + '}';
    }
    
    
     
}
