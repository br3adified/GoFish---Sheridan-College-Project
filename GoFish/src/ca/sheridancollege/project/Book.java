/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 * Represents a completed Book (four cards of same rank)
 * @author Gurpreet Singh
 * @author Gurpreet Singh
 * @author Tanzil Aslam
 * @author Navjot Sandhu
 */
public class Book {
    private String rank;
    
    public Book(String rank) {
      this.rank = rank;       
    }
    
    public String getRank() {
        return rank;
    }
    
    @Override
    public String toString() {
        return "Book of " + rank + "s";
    }
}
