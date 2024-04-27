/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.jubair.hr;

import java.time.LocalDate;

/**
 *
 * @author user
 */
public class Attendance {
    
    private String id,name,designation,satus;
    private LocalDate attendDate;

    public Attendance(String id, String name, String designation, String satus, LocalDate attendDate) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.satus = satus;
        this.attendDate = attendDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getSatus() {
        return satus;
    }

    public void setSatus(String satus) {
        this.satus = satus;
    }

    public LocalDate getAttendDate() {
        return attendDate;
    }

    public void setAttendDate(LocalDate attendDate) {
        this.attendDate = attendDate;
    }

    @Override
    public String toString() {
        return "Attendance{" + "id=" + id + ", name=" + name + ", designation=" + designation + ", satus=" + satus + ", attendDate=" + attendDate + '}';
    }
    
    
}
