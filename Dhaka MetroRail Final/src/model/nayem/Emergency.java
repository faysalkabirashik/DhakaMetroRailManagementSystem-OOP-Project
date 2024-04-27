package model.nayem;

import java.io.Serializable;

public class Emergency implements Serializable
{
    String trainNumber;
    String nextStation;
    String emergencyType;
    String message;

    public Emergency(String trainNumber, String nextStation, String emergencyType, String message) {
        this.trainNumber = trainNumber;
        this.nextStation = nextStation;
        this.emergencyType = emergencyType;
        this.message = message;
    }

    @Override
    public String toString() {
        return "Emergency{" + "trainNumber=" + trainNumber + ", nextStation=" + nextStation + ", emergencyType=" + emergencyType + ", message=" + message + '}';
    }

    
}
