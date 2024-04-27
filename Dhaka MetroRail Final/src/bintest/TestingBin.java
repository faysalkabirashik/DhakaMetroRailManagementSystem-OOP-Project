 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bintest;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import model.faysal.users.Employee;
import model.faysal.users.HeadOfHR;
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
        System.out.println(Read.checkUserExist( "pass2"));
        System.out.println("");
          
//        System.out.println(new SystemAdministrator().getTotalNoOfObjects());
//         System.out.println(new StationManager().getTotalNoOfObjects()+ " "  );
//         System.out.println(new Passenger().getTotalNoOfObjects()+ " " );
//         System.out.println(new HeadOfHR().getTotalNoOfObjects()+ " "  );
//         System.out.println(new TrainOperator().getTotalNoOfObjects()   );
//        System.out.println(new PublicServiceProvider().getTotalNoOfObjects()+ " " );
// 
//        System.out.println(User.verifyLogin("2400100", "Pass@123"));
 
    }

    

    
    
public static void read()
    {
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        
        try {
            f = new File("SystemAdministrator.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            SystemAdministrator tempUser = null;
            try{
                System.out.println("Printing objects.");
                while(true){
                    System.out.println("Dhukse");
                    tempUser = (SystemAdministrator) ois.readObject();
                    System.out.println("ar hoy na");
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
