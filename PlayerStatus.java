import java.util.*;

public class PlayerStatus <A extends CardHANDler> { //class for getting the status of the player and to handle other tasks such as assigning id, adding hand, etc.

    private int id;

    private List<A> hands;

    public PlayerStatus() {

        hands = new ArrayList<A>();

    }

    public PlayerStatus(int id) {

        this.id = id;
        hands = new ArrayList<A>();

    }

    public int getId() {

        return id;

    }

    public void setId(int id) {

        this.id = id;

    }

    public List<A> getHands() {

        return hands;

    }

    public void clearHands() {

        hands = new ArrayList<A>();

    }

    public void insertHand(A hand) {

        hands.add(hand);

    }

}