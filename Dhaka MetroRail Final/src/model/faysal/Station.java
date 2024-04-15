/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.faysal;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Faysal Kabir Ashik
 */
public class Station  implements Serializable {
    
    
    

    
    private String serial;
    private String city;

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Station() {
    }

    public Station(String serial, String city) {
        this.serial = serial;
        this.city = city;
    }

    @Override
    public String toString() {
        return "Station{" + "serial=" + serial + ", city=" + city + '}';
    }
            
            
    public static List<String> getList(){
        List<String> stations = new ArrayList<>();

        stations.add("Uttara North");
        stations.add("Uttara Center");
        stations.add("Uttara South");
        stations.add("Pallabi");
        stations.add("Mirpur 11");
        stations.add("Mirpur 10");
        stations.add("Kazipara");
        stations.add("Shewrapara");
        stations.add("Agargaon");
        stations.add("Bijoy Sarani");
        stations.add("Farmgate");
        stations.add("Karwan Bazar");
        stations.add("Shahbag");
        stations.add("Dhaka University");
        stations.add("Bangladesh Secretariat");
        stations.add("Motijheel");
        return stations;
    
    
    }
    
     
    
}
