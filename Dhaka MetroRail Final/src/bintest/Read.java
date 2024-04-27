package bintest;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.faysal.AlertGen;
import model.faysal.AppendableObjectOutputStream;
import model.faysal.Validation;
import model.faysal.users.Accountant;
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
public class Read {
<<<<<<< HEAD
    
    public static ObservableList<LoginInfo> getListOfObjects(){
=======
//    Book s = new Book();
    
    
    
    public static boolean checkUserExist( String idCheck) {
        
        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        String path = null;
        boolean foundFlag = false;
        
        ////////////////////////////////////////////////////
        if (Validation.allDigits(idCheck)){
            String empLabel = idCheck.substring(2, 4);
            switch (empLabel) {
                case "00":
                    path = "SystemAdministrator.bin";
                    break;
                case "01":
                    path = "StationManager.bin";
                    break;
                case "02":
                    path = "TrainOperator.bin";
                    break;
                case "03":
                    path = "HeadOfHR.bin";
                    break;
                case "05":
                    path = "MaintenanceStaff.bin"; 
                    break;
                case "06":
                    path = "PublicServiceProvider.bin";
                    break;
                case "04":
                    path = "Accountant.bin";
                    break;
                default:
                    break;
            }
            
            
        } else if (Validation.isValidUsername(idCheck)){
            path = "Passenger.bin";
        } else {
            AlertGen.unsuccessfulAlert("invalid User Identity!!");
            return false;
        }
 
        ///////////////////////////////////////////////
        try {
            f = new File(path);
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            
            /////////////////////////////////////////////////                        
            try {
                System.out.println(" objects of SystemAdministrator");
                if (path.equals("SystemAdministrator.bin")) {
                    SystemAdministrator tempUser ;
                    while (true){
                        if (foundFlag == true){
                            System.out.println("user exists || System Admin");
                            break;
                        }
                        tempUser = (SystemAdministrator) ois.readObject();
                        if (idCheck.equals(tempUser.getUserIdentity())) {
                            foundFlag = true;
                            System.out.println(tempUser.getUserIdentity() +" = "+ idCheck);
                            return true;
                        }
                    }
                } else if (path.equals("StationManager.bin")) {
                    StationManager tempUser;
                    while (true){
                        if (foundFlag == true){
                            System.out.println("user exists || Station Manager");
                            break;
                        }
                        tempUser = (StationManager) ois.readObject();
                        if (idCheck.equals(tempUser.getUserIdentity())) {
                            foundFlag = true;
                            System.out.println(tempUser.getUserIdentity() +" = "+ idCheck);
                            return true;
                        }
                    }
                } else if (path.equals("Passenger.bin")) {
                    Passenger tempUser;
                    while (true){
                        if (foundFlag == true){
                            System.out.println("user exists || Passenger");
                            break;
                        }
                        tempUser = (Passenger) ois.readObject();
                        if (idCheck.equals(tempUser.getUserIdentity())) {
                            foundFlag = true;
                            System.out.println(tempUser.getUserIdentity() +" = "+ idCheck);
                            return true;
                        }
                    }
                    
                } else if (path.equals("TrainOperator.bin")) {
                    TrainOperator tempUser;
                    while (true){
                        if (foundFlag == true){
                            System.out.println("user exists || Train Operator");
                            break;
                        }
                        tempUser = (TrainOperator) ois.readObject();
                        if (idCheck.equals(tempUser.getUserIdentity())) {
                            foundFlag = true;
                            System.out.println(tempUser.getUserIdentity() +" = "+ idCheck);
                            return true;
                        }
                    }
                } else if (path.equals("HeadOfHR.bin")) {
                    HeadOfHR tempUser;
                    while (true){
                        if (foundFlag == true){
                            System.out.println("user exists || Head Of HR");
                            break;
                        }
                        tempUser = (HeadOfHR) ois.readObject();
                        if (idCheck.equals(tempUser.getUserIdentity())) {
                            foundFlag = true;
                            System.out.println(tempUser.getUserIdentity() +" = "+ idCheck);
                            return true;
                        }
                    }
                } else if (path.equals("Accountant.bin")) {
                    Accountant tempUser;
                    while (true){
                        if (foundFlag == true){
                            System.out.println("user exists || Accountant");
                            break;
                        }
                        tempUser = (Accountant) ois.readObject();
                        if (idCheck.equals(tempUser.getUserIdentity())) {
                            foundFlag = true;
                            System.out.println(tempUser.getUserIdentity() +" = "+ idCheck);
                            return true;
                        }
                    }
                } else if (path.equals("MaintenanceStaff.bin")) {
                   MaintenanceStaff tempUser;
                   while (true){
                        if (foundFlag == true){
                            System.out.println("user exists || MaintenanceS taff ");
                            break;
                        }
                        tempUser = (MaintenanceStaff) ois.readObject();
                        if (idCheck.equals(tempUser.getUserIdentity())) {
                            foundFlag = true;
                            System.out.println(tempUser.getUserIdentity() +" = "+ idCheck);
                            return true;
                        }
                    }
                } else if (path.equals("PublicServiceProvider.bin")){
                    PublicServiceProvider tempUser;
                    while (true){
                        if (foundFlag == true){
                            System.out.println("user exists || Public Service Provider");
                            break;
                        }
                        tempUser = (PublicServiceProvider) ois.readObject();
                        if (idCheck.equals(tempUser.getUserIdentity())) {
                            foundFlag = true;
                            System.out.println(tempUser.getUserIdentity() +" = "+ idCheck);
                            return true;
                        }
                    }
                }

                //System.out.println(tempUser.toString());
            } catch (IOException | ClassNotFoundException e) {
                //System.out.println(e.toString());
                System.out.println("IOException | ClassNotFoundException in reading bin file");
            }
            System.out.println("End of file\n");
            ////////////////////////////////////////////

        } catch (IOException ex) {
            System.out.println("IOException on entire file handling");
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException ex) {
            }
        }
        
        return foundFlag;

    }
    
    
    
