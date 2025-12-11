/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;


import java.util.ArrayList;
import java.util.Iterator;

/**
 * Concrete player class for go fish. Uses GroupOfCards to represents hand.
 * @author Gurpreet Singh
 * @author Gurpreet Singh
 * @author Tanzil Aslam
 * @author Navjot Sandhu
 */
public abstract class Player {

    private String name; //the unique name for this player
    private final GroupOfCards hand;
    private final ArrayList<Book> books;
    /**
     * A constructor that allows you to set the player's unique ID
     *
     * @param name the unique ID to assign to this player.
     */
    public Player(String name) {
        this.name = name;
        hand = new GroupOfCards();
        books = new ArrayList<>();;
    }

    /**
     * @return the player name
     */
    public String getName() {
        return name;
    }

    /**
     * Ensure that the playerID is unique
     *
     * @param name the player name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
     public void drawCard(Deck deck) {
        GoFishCard card = deck.drawCard();
        if (card != null) {
            hand.addCard(card);
        }
    }
     
     public boolean hasRank(String rank) {
        for (Card c : hand.getCards()) {
            if (c instanceof GoFishCard) {
                if (((GoFishCard) c).getRank().equals(rank)) return true;
            }
        }
        return false;
    }
 
      public ArrayList<GoFishCard> giveCardsOfRank(String rank) {
        ArrayList<GoFishCard> givenCards = new ArrayList<>();
        Iterator<Card> iterator = hand.getCards().iterator();

        while (iterator.hasNext()) {
            Card c = iterator.next();
            if (c instanceof GoFishCard) {
                GoFishCard card = (GoFishCard) c;
                if (card.getRank().equals(rank)) {
                    givenCards.add(card);
                    iterator.remove();
                }
            }
        }
        return givenCards;
    }
      
      public void receiveCards(ArrayList<GoFishCard> cardsToReceive) {
        for (GoFishCard card : cardsToReceive) {
            hand.addCard(card);
        }
    }

   public boolean checkForBook() {
        String[] ranks = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
        for (String rank : ranks) {
            int count = 0;
            for (Card c : hand.getCards()) {
                if (c instanceof GoFishCard) {
                    if (((GoFishCard)c).getRank().equals(rank)) count++;
                }
            }
            if (count == 4) {
                removeBookCards(rank);
                books.add(new Book(rank));
                return true;
            }
        }
        return false;
    }
     private void removeBookCards(String rank) {
        hand.getCards().removeIf(card -> (card instanceof GoFishCard) && ((GoFishCard)card).getRank().equals(rank));
    }

    public int getBookCount() {
        return books.size();
    }

    public void showHand() {
        System.out.println(name + "'s Hand:");
        for (Card c : hand.getCards()) {
            System.out.println("  " + c.toString());
        }
    }
}