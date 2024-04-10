
package view.faysal.systemadmin.manageuser;

import mainpkg.*;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class TestManageUser extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("/view/faysal/systemadmin/manageuser/CreateNewUser.fxml"));
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
