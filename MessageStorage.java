//following the similar storage for messages architecture from my Assignment 1 game(s)
public class MessageStorage { //this class acts as storage to display messages to the players

    public void welcomeMessage() { 

        System.out.println("\nHello Friends 👋 Welcome to TRIANTA ENA: Go Big or Go Bust!");
        System.out.println();

    }

    public void showDefaultParameters() { 

        System.out.println("Note that the default balance for each player is 100 (so for the dealer would be 300)");
        System.out.println("Enter Y to change the default balance OR any other key to stay with the default balance of 100");

    }

    public void showNewBalance() { 

        System.out.println("Enter new balance for the player (greater than 1) OR any other key to stay with the default balance of 100");

    }

    public void showNoOfPlayers(int max_player) { 

        System.out.println("❗️Before we start, the maximum number of players allowed (including the dealer/banker) are " + max_player);
        System.out.println("Please enter an integer between 2 and " + max_player + " for your desired number of players");

    }

    public void showInvalidMessage(int min_number, int max_number) { 

        System.out.println("OOPS! Invalid input. Please enter a integer between " + min_number + " and " + max_number);

    }

    public void showHandStatus(int playerId, int bet, int playerBalance) {

        System.out.println("Player " + playerId + ", Bet for this hand = $" + bet + ", Balance = $" + playerBalance );
        
    }

    public void showDealerCard(TECard card) { 

        System.out.println("Dealer's face-up card is: " + card);

    }

    public void showDealerHand(TEHand hand) { 

        System.out.println("Dealer's current hand is: " + hand);
        System.out.println("Dealer's current hand has value of: " + hand.getTotalValue());
        System.out.println();

    }

    public void showPlayerHand(int playerId, TEHand hand) { 

        System.out.println("Player " + playerId + "'s current hand is: " + hand);
        System.out.println("Player " + playerId + "'s current hand has value of: " + hand.getTotalValue());

    }

    public void showPlayerChoice(String[] choices) {

        System.out.println("Select your next move with its respective number");

        int id = 1;
        for (String choice : choices) {
            System.out.print("For " + choice + ": enter " + id++ + "\t");
        }

        System.out.println();

    }

    public void showPlayerBalance(int playerId, int roundBalance, int playerBalance, int roundNum) { 

        if (roundBalance > 0)
            System.out.println("At round " + roundNum + ", Player " + playerId + " wins $" + roundBalance + " 🥳");
        else if (roundBalance == 0)
            System.out.println("At round " + roundNum + ", Player " + playerId + " is a tie! 🤯");
        else
            System.out.println("At round " + roundNum + ", Player " + playerId + " loses $" + -roundBalance + " 🙁");

        System.out.println("Player " + playerId + "'s current balance is $" + playerBalance);

    }

    public void showDealerBalance(int playerId, int balance, int roundNum) { 

        System.out.println("At round " + roundNum + ", Dealer " + playerId + " has balance of $" + balance + "\n");

    }

    public void playerExit(Player player) { 

        System.out.println("Player " + player.getId() + " exits the game with $" + player.getBalance());
        System.out.println();

    }

}