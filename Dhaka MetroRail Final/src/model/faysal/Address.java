/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.faysal;

/**
 *
 * @author Faysal Kabir Ashik
 */
public class Address {
    
    private String district;
    private String city;
    private String road;
    private String village;
    private String house;

    public Address(String district, String city, String road, String village, String house) {
        this.district = district;
        this.city = city;
        this.road = road;
        this.village = village;
        this.house = house;
    }

<<<<<<< HEAD
=======
    public Address(String district, String city, String house) {
        this.district = district;
        this.city = city;
        this.house = house;
    }
    

>>>>>>> Pathan-2221656
    public String getDistrict() {
        return district;
    }

    public String getCity() {
        return city;
    }

    public String getRoad() {
        return road;
    }

    public String getVillage() {
        return village;
    }

    public String getHouse() {
        return house;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    @Override
    public String toString() {
        return "Address{" + "district=" + district + ", city=" + city + ", road=" + road + ", village=" + village + ", house=" + house + '}';
    }
    
    
    
}
