/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.faysal;

import java.io.Serializable;

/**
 *
 * @author Faysal Kabir Ashik
 */
public class Report implements Serializable{
    
    
    private String titile;
    private String message;

    public Report(String titile, String message) {
        this.titile = titile;
        this.message = message;
    }

    public String getTitile() {
        return titile;
    }

    public void setTitile(String titile) {
        this.titile = titile;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    
}
