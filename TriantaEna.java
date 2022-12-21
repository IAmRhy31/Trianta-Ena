import java.util.*;

public class TriantaEna extends RoundInfo implements PlayerAction {  //main center for everything related Trianta Ena

    private final int maxPlayers = 9;
    private final int dealerValue = 27;
    private final int winningValue = 31;
    private final int defaultBalance = 100;
    private final int startCardNumber = 3;
    private List<Player> playerList;
    private Player dealer;
    private TEDeck deck;
    private TEWinner winner;
    private MessageStorage message;
    private final String[] choice = {"hit", "stand"};
    private int winVal = winningValue;
    private int dealerVal = dealerValue;
    private int balance = defaultBalance;
    private int player_count;

    public TriantaEna() {

        message = new MessageStorage();
        message.welcomeMessage();
        setGameParameters();
        setPlayerNumber();
        initGame();

    }

    public void begin() {

        System.out.println("\nGame begins!");
        while (!playerList.isEmpty()) {
            playRound();
            resetHands();
        }
        System.out.println("Game ends!");

    }

    public void playRound() {

        System.out.println("\n----------------------------\nRound: " + getRound() + "\n");

        for (Player player : playerList) {
            TEHand hand = player.getHand();
            TECard addCard = (TECard) deck.cardDeal();
            hand.insertCard(addCard);
        }

        TECard addCard = (TECard) deck.cardDeal();
        dealer.getHand().insertCard(addCard);

        for (Player player : playerList) {
            message.showPlayerHand(player.getId(), player.getHand());
            makeBet(player);
        }

        dealCards(startCardNumber - 1);
        playersPlay();
        dealerPlay();
        roundResults();
        allocateNewDealer();
        setRound(getRound() + 1);

    }

    private void setGameParameters() {

        Scanner sc = new Scanner(System.in);
        message.showDefaultParameters();
        String choice = sc.nextLine();

        if (!choice.equals("y") && !choice.equals("Y")) {
            System.out.println("The game will use default balance. Here We Go!");
            System.out.println();
            return;

        }
        
        setPlayerBalance();
        System.out.println("The game will use " + balance + " as balance");
        System.out.println();

    }

    private void setPlayerBalance() {

        message.showNewBalance();
        Scanner scanner = new Scanner(System.in);
        int balanceInput = getInteger(scanner.nextLine());

        if (balanceInput > 1) {
            this.balance = balanceInput;
        }

    }

    private void setPlayerNumber() {

        message.showNoOfPlayers(maxPlayers);
        Scanner scanner = new Scanner(System.in);
        boolean isPlayerValid = false;
        int countOfPlayers = -1;

        while (!isPlayerValid) {
            countOfPlayers = getInteger(scanner.nextLine());
            if (2 <= countOfPlayers && countOfPlayers <= maxPlayers) {
                System.out.println("The game will have " + countOfPlayers + " player(s) in the beginning.");
                isPlayerValid = true;
            } else {
                message.showInvalidMessage(2, maxPlayers);
            }
        }

        this.player_count = countOfPlayers;

    }

    private void initGame() {

        deck = new TEDeck();
        winner = new TEWinner(dealerVal, winVal);
        dealer = new Player(player_count, balance * 3);
        playerList = new ArrayList<>(player_count);

        for (int i = 1; i < player_count; i++)
            playerList.add(new Player(i, balance));

    }

    private void dealCards(int card_number) {

        for (int id = 0; id < card_number; id++) {
            for (Player player : playerList) {
                if (winner.isFold(player.getHand()))
                    continue;
                TEHand hand = player.getHand();
                TECard addCard = (TECard) deck.cardDeal();
                hand.insertCard(addCard);
            }

            TECard addCard = (TECard) deck.cardDeal();
            dealer.getHand().insertCard(addCard);

        }

    }

