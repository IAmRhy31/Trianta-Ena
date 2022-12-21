public class TEWinner extends Winner <Player, Player> { //class to handle everything related to find a winner, outstanding balance of players, etc.

    private int dealer_value;
    private int win_value;
    private int startCardNumber = 3;
    private int faceCardMaxValue = 11;

    public TEWinner(int dealer_value, int win_value) {
        
        this.dealer_value = dealer_value;
        this.win_value = win_value;
        
    }

    public int getDealerValue() {
        
        return dealer_value;
        
    }

    public void setDealerValue(int dealer_value) {
        
        this.dealer_value = dealer_value;
        
    }

    public int getWinValue() {
        
        return win_value;
        
    }

    public void setWinValue(int win_value) {
        
        this.win_value = win_value;
        
    }

    public boolean isChoiceValid(Player player, TEHand hand, String choice) {

        switch (choice) {
            case "hit":
                return !isBust(hand);
        }

        return true;

    }

    public boolean isBust(TEHand hand) {

        return hand.getTotalValue() > this.win_value;

    }

    public boolean isFold(TEHand hand) {

        return hand.getBet() == 0;

    }

    private boolean isEnoughBalance(Player player, int bet) {

        return player.getBalance() - bet >= 0;

    }

    public boolean canDealerHit(Player dealer) {

        return dealer.getHand().getTotalValue() < dealer_value;

    }

    public boolean isItTriantaEna(TEHand hand) {

        return hand.getTotalValue() == this.win_value;

    }

    public boolean isItNaturalTriantaEna(TEHand hand) {

        if (hand.getCountOfCard() != startCardNumber)
            return false;

        int aceCardCount = 0;
        int faceCardCount = 0;

        for (TECard card : hand.getHand()) {
            if (card.getValue() == 1) {
                aceCardCount++;
            }
            else if (card.getValue() >= faceCardMaxValue) {
                faceCardCount++;
            }
        }

        return aceCardCount == 1 && faceCardCount == 2;

    }

    public int checkWinner(Player player, Player dealer) {

        TEHand dealerHand = dealer.getHand();
        int dealer_value = dealerHand.getTotalValue();
        int round_balance = 0;

        if (isBust(dealerHand)) {
            for (int i = 0; i < player.getCountOfHand(); i++) { // if the dealer is bust
                TEHand playerHand = player.handAt(i);
                int bet = playerHand.getBet();
                if (!isBust(playerHand)) {
                    player.setBalance(bet * 2);
                    round_balance += playerHand.getBet();
                    dealer.setBalance(-bet);
                } else {
                    round_balance -= playerHand.getBet();
                    dealer.setBalance(bet);
                }
            }
        }
        else {
            for (int i = 0; i < player.getCountOfHand(); i++) { // if the dealer doesn't bust

                TEHand playerHand = player.handAt(i);
                int value = playerHand.getTotalValue();
                int bet = playerHand.getBet();

                if (isBust(playerHand)) {
                    round_balance -= bet;
                    dealer.setBalance(bet);
                } else {
                    if (value < dealer_value) {
                        round_balance -= bet;
                        dealer.setBalance(bet);
                    } else if (value == dealer_value) {
                        if (isItNaturalTriantaEna(dealerHand) && isItNaturalTriantaEna(playerHand)) {
                            dealer.setBalance(bet);
                            round_balance -= bet;
                        } else if (isItNaturalTriantaEna(dealerHand) && !isItTriantaEna(playerHand)) {
                            dealer.setBalance(bet);
                            round_balance -= bet;
                        } else if (isItTriantaEna(dealerHand) && isItNaturalTriantaEna(playerHand)) {
                            player.setBalance(bet * 2);
                            round_balance += bet;
                            dealer.setBalance(-bet);
                        } else {
                            dealer.setBalance(bet); // if it is tied, player loses
                            round_balance -= bet;
                        }
                    } else {
                        player.setBalance(bet * 2); // if player hand value > dealer hand value, player hand wins
                        round_balance += bet;
                        dealer.setBalance(-bet);
                    }
                }
            }
        }

        return round_balance;

    }
    
}