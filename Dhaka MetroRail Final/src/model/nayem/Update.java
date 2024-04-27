package model.nayem;

import java.io.Serializable;

public class Update implements Serializable 
{
    String trainId;
    String time;
    String updateType;
    String update;

    public Update(String trainId, String time, String updateType, String update) {
        this.trainId = trainId;
        this.time = time;
        this.updateType = updateType;
        this.update = update;
    }

    public String getTrainId() {
        return trainId;
    }

    public void setTrainId(String trainId) {
        this.trainId = trainId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUpdateType() {
        return updateType;
    }

    public void setUpdateType(String updateType) {
        this.updateType = updateType;
    }

    public String getUpdate() {
        return update;
    }

    public void setUpdate(String update) {
        this.update = update;
    }

    @Override
    public String toString() {
        return "Update{" + "time=" + time + ", updateType=" + updateType + ", update=" + update + '}';
    }

    
}
