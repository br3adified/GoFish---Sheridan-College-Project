/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *Concrete card for GoFish . Extends the professor abstract card.
 * @author Gurpreet Singh
 * @author Gurpreet Singh
 * @author Tanzil Aslam
 * @author Navjot Sandhu
 */
public class GoFishCard extends Card {
    private final String rank;
    private final String suit;
    
    public GoFishCard(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }
    
    public String getRank() {
        return rank;
    }
    
    public String getSuit() {
        return suit;
    }
    
    @Override
    public String toString() {
        return rank + " of "  + suit;
    }
}
