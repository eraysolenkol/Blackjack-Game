package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Blackjack {
    Random random = new Random();
    Scanner scan = new Scanner(System.in);
    List<String> suits = Arrays.asList("Clubs","Diamonds","Hearts","Spades");
    List<String> faces = Arrays.asList("A","2","3","4","5","6","7","8","9","10","J","Q","K");


    /*
     * Generates a default deck of 52 cards.
     * 
     * @return  List<Card>  default a 52-card deck
     */
    public List<Card> generateDefaultDeck() {
        List<Card> deck = new ArrayList<Card>();
        for (int i = 0; i < 52; i++) {
            deck.add(new Card(suits.get(i % 4),faces.get(i % 13)));
        }
        return deck;
    }


    /*
     * Shuffles the deck.
     * 
     * @param   deck        the deck that will be shuffled
     * @return  List<Card>  shuffled deck
     */
    public void shuffleDeck(List<Card> deck) {
        for (int i = 0; i < deck.size(); i++) {
            int randomCardNumber = random.nextInt(0,deck.size());
            Card temp = deck.get(i);
            deck.set(i, deck.get(randomCardNumber));
            deck.set(randomCardNumber,temp);
        }
    }


    /*
     * Deals cards from the main deck to side deck.
     * 
     * @param   mainDeck    the deck which cards will be drawn from
     * @param   sideDeck    the deck which cards will be added to
     * @param   count       number of cards to be drawn
     */
    public void dealCards(List<Card> mainDeck, List<Card> sideDeck, int count) {
        for (int i = 0; i < count; i++) {
            int size = mainDeck.size();
            sideDeck.add(mainDeck.get(size-1));
            mainDeck.remove(mainDeck.get(size-1));
        }
    }


    /*
     * Starts the blackjack game.
     */
    public void start() {
        boolean isYourRoundFinished = false;
        List<Card> deck = generateDefaultDeck();
        shuffleDeck(deck);
        List<Card> deckP1 = new ArrayList<>();
        List<Card> deckP2 = new ArrayList<>();
        int choice = -1;
        dealCards(deck, deckP1, 2);
        dealCards(deck, deckP2, 2);

        while(true) {
            int pointsP1 = 0;
            int pointsP2 = 0;

            System.out.println("Your cards: ");
            for (int i = 0; i < deckP1.size(); i++) {
                System.out.println(deckP1.get(i));
                pointsP1 += deckP1.get(i).getValue();
            }
            System.out.println("Your total points: " + pointsP1);
            System.out.println("------------------------");


            System.out.println("Opponent's cards: ");
            for (int i = 0; i < deckP2.size(); i++) {
                if (i == 0 && !isYourRoundFinished) {
                    System.out.println("???");
                } else {
                    System.out.println(deckP2.get(i));
                }
                pointsP2 += deckP2.get(i).getValue();
            }
            if (isYourRoundFinished) {
                System.out.println("Your opponent's points: " + pointsP2);
            } else {
                System.out.println("Your opponent's points: ???");
            }
            

            if (pointsP1 > 21 || pointsP2 == 21) {
                System.out.println("You lost!");
                System.out.println("Your total points: " + pointsP1);
                System.out.println("Your opponent's points: " + pointsP2);
                break;
            } else if (pointsP2 > 21 || pointsP1 == 21) {
                System.out.println("You won!");
                System.out.println("Your total points: " + pointsP1);
                System.out.println("Your opponent's points: " + pointsP2);
                break;
            } else if (pointsP1 == 21 && pointsP2 == 21) {
                System.out.println("Tie!");
                System.out.println("Your total points: " + pointsP1);
                System.out.println("Your opponent's points: " + pointsP2);
                break;
            }


            if (choice != 1) {
                System.out.println("1.Stand\n2.Hit\n");
                choice = scan.nextInt();
            }
            if (choice == 2) {
                dealCards(deck, deckP1, 1);
            }
            if (choice == 1) {
                isYourRoundFinished = true;
                if (pointsP1 < pointsP2) {
                    System.out.println("You lost!");
                    System.out.println("Your total points: " + pointsP1);
                    System.out.println("Your opponent's points: " + pointsP2);
                    break;
                } else if (pointsP1 == pointsP2 && pointsP2 <= 17) {
                    System.out.println("Tie!");
                    System.out.println("Your total points: " + pointsP1);
                    System.out.println("Your opponent's points: " + pointsP2);
                } else {
                    dealCards(deck, deckP2, 1);
                }
            }

        }  
    }


}