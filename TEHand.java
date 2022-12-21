public class TEHand extends CardHANDler <TECard> {  //related everything related in the hand and get the total value

    private int bet;
    private int hard_value = 10;
    private int win_value = 31;

    public TEHand() {

        super();

    }

    public TEHand(TECard card) {

        super(card);

    }

    public int getBet() {

        return bet;

    }

    public void setBet(int newBet) {

        bet = newBet;

    }
    
    public int getTotalValue() {

        int ace_count = 0;
        int value = 0;
        int card_count = getCountOfCard();

        for (int i = 0; i < card_count; i++) {
            TECard card = (TECard) cardAt(i);
            int soft_value = card.getSoftValue();
            value += soft_value;

            if (card.getHardValue() == hard_value + 1) {
                ace_count += 1;
            }

        }

        if (ace_count == 1) { //pick a hard value or soft value if there is only one ace card
            if (value + hard_value <= win_value) {
                value += hard_value;
            }
            else if (value + hard_value > win_value && value + 1 <= win_value) {
                value += 1;
            }
            else {
                value += hard_value;
            }
        }

        while (ace_count > 1) {
            value += hard_value;
            ace_count -= 1;
        }

        return value;
    }

}