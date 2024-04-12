/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.faysal.users;

import java.io.Serializable;
import java.time.LocalDate;
import model.faysal.Address;

/**
 *
 * @author Faysal Kabir Ashik
 */



public abstract class Employee extends User implements Serializable, Classifiable, Countable {

    //// field hidinhg/shawdowing.
    private static int userCount = 0;
    
    protected String nid, designation;
    protected final LocalDate dateOfJoining;
    protected float salary;

    
    public abstract void changeDesignation();
    public abstract void applyForLeave();

    
    //////// constructors ////////////
    public Employee(String coreUserType, String userIdentity, LocalDate dateOfJoining) {
        super(coreUserType, userIdentity);
        this.dateOfJoining = dateOfJoining;
        userCount++;
    }

    public Employee(String nid, String designation, LocalDate dateOfJoining, float salary, String fullName, String primaryMobile, String primaryEmail, String gender, String userIdentity, String coreUserType, String password, LocalDate dateOfBirth, Address address, boolean loginStatus) {
        super(fullName, primaryMobile, primaryEmail, gender, userIdentity, coreUserType, password, dateOfBirth, address, loginStatus);
        this.nid = nid;
        this.designation = designation;
        this.dateOfJoining = dateOfJoining;
        this.salary = salary;
        userCount++;
    }

    public Employee(String nid, String designation, LocalDate dateOfJoining, float salary, String fullName, String primaryMobile, String primaryEmail, String gender, String userIdentity, String coreUserType, String password, LocalDate dateOfBirth, Address address, boolean loginStatus, String secondaryMobile, String secondaryEmail) {
        super(fullName, primaryMobile, primaryEmail, gender, userIdentity, coreUserType, password, dateOfBirth, address, loginStatus, secondaryMobile, secondaryEmail);
        this.nid = nid;
        this.designation = designation;
        this.dateOfJoining = dateOfJoining;
        this.salary = salary;
        userCount++;
    }

    
    
    //////////////// getter setter to string /////////////
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

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }
    
    
    public String getEmployeeID(){
        return this.getUserIdentity();
    }



    @Override
    public String toString() {
        return "Employee{" + "nid=" + nid + ", designation=" + designation + ", dateOfJoining=" + dateOfJoining + ", salary=" + salary + '}';
    }
    

    /////////////////////////////////////////////////////////////
    
    public static int totalEmployee() {return userCount;}

    
//    public String generateNewEmployeeID(){
//        
//    }
    
}