    private void playersPlay() {

        for (Player player : playerList) {
            System.out.println("\nPlayer " + player.getId() + " starts! 🏁");
            for (int i = 0; i < player.getCountOfHand(); i++) {

                TEHand hand = player.handAt(i);

                if (winner.isFold(hand)) {
                    System.out.println("Player " + player.getId() + " has decided to fold");
                    message.showPlayerHand(player.getId(), hand);
                    System.out.println("NEXT PLAYER");
                    continue;
                }

                message.showHandStatus(player.getId(), hand.getBet(), player.getBalance());
                message.showDealerCard(dealer.getFaceUpCard());

                if (winner.isItNaturalTriantaEna(hand)) {
                    message.showPlayerHand(player.getId(), hand);
                    System.out.println("VOILA 😯 Your current hand is a Natural Trianta Ena!!");
                    continue;
                }

                while (!winner.isBust(hand) && !winner.isItTriantaEna(hand)) {
                    message.showPlayerHand(player.getId(), hand);

                    String next_choice = getPlayerChoice(player, hand);
                    choiceExecute(player, next_choice, hand);
                    if (next_choice.equals("stand")) {
                        break;
                    }
                }

                message.showPlayerHand(player.getId(), hand);

                if (winner.isItTriantaEna(hand) && !winner.isItNaturalTriantaEna(hand)) {
                    System.out.println("WAY TO GO 👏 Your current hand is a Trianta Ena!");
                }

                if (winner.isBust(hand)) {
                    int faceId = i + 1;
                    System.out.println("Player " + player.getId() + "'s hand " + faceId + " is Bust!");
                }
            }
        }

        System.out.println("\nAll players' terms end!");

    }

    private int getInteger(String str) {

        try {
            int i = Integer.parseInt(str);
            return i;
        }
        catch (Exception e) {
            return -1;
        }

    }

    private String getPlayerChoice(Player player, TEHand hand) {

        Scanner sc = new Scanner(System.in);
        boolean isValid = false;
        int input = -1;

        while (!isValid) {
            message.showPlayerChoice(choice);
            input = getInteger(sc.nextLine());

            if (1 <= input && input <= choice.length && winner.isChoiceValid(player, hand, choice[input - 1])) {
                System.out.println("Your choice: " + choice[input - 1]);
                isValid = true;
            }
            else {
                message.showInvalidMessage(1, choice.length);
            }
        }

        return choice[input - 1];

    }

    private void choiceExecute(Player player, String choice, TEHand hand) {

        switch (choice) {
            case "hit":
                hit(deck, hand);
                break;
            case "stand":
                stand();
                break;
        }

    }

    private void dealerPlay() {

        System.out.println("\nNow, the Dealer starts! 🏁");

        TEHand dealerHand = dealer.getHand();

        message.showDealerHand(dealerHand);

        if (winner.isItNaturalTriantaEna(dealerHand)) {
            System.out.println("WOW! Dealer's current hand is a Natural Trianta Ena!! 😲");
        }

        while (winner.canDealerHit(dealer)) {
            hit(deck, dealer.getHand());
            System.out.println("Dealer hits");
            message.showDealerHand(dealerHand);
        }

        if (winner.isItTriantaEna(dealerHand) && !winner.isItNaturalTriantaEna(dealerHand)) {
            System.out.println("Congrats 🥳 Your current hand is a Trianta Ena!");
        }

        if (winner.isBust(dealerHand)) {
            System.out.println("Dealer's hand is Bust!");
        }

        System.out.println("\nDealer's term ends!\n");

    }

    private void roundResults() {

        List<Player> toRemove = new ArrayList<>();

        for (Player player : playerList) {
            if (!winner.isFold(player.getHand())) {
                int roundBalance = winner.checkWinner(player, dealer);
                message.showPlayerBalance(player.getId(), roundBalance, player.getBalance(), getRound());
            }
            else {
                System.out.println("At round " + getRound() + ", Player " + player.getId() + " chose to fold");
                System.out.println("Player" + player.getId() + " has balance of " + player.getBalance());
            }
            if (player.getBalance() == 0) {
                message.playerExit(player);
                toRemove.add(player);
            }
            else if (cashOut(player)) {
                message.playerExit(player);
                toRemove.add(player);
            }
        }

        message.showDealerBalance(dealer.getId(), dealer.getBalance(), getRound());

        for (Player player : toRemove) {
            playerList.remove(player);
        }

    }

