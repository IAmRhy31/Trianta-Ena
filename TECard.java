public class TECard extends CardInfo { //mainly for getting Hard Value or Soft Value

    public TECard(String suit, int value) {

        super(suit, value);

    }

    public int getHardValue() { //10 for face card, 11 for Ace card

        return getValue();

    }

    public int getSoftValue() { //10 for face card, 1 for Ace card

        return getValue();

    }

}