    public static boolean checkUserExist(String userType, String idCheck) {
        
        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        String path = null;
        boolean foundFlag = false;
        if (userType.equals("System Administrator")) {
            path = "SystemAdministrator.bin";
        } else if (userType.equals("Station Manager")) {
            path = "StationManager.bin";
        } else if (userType.equals("Train Operator")) {
            path = "TrainOperator.bin";
        } else if (userType.equals("Head of HR")) {
            path = "HeadOfHR.bin";
        } else if (userType.equals("Maintenance Staff")) {
            path = "MaintenanceStaff.bin";
        } else if (userType.equals("Public Service Provider")) {
            path = "PublicServiceProvider.bin";
        } else if (userType.equals("Accountant")) {
            path = "Accountant.bin";
        } else if (userType.equals("Passenger")) {
            path = "Passenger.bin";
        }

        try {
            f = new File(path);
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            
            /////////////////////////////////////////////////                        
            try {
                System.out.println(" objects of SystemAdministrator");

                if (path.equals("SystemAdministrator.bin")) {
                    SystemAdministrator tempUser ;
                    while (true){
                        if (foundFlag == true){
                            System.out.println("user exists");
                            break;
                        }
                        tempUser = (SystemAdministrator) ois.readObject();
                        if (idCheck.equals(tempUser.getUserIdentity())) {
                            foundFlag = true;
                            System.out.println(tempUser.getUserIdentity() +" = "+ idCheck);
                            return true;
                        }
                    }
                } else if (path.equals("StationManager.bin")) {
                    StationManager tempUser;
                    while (true){
                        if (foundFlag == true){
                            System.out.println("user exists");
                            break;
                        }
                        tempUser = (StationManager) ois.readObject();
                        if (idCheck.equals(tempUser.getUserIdentity())) {
                            foundFlag = true;
                            System.out.println(tempUser.getUserIdentity() +" = "+ idCheck);
                            return true;
                        }
                    }
                } else if (path.equals("Passenger.bin")) {
                    Passenger tempUser;
                    while (true){
                        if (foundFlag == true){
                            System.out.println("user exists");
                            break;
                        }
                        tempUser = (Passenger) ois.readObject();
                        if (idCheck.equals(tempUser.getUserIdentity())) {
                            foundFlag = true;
                            System.out.println(tempUser.getUserIdentity() +" = "+ idCheck);
                            return true;
                        }
                    }
                    
                } else if (path.equals("TrainOperator.bin")) {
                    TrainOperator tempUser;
                    while (true){
                        if (foundFlag == true){
                            System.out.println("user exists");
                            break;
                        }
                        tempUser = (TrainOperator) ois.readObject();
                        if (idCheck.equals(tempUser.getUserIdentity())) {
                            foundFlag = true;
                            System.out.println(tempUser.getUserIdentity() +" = "+ idCheck);
                            return true;
                        }
                    }
                } else if (path.equals("HeadOfHR.bin")) {
                    HeadOfHR tempUser;
                    while (true){
                        if (foundFlag == true){
                            System.out.println("user exists");
                            break;
                        }
                        tempUser = (HeadOfHR) ois.readObject();
                        if (idCheck.equals(tempUser.getUserIdentity())) {
                            foundFlag = true;
                            System.out.println(tempUser.getUserIdentity() +" = "+ idCheck);
                            return true;
                        }
                    }
                } else if (path.equals("Accountant.bin")) {
                    Accountant tempUser;
                    while (true){
                        if (foundFlag == true){
                            System.out.println("user exists");
                            break;
                        }
                        tempUser = (Accountant) ois.readObject();
                        if (idCheck.equals(tempUser.getUserIdentity())) {
                            foundFlag = true;
                            System.out.println(tempUser.getUserIdentity() +" = "+ idCheck);
                            return true;
                        }
                    }
                } else if (path.equals("MaintenanceStaff.bin")) {
                   MaintenanceStaff tempUser;
                   while (true){
                        if (foundFlag == true){
                            System.out.println("user exists");
                            break;
                        }
                        tempUser = (MaintenanceStaff) ois.readObject();
                        if (idCheck.equals(tempUser.getUserIdentity())) {
                            foundFlag = true;
                            System.out.println(tempUser.getUserIdentity() +" = "+ idCheck);
                            return true;
                        }
                    }
                } else if (path.equals("PublicServiceProvider.bin")){
                    PublicServiceProvider tempUser;
                    while (true){
                        if (foundFlag == true){
                            System.out.println("user exists");
                            break;
                        }
                        tempUser = (PublicServiceProvider) ois.readObject();
                        if (idCheck.equals(tempUser.getUserIdentity())) {
                            foundFlag = true;
                            System.out.println(tempUser.getUserIdentity() +" = "+ idCheck);
                            return true;
                        }
                    }
                }

                //System.out.println(tempUser.toString());
            } catch (IOException | ClassNotFoundException e) {
                //System.out.println(e.toString());
                System.out.println("IOException | ClassNotFoundException in reading bin file");
            }
            System.out.println("End of file\n");
            ////////////////////////////////////////////

        } catch (IOException ex) {
            System.out.println("IOException on entire file handling");
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException ex) {
            }
        }
        
