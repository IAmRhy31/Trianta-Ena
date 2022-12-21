public class AceCard extends TECard { //handles ace card values: 1 or 11

    public AceCard(String suit, int value) {

        super(suit, value);

    }

    public AceCard(String suit) {

        super(suit, 1);

    }

    @Override
    public int getHardValue() {

        return 11;

    }

    @Override
    public int getSoftValue() {

        return 1;

    }

    @Override
    public String toString() {

        return getSuit() + " A";

    }

}