    private void allocateNewDealer() {

        if (dealer.getBalance() <= 0) {
            System.out.println("dealer " + dealer.getId() + " has no balance and leaves the game.\n");

            if (playerList.size() <= 1) { // if only one player left, game ends
                System.out.println("Only one player is left");
                playerList.clear();
                return;
            }

            TreeMap<Integer, Integer> sortedBalanceMap = new TreeMap<>(Collections.reverseOrder()); //TreeMap sorts the keys in descending order

            for (Player player : playerList) {
                sortedBalanceMap.put(player.getBalance(), player.getId());
            }

            int highestBalancePlayer = sortedBalanceMap.firstEntry().getValue();

            for (Player player : playerList) {
                if (player.getId() == highestBalancePlayer) {
                    dealer = player;
                    playerList.remove(player);
                    System.out.println("Player " + highestBalancePlayer + " has the highest default balance and is now the new dealer!");
                    System.out.println();
                    return;
                }
            }
        }

        TreeMap<Integer, Integer> sortedBalanceMap = new TreeMap<>(Collections.reverseOrder()); //check and ask a player to become a new dealer
        int count = 0;

        for (Player player : playerList) {
            sortedBalanceMap.put(player.getBalance(), player.getId());
        }

        for (Map.Entry<Integer, Integer> entry : sortedBalanceMap.entrySet()) {
            Scanner sc = new Scanner(System.in);
            Integer defaultBalance = entry.getKey();
            Integer player_id = entry.getValue();

            if (++count == 1 && defaultBalance <= dealer.getBalance()) {
                System.out.println("No one is eligible to become the new dealer");
                return;
            }

            if (balance <= dealer.getBalance()) {
                System.out.println("Dealer remains the same");
                return;
            }

            System.out.println("Player " + player_id + "'s balance = $" + defaultBalance +
                    " now exceeds that of the dealer.");
            System.out.println("If you want to become the dealer, please enter Y to become the new dealer OR enter any other key to decline");
            String choice = sc.nextLine();

            if (!choice.equals("y") && !choice.equals("Y")) {
                System.out.println("Player " + player_id + " did not become the dealer\n");
            }
            else {
                System.out.println("Player " + player_id + " is now the new dealer!\n");
                System.out.println("dealer " + dealer.getId() + " now becomes Player " + dealer.getId() + "!\n");
                playerList.add(dealer);
                for (Player player : playerList) {
                    if (player.getId() == player_id) {
                        dealer = player;
                        playerList.remove(player);
                        return;
                    }
                }
            }
        }

    }

    private void resetHands() {

        dealer.clearHands();
        dealer.insertHand(new TEHand());

        for (Player player : playerList) {
            player.clearHands();
            player.insertHand(new TEHand());
        }

    }

    @Override
    public void hit(TEDeck deck, TEHand hand) {

        TECard addCard = (TECard) deck.cardDeal();
        hand.insertCard(addCard);

    }

    @Override
    public void stand() {

        return;

    }

    @Override
    public void makeBet(Player player) {

        Scanner sc = new Scanner(System.in);
        int input;
        boolean isValid = false;
        System.out.println("Current balance of the player " + player.getId() + " is: " + player.getBalance());
        System.out.println("Player " + player.getId() + ", please enter an integer between 1 to " + player.getBalance() + " as bet 💶");
        System.out.println("Enter 0 if you decide to fold");

        while (!isValid) {
            input = getInteger(sc.nextLine());
            System.out.println();
            if (input >= 0 && input <= player.getBalance()) {
                isValid = true;
                player.handAt(0).setBet(input);
                player.setBalance(-input);
            }
            else {
                System.out.println("OOPS! Invalid input. Please enter an integer between 0 and " + player.getBalance() + " as bet: ");
            }
        }

    }

    @Override
    public boolean cashOut(Player player) {

        Scanner scanner = new Scanner(System.in);
        boolean isCashOut = false;
        System.out.println("Player " + player.getId() + ", do you want to cash out?");
        System.out.println("Enter 'Y' for yes OR press any other key for no");
        String choice = scanner.nextLine();
        System.out.println();

        if (choice.equals("y") || choice.equals("Y")) {
            isCashOut = true;
        }

        return isCashOut;
    }

}