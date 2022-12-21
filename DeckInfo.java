import java.util.*;

public abstract class DeckInfo <A extends CardInfo> { //this class acts as an information center for a deck of cards

    private List<A> cards;
    private int card_count;

    public DeckInfo() {

        card_count = 52; //number of cards in a deck
        deckCreate();
        shuffle();

    }

    public List<A> getCards() {

        return cards;

    }

    public void setCards(List<A> cards) {

        this.cards = cards;

    }

    public int getCountOfCard() {

        return card_count;

    }

    public void setCountOfCard(int num) {

        card_count = card_count + num;

    }

    abstract void deckCreate();

    public void shuffle() {

        Collections.shuffle(cards);

    }

    public A cardDeal() {

        if (getCountOfCard() == 0) {
            deckCreate();
            shuffle();
            setCountOfCard(52);
        }

        setCountOfCard(-1);
        return cards.remove(0);
    }

}