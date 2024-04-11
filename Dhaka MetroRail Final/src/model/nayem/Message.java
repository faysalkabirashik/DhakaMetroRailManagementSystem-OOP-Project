package model.nayem;

import java.io.Serializable;

public class Message implements Serializable
{
    String trainNumber;
    String targetStation;
    String messageType;
    String message;

    public Message(String trainNumber, String targetStation, String messageType, String message) {
        this.trainNumber = trainNumber;
        this.targetStation = targetStation;
        this.messageType = messageType;
        this.message = message;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    public String getTargetStation() {
        return targetStation;
    }

    public void setTargetStation(String targetStation) {
        this.targetStation = targetStation;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Message{" + "trainNumber=" + trainNumber + ", targetStation=" + targetStation + ", messageType=" + messageType + ", message=" + message + '}';
    }
    
    
}
