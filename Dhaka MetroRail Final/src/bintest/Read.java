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
import model.faysal.AppendableObjectOutputStream;
import model.faysal.users.Employee;
import model.faysal.users.LoginInfo;
import model.faysal.users.SystemAdministrator;
import model.faysal.users.User;

/**
 *
 * @author Faysal Kabir Ashik
 */
public class Read {
<<<<<<< HEAD
    
    public static ObservableList<LoginInfo> getListOfObjects(){
=======
//    Book s = new Book();

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