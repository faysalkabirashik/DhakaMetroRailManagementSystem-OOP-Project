 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bintest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import model.faysal.users.Employee;
import model.faysal.users.LoginInfo;
import model.faysal.users.MaintenanceStaff;
import model.faysal.users.PublicServiceProvider;
import model.faysal.users.StationManager;
import model.faysal.users.SystemAdministrator;
import model.faysal.users.User;
import model.nayem.Passenger;
import model.nayem.TrainOperator;

/**
 *
 * @author Faysal Kabir Ashik
 */
public class TestingBin {

    /**
 
     */
    public static void main(String[] args) {
        
//        System.out.println(Read.getListOfObjects().size());
//        read();
//        
        ///////////
        SystemAdministrator admin = new SystemAdministrator();
        StationManager sm = new StationManager();
        TrainOperator to = new TrainOperator();
        PublicServiceProvider ps = new PublicServiceProvider();
        MaintenanceStaff ms = new MaintenanceStaff();
        Passenger pas = new Passenger();
//        SystemAdministrator admin = new SystemAdministrator();
//        SystemAdministrator admin = new SystemAdministrator();  
//        SystemAdministrator admin = new SystemAdministrator();
//        SystemAdministrator admin = new SystemAdministrator();
//        SystemAdministrator admin = new SystemAdministrator();
        
        System.out.println(admin.getTotalNoOfObjects()+ " " + admin.getTotalListOfObjects());
//        System.out.println(sm.getTotalNoOfObjects()+ " " + sm.getTotalListOfObjects());
//        System.out.println(to.getTotalNoOfObjects()+ " " + to.getTotalListOfObjects());
//        System.out.println(ps.getTotalNoOfObjects()+ " " + ps.getTotalListOfObjects());
//        System.out.println(ms.getTotalNoOfObjects()+ " " + ms.getTotalListOfObjects());
//        System.out.println(pas.getTotalNoOfObjects()+ " " + pas.getTotalListOfObjects());
//        
//        
//        
//        /////////////////////
////         
////        System.out.println(User.verifyLogin("2400100", "Pass@123"));
////        System.out.println(User.getCountOfAllTypeOfUsers());
////            System.out.println(User.getObjectV2("2400100", "System Administrator"));



    }

public static void read()
    {
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        
        try {
            f = new File("LoginInfoObjects.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            LoginInfo tempUser = null;
            try{
                System.out.println("Printing objects.");
                while(true){
                    System.out.println("Dhukse");
                    tempUser = (LoginInfo) ois.readObject();
                    //Object obj = ois.readObject();
                    //obj.submitReport();
//                    loginInfo.submitReport();
                    
                    System.out.println(tempUser.toString());
//                    outputTextArea.appendText(emp.toString());
                }
            }//end of nested try
            catch(Exception e){
                // handling code
            }//nested catch     
            System.out.println("All objects are loaded successfully...\n");            
        } catch (IOException ex) {
            System.out.println(ex.toString());
        } 
        finally {
            try {
                
                if(ois != null) ois.close();
            } catch (IOException ex) { }
        }     
        
        
    }
}
