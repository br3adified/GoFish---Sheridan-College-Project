package ca.sheridancollege.project;

import java.util.Collections;

/**
 * Standard 52-card deck implemented as a GroupOfCards
 * This deck creates GoFishCard instances (rank + suit)
 * @author Gurpreet Singh
 * @author Gurpreet Singh
 * @author Tanzil Aslam
 * @author Navjot Sandhu
 */
public class Deck extends GroupOfCards {
    private final String[] ranks = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
    private final String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};

    public Deck() {
        super();
        // Use public addCard() method instead of accessing cards directly
        for (String suit : suits) {
            for (String rank : ranks) {
                addCard(new GoFishCard(rank, suit));
            }
        }
        shuffle();
    }

    /**
     * Shuffle the deck
     */
    public void shuffle() {
        Collections.shuffle(getCards());
    }

    /**
     * Draw a card from the top (index 0)
     * Returns null if deck is empty
     */
    public GoFishCard drawCard() {
        if (getCards().size() == 0) return null;  
        // remove first card using getCards()
        return (GoFishCard) getCards().remove(0);
    }
}
