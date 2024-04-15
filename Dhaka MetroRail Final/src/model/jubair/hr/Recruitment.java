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
public class Recruitment {
    private String details,salary,designation;
    private LocalDate recruitmentDate;

    public Recruitment(String details, String salary, String designation, LocalDate recruitmentDate) {
        this.details = details;
        this.salary = salary;
        this.designation = designation;
        this.recruitmentDate = recruitmentDate;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public LocalDate getRecruitmentDate() {
        return recruitmentDate;
    }

    public void setRecruitmentDate(LocalDate recruitmentDate) {
        this.recruitmentDate = recruitmentDate;
    }

    @Override
    public String toString() {
        return "Recruitment{" + "details=" + details + ", salary=" + salary + ", designation=" + designation + ", recruitmentDate=" + recruitmentDate + '}';
    }
    
    
    
}
