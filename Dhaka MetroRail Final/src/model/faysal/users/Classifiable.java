

package model.faysal.users;

import java.util.HashMap;
import java.util.Map;


/**
 *
 * @author Faysal Kabir Ashik
 */
public interface Classifiable extends Countable  {
    
    public static final String EMPLOYEE_CLASS = "Govt Employee";
    
    
    public static final Map<String, String> MAP_CLASSIFICATION_LABEL = new HashMap<String , String>() {{
    put("System Administrator",    "00");
    put("Station Manager", "01");
    put("Train Operator",   "02");
    put("Head of HR",    "03");
    put("Accountant", "04");
    put("Maintenance Staff",   "05");
    put("Public Service Provider",   "06");  
    put(  "Passenger",  "07");}
    
    };
                                                                                                        
    
    //public void setLabel(String str);
    //public void getLabel();

    
    
}
