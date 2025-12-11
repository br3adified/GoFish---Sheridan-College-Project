/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

/**
 * General purpose group (hand/deck/pile) of cards that works with any card Subclass
 * @author Gurpreet Singh
 * @author Gurpreet Singh
 * @author Tanzil Aslam
 * @author Navjot Sandhu
 */
public class GroupOfCards {

    //The group of cards, stored in an ArrayList
    private ArrayList<Card> cards;

    public GroupOfCards() {
        cards = new ArrayList<>();
    }
    
    public void addCard(Card card) {
        cards.add(card);
    }
    
    public void removeCard(Card card) {
        cards.remove(card);
    }

    /**
     * return the underlying list. Caller may cast elements to specific Card SubClasses
     */
    public ArrayList<Card> getCards() {
        return cards;
    }

    /**
     * @return the size of the group of cards
     */
    public int getSize() {
        return cards.size();
    }
   
    public boolean isEmpty() {
        return cards.isEmpty();
    }

}//end class
