package model.nayem;

import java.io.Serializable;

public class Feedback implements Serializable
{
    public String reportType;
    public String firstName;
    public String lastName;
    public String phoneNumber;
    public String description;

    public Feedback(String reportType, String firstName, String lastName, String phoneNumber, String description) {
        this.reportType = reportType;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Feedback{" + "reportType=" + reportType + ", firstName=" + firstName + ", lastName=" + lastName + ", phoneNumber=" + phoneNumber + ", description=" + description + '}';
    }
    
    
}
