
package mainpkg;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class MainApplicationClass extends Application {
    /*
    ///////////// modification classes ///////////////////////////////////////////////////////////////////
    
    //    added field nofOfEmpManaged in StationManager.java class (pkg - modell.faysal.usesrs), changes constructors, getter setter, to string
    //    modified CreateNewUsesrController.java in pkg view.faysal.systemadmin in 461 (approx) line 
    //              -- deleted StationManager.bin it will automatically add the updated object, the code designed as that way
                    // --  as I deleted bin files for users , others user needs to be created first, then they can login
                       // but I created Station Manager users, and System Administrator, they can login 
    //      
    //      added  getTOtalListOfObjects() in StationManager.java in same pkg
    //      added new fxml file -"ShowStationManagers.fxml" in pkg view.faysal.station_manager
    //      added new fxml file -"ShowStationManagersController.java" in pkg view.faysal.station_manager
    //      
    //      added a Test.java (contains main() method) in pkg view.faysal.station_manager to test the modified code work.
    //
    // as far as I remember I added/deleted these files
    */
    
    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    
    @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("/login/faysal/LoginScene.fxml"));
        try 
        {
               
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        }
        
        catch(ClassCastException ce){
            System.out.println(ce);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
