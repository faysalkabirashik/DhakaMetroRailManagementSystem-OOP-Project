 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bintest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import model.faysal.users.LoginInfo;
import model.faysal.users.User;

/**
 *
 * @author Faysal Kabir Ashik
 */
public class TestingBin {

    /**
 
     */
    public static void main(String[] args) {
        System.out.println(User.verifyLogin("2400100", "Pass@123"));
//            System.out.println(User.getObjectV2("2400100", "System Administrator"));
read();
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
                    
                    tempUser = (LoginInfo) ois.readObject();
                    //Object obj = ois.readObject();
                    //obj.submitReport();
//                    loginInfo.submitReport();
                    
                    System.out.println(tempUser.toString());
                    System.out.println(tempUser.getUserIdentity() +" "  +tempUser.getPassword()+" " + tempUser.getUserType());
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
