/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.faysal;

import model.faysal.users.User;

/**
 *
 * @author Faysal Kabir Ashik
 */
public class DescriptionOnUserCreation {
    
    private String note;
    private User user;

    public DescriptionOnUserCreation(String note, User user) {
        this.note = note;
        this.user = user;
    }

    public DescriptionOnUserCreation() {
    }

    public DescriptionOnUserCreation(String note) {
        this.note = note;
    }
    
    
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "DescriptionOnUserCreation{" + "note=" + note + ", user=" + user + '}';
    }
    
    
}
