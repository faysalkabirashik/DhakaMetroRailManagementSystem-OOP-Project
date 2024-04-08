/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.faysal;

import java.io.*;
import java.time.LocalDate;

/**
 *
 * @author Faysal Kabir Ashik
 */
public abstract class Employee extends User implements Serializable {
    
    protected String nid, designation;
    protected LocalDate dateOfJoining;
    protected float salary;


    public Employee(String nid, String designation, LocalDate dateOfJoining, float salary, String fullName, String primaryMobile, String primaryEmail, String gender, LocalDate dateOfBirth, String userType, String userIdentity, String password, Address address, boolean loginStatus) {
        super(fullName, primaryMobile, primaryEmail, gender, dateOfBirth, userType, userIdentity, password, address, loginStatus);
        this.nid = nid;
        this.designation = designation;
        this.dateOfJoining = dateOfJoining;
        this.salary = salary;
    }

    public Employee(String nid, String designation, LocalDate dateOfJoining, float salary, String fullName, String primaryMobile, String primaryEmail, String gender, LocalDate dateOfBirth, String userType, String userIdentity, String password, Address address, boolean loginStatus, String secondaryMobile, String secondaryEmail) {
        super(fullName, primaryMobile, primaryEmail, gender, dateOfBirth, userType, userIdentity, password, address, loginStatus, secondaryMobile, secondaryEmail);
        this.nid = nid;
        this.designation = designation;
        this.dateOfJoining = dateOfJoining;
        this.salary = salary;
    }
    
    
    public abstract void leaveApplication();
    
    public abstract void updateSalary();

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public LocalDate getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(LocalDate dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" + "nid=" + nid + ", designation=" + designation + ", dateOfJoining=" + dateOfJoining + ", salary=" + salary + '}';
    }
    
    
}
