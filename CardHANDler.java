import java.util.*;

public class CardHANDler <B extends CardInfo> { //class for cards currently in the hand

    private List<B> cards;

    public CardHANDler() {

        cards = new ArrayList<B>();

    }

    public CardHANDler(B card) {

        cards = new ArrayList<B>();
        cards.add(card);

    }

    public List<B> getHand() {

        return cards;

    }

    public void setHand(CardHANDler<B> hand) {

        this.cards = new ArrayList<>();
        this.cards.add(hand.cardAt(0));

    }

    public void clearHand() {

        cards.clear();

    }

    public void insertCard(B card) {

        cards.add(card);

    }

    public void removeCard(B card) {

        cards.remove(card);

    }

    public int getCountOfCard() {

        return cards.size();

    }

    public B cardAt(int id) {

        return cards.get(id);

    }

    @Override
    public String toString() {

        String result = "";
        for (int i = 0; i < cards.size(); i++) {
            result = result + cards.get(i);
            if (i != cards.size() - 1) {
                result = result + ", ";
            }
        }

        return result;

    }

}