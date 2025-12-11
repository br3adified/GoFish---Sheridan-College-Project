package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Init the game
 *
 * @author Gurpreet Singh
 * @author Gurpreet Singh
 * @author Tanzil Aslam
 * @author Navjot Sandhu
 */
public class GoFishGame {

    private Player player1;
    private Player player2;
    private Deck deck;

    public void startGame() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter Player 1 Name: ");
        player1 = new GoFishPlayer(input.nextLine().trim());

        System.out.print("Enter Player 2 Name: ");
        player2 = new GoFishPlayer
        (input.nextLine().trim());

        deck = new Deck();

        for (int i = 0; i < 7; i++) {
            player1.drawCard(deck);
            player2.drawCard(deck);
        }

        playGame();
    }

    private void playGame() {
        Player current = player1;
        Player other = player2;
        Scanner input = new Scanner(System.in);

        while (player1.getBookCount() + player2.getBookCount() < 13) {
            System.out.println("\n----- " + current.getName() + "'s TURN -----");

            current.showHand();

            System.out.print("Enter rank to ask for: ");
            String rank = input.nextLine().trim();

            if (rank.isEmpty()) {
                System.out.println("Invalid rank. Turn skipped.");
            } else {
                if (other.hasRank(rank)) {
                    ArrayList<GoFishCard> cards = other.giveCardsOfRank(rank);
                    current.receiveCards(cards);
                    System.out.println(other.getName() + " gave " + cards.size() + " card(s).");
                } else {
                    System.out.println("Go Fish!");
                    GoFishCard drawn = deck.drawCard();

                    if (drawn != null) {
                        ArrayList<GoFishCard> drawnCard = new ArrayList<>();
                        drawnCard.add(drawn);
                        current.receiveCards(drawnCard);
                        System.out.println("You drew: " + drawn);
                    } else {
                        System.out.println("Deck is empty.");
                    }
                }

                if (current.checkForBook()) {
                    System.out.println(current.getName() + " completed a BOOK!");
                }
            }

            // swap turns
            Player temp = current;
            current = other;
            other = temp;
        }

        endGame();
    }

    private void endGame() {
        System.out.println("\n-- GAME OVER --");
        System.out.println(player1.getName() + " Books: " + player1.getBookCount());
        System.out.println(player2.getName() + " Books: " + player2.getBookCount());

        if (player1.getBookCount() > player2.getBookCount())
            System.out.println(player1.getName() + " WINS!");
        else if (player1.getBookCount() < player2.getBookCount())
            System.out.println(player2.getName() + " WINS!");
        else
            System.out.println("IT'S A TIE!");
    }

    public static void main(String[] args) {
        GoFishGame game = new GoFishGame();
        game.startGame();
    }
}
