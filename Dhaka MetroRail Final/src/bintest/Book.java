/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bintest;

import java.io.Serializable;

/**
 *
 * @author Faysal Kabir Ashik
 */
public class Book implements Serializable {
    private static final long serialVersionUID = 1L;
    
    String name;
    int id;
    String author;

    public Book(String name, int id, String author) {
        this.name = name;
        this.id = id;
        this.author = author;
    }

    public Book() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" + "name=" + name + ", id=" + id + ", author=" + author + '}';
    }
    
    
    
}
