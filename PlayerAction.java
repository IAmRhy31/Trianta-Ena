//following the similar player-action architecture from my Assignment 1 game(s)
public interface PlayerAction { //interface for everything regarding player's decision and choice

    void hit(TEDeck deck, TEHand hand);

    void stand();

    void makeBet(Player player);

    boolean cashOut(Player player);

}