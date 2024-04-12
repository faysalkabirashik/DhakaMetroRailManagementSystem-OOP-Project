package model.nayem;

import java.io.Serializable;

public class Message2 implements Serializable
{
    String trainNumber;
    String reportType;
    String Problem;

    public Message2(String trainNumber, String reportType, String Problem) {
        this.trainNumber = trainNumber;
        this.reportType = reportType;
        this.Problem = Problem;
    }

    @Override
    public String toString() {
        return "Message2{" + "trainNumber=" + trainNumber + ", reportType=" + reportType + ", Problem=" + Problem + '}';
    }
}
