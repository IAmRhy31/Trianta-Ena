public class FaceCard extends TECard { //handles face card values

    public FaceCard(String suit, int value) {

        super(suit, value);

    }

    @Override
    public int getHardValue() {

        return 10;

    }

    @Override
    public int getSoftValue() {

        return 10;

    }

    @Override
    public String toString() { //ToString

        String rank;
        switch (getValue()) {
            case 11:
                rank = "J";
                break;
            case 12:
                rank = "Q";
                break;
            default:
                rank = "K";
        }

        return getSuit() + " " + rank;

    }

}