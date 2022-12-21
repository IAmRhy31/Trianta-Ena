public abstract class RoundInfo { //this class is related to the information about rounds

    private int round;

    public RoundInfo() {

        this.round = 1;

    }

    abstract void begin();

    int getRound() {

        return round;

    }

    void setRound(int round) {

        this.round = round;

    }

    abstract void playRound();

}