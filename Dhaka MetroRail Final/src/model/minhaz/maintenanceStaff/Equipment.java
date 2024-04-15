/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.minhaz.maintenanceStaff;

/**
 *
 * @author User
 */
public class Equipment {
    int sl;
    String mainHistory;
    String currentStatus;

    public Equipment(int sl, String mainHistory, String currentStatus) {
        this.sl = sl;
        this.mainHistory = mainHistory;
        this.currentStatus = currentStatus;
    }

    public int getSl() {
        return sl;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }

    public String getMainHistory() {
        return mainHistory;
    }

    public void setMainHistory(String mainHistory) {
        this.mainHistory = mainHistory;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    @Override
    public String toString() {
        return "Equipment{" + "sl=" + sl + ", mainHistory=" + mainHistory + ", currentStatus=" + currentStatus + '}';
    }
    
    
}
