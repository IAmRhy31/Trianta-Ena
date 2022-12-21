public class Player extends PlayerStatus { //mainly for Player class for handling balance, cash, etc.

    private int balance;

    public Player(int id, int balance) {

        super(id);
        this.balance = balance;
        insertHand(new TEHand());

    }

    public Player(Player p) {

        this.balance = p.balance;
        super.setId(p.getId());

    }

    public int getBalance() {

        return balance;

    }

    public void setBalance(int currency) {

        balance += currency;

    }

    public int getCountOfHand() {

        return getHands().size();

    }

    public TEHand handAt(int id) {

        return (TEHand) getHands().get(id);

    }

    public TEHand getHand() {

        return (TEHand) getHands().get(0);

    }

    public TECard getFaceUpCard() {

        return ((TEHand) getHands().get(0)).cardAt(1);

    }

}