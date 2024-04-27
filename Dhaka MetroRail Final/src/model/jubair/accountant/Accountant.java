/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.jubair.accountant;

/**
 *
 * @author user
 */
public class Accountant {
    
    int empID;
    String empName, empDesignation;
    static String companyName= "Dhaka Metro Rail";

    public Accountant(int empID, String empName, String empDesignation) {
        this.empID = empID;
        this.empName = empName;
        this.empDesignation = empDesignation;
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpDesignation() {
        return empDesignation;
    }

    public void setEmpDesignation(String empDesignation) {
        this.empDesignation = empDesignation;
    }

    public static String getCompanyName() {
        return companyName;
    }

    public static void setCompanyName(String companyName) {
        Accountant.companyName = companyName;
    }

    @Override
    public String toString() {
        return "Accountant{" + "empID=" + empID + ", empName=" + empName + ", empDesignation=" + empDesignation + '}';
    }
    
    
    
}