        return foundFlag;

    }

    public static ObservableList<LoginInfo> getListOfObjects() {
>>>>>>> Faysal-2111585
        ObservableList<LoginInfo> list = FXCollections.observableArrayList();
        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
<<<<<<< HEAD
        String path = "LoginInfoObjects.bin";
=======
        String path = "Books.bin";
>>>>>>> Faysal-2111585
        try {
            f = new File(path);
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            LoginInfo tempUser = null;
<<<<<<< HEAD
            try{
                System.out.println("Printing objects");
                while(true){
                    tempUser = (LoginInfo) ois.readObject();
//                     System.out.println(tempUser.toString());
                    list.add((LoginInfo)tempUser);
                }
            }
            catch(IOException | ClassNotFoundException e){
=======
            try {
                System.out.println("Printing objects");
                while (true) {
                    tempUser = (LoginInfo) ois.readObject();
//                     System.out.println(tempUser.toString());
                    list.add((LoginInfo) tempUser);
                }
            } catch (IOException | ClassNotFoundException e) {
>>>>>>> Faysal-2111585
                //System.out.println(e.toString());
                System.out.println("IOException | ClassNotFoundException in reading bin file");
            }
            System.out.println("End of file\n");
        } catch (IOException ex) {
            System.out.println("IOException on entire file handling");
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException ex) {
            }
        }
        //System.out.println(list);        
        return list;
    }

    public static void write() {
        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            f = new File("Books.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }

            Book toAdd = new Book("one", 1, "keui");
            oos.writeObject(toAdd);

            oos.close();

            System.out.println(" add success");

        } catch (IOException ex) {
            Logger.getLogger(Read.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("1st catch");
        } finally {
            try {
                if (oos != null) {
                    System.out.println(" , 2nd catch");
                    oos.close();
                }

            } catch (IOException ex) {
                Logger.getLogger(Read.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(" last catch");
            }
        }

    }

    public static void read() {

        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        String path = "Books.bin";
        try {

            System.out.println("Entered in try block initializing file path");
            f = new File(path);
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);

            try {

                System.out.println("Printing objects");
                while (true) {
                    try {
                        Book temp = (Book) ois.readObject();
                        System.out.println("Book: " + temp.toString());
                    } catch (EOFException e) {
                        // End of file reached
                        break;
                    }

                    /*System.out.println("Entered in while blocks");
                    temp = (Book) ois.readObject();
                    System.out.println("Book");
                    System.out.println(temp.toString());*/
                }
            } catch (IOException | ClassNotFoundException e) {
                //System.out.println(e.toString());
                System.out.println("IOException | ClassNotFoundException in reading bin file");
            }
            System.out.println("End of file\n");
        } catch (IOException ex) {
            System.out.println("IOException on entire file handling");
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException ex) {
            }
        }

    }

}
