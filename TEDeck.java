import java.util.*;

public class TEDeck extends DeckInfo { //handles cards in a deck

    public void deckCreate() {

        List<TECard> cards = new ArrayList<TECard>();
        String[] suits = new String[]{"Spade", "Heart", "Club", "Diamond"};

        for (String suit : suits) {
            cards.add(new AceCard(suit));

            for (int i = 2; i <= 10; i++) {
                cards.add(new TECard(suit, i));
            }

            for (int i = 11; i <= 13; i++) {
                cards.add(new FaceCard(suit, i));
            }

        }

        setCards(cards);

    }

}