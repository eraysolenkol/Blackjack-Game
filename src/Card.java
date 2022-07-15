package src;

public class Card {
    private String face;
    private String suit;
    private int value;
    

    /*
     * Constructor for the Card
     */
    public Card(String suit, String face) {
        this.face = face;
        this.suit = suit;
        this.value = valueOfCard(this);
    }

    /* 
     * Gets the card and returns the value of it.
     * 
     * @param  card  Card to check value of it.
     * @return       the value of the card
     */
    public int valueOfCard(Card card) {
        if (card.face.matches("[2-9]|10")) {
            return Integer.valueOf(card.face);
        } else if (card.face.equals("A")) {
            return 11;
        }
        return 10;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return suit + " " + face;
    }


}