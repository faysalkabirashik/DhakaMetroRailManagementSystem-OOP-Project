/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.faysal.users;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.time.LocalDate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.faysal.Address;

/**
 *
 * @author Faysal Kabir Ashik
 */



public abstract class Employee extends User implements Serializable, Classifiable, Countable {

    //// field hidinhg/shawdowing.
    private static int userCount = 0;
    
    protected String nid, designation;
//    protected final LocalDate dateOfJoining;
        protected  LocalDate dateOfJoining;
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

    public Employee() {
        this.dateOfJoining = null;
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

    /////////////////////////////////////////////////////////////////////
    
    public static int getCountOfAllEmployees()
    {
        ObservableList<Employee> em = FXCollections.observableArrayList();
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        String path = "EmployeeObjects.bin";
        try {
                f = new File(path);
                fis = new FileInputStream(f);
                ois = new ObjectInputStream(fis);
                User tempUser = null;
                try {
                    while(true)
                        {
                        tempUser = (Employee) ois.readObject();
                        em.add((Employee)tempUser);
                        }
                    }
                catch(IOException | ClassNotFoundException e){}
            } 
        catch (IOException ex) {}
        finally {
                try {if(ois != null) ois.close();} 
                catch (IOException ex) { }
                }

        return em.size();
    }
    
    
        public static ObservableList<Employee> getAllEmployees()
    {
        ObservableList<Employee> em = FXCollections.observableArrayList();
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        String path = "EmployeeObjects.bin";
        try {
                f = new File(path);
                fis = new FileInputStream(f);
                ois = new ObjectInputStream(fis);
                User tempUser = null;
                try {
                    while(true)
                        {
                        tempUser = (Employee) ois.readObject();
                        em.add((Employee)tempUser);
                        }
                    }
                catch(IOException | ClassNotFoundException e){}
            } 
        catch (IOException ex) {}
        finally {
                try {if(ois != null) ois.close();} 
                catch (IOException ex) { }
                }

        return em;
    }
    
//    public String generateNewEmployeeID(){
//        
//    }
    
}
