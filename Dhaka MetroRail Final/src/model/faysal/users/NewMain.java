/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package model.faysal.users;

import java.time.LocalDate;

/**
 *
 * @author Guest user
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(new SystemAdministrator().generateEmployeeID("System Administrator", LocalDate.now()));
        System.out.println();
        // TODO code application logic here
    }
    
}
