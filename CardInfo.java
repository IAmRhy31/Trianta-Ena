public class CardInfo { //this class acts as an information center for suit and its value

    private String suit;
    private int value;

    public CardInfo(String suit, int value) {

        this.suit = suit;
        this.value = value;

    }

    public int getValue() {

        return value;

    }

    public String getSuit() {

        return suit;

    }

    //returns in a string format to display the two parameters: suit and value
    @Override
    public String toString() { //toString

        return getSuit() + " " + getValue();

    }

}