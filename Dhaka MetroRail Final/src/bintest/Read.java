





/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bintest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.faysal.users.Employee;
import model.faysal.users.SystemAdministrator;
import model.faysal.users.User;

/**
 *
 * @author Faysal Kabir Ashik
 */
public class Read {
    
    public static ObservableList<Employee> getListOfObjects(){
        ObservableList<Employee> list = FXCollections.observableArrayList();
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        String path = "SystemAdministrator.bin";
        try {
            f = new File(path);
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            Employee tempUser = null;
            try{
                System.out.println("Printing objects");
                while(true){
                    tempUser = (SystemAdministrator) ois.readObject();
 
                    System.out.println(tempUser.toString());
                    list.add((SystemAdministrator)tempUser);
                }
            }
            catch(IOException | ClassNotFoundException e){
                System.out.println(e.toString());
                System.out.println("IOException | ClassNotFoundException in reading bin file");
            }
            System.out.println("End of file\n");
        } catch (IOException ex) {
            System.out.println("IOException on entire file handling");
        }
        finally {
            try {
                if(ois != null) ois.close();
            } catch (IOException ex) { }
        }
        System.out.println(list);        
        return list;
    } 

}
