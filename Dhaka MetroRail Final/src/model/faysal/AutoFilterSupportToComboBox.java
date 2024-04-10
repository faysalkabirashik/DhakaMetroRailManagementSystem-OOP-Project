/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.faysal;

import java.io.Serializable;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.scene.control.ComboBox;

/**
 *
 * @author Faysal Kabir Ashik
 */
public class AutoFilterSupportToComboBox implements Serializable {
    
    
        public static void setTheComboBoxAutoFilterSupported(ComboBox<String> comboBox, ObservableList<String> list){
    
        // Create FilteredList
         FilteredList<String> filteredList = new FilteredList<>(list);
         comboBox.setItems(filteredList);
         
        // Add a listener to the text property of the ComboBox's editor
        comboBox.getEditor().textProperty().addListener
        (
            (obs, oldValue, newValue) -> 
            {
                // If the new value is empty, show all items
                if (newValue == null || newValue.isEmpty()) 
                {
                    filteredList.setPredicate(null);
                    return;
                }
                final String filter = newValue.toLowerCase();

            // Set predicate to filter items
            filteredList.setPredicate(item -> item.toLowerCase().startsWith(filter));
            }
        );
         
         
        }
}
