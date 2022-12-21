# CS611 - Assignment 2
## Trianta Ena (Card Game Infrastructure)
---------------------------------------------------------------------------
Rhythm Deven Somaiya
rhythm@bu.edu
U84158310

## Files
---------------------------------------------------------------------------
- StartGame.java: This is the main class where our game begins.

- MessageStorage.java: This class acts as storage to display messages to the players.

- RoundInfo.java: This class is related to information about rounds.

- CardInfo.java: This class acts as an information center for a suit and its value.

- DeckInfo.java: This class acts as an information center for a deck of cards.

- CardHANDler.java: This class is for cards currently in the hand.

- PlayerStatus.java: This class is for getting the status of the player and handling other tasks such as assigning id, adding a hand, etc.

- Player.java: This class is mainly for the Player class for handling balance, cash, etc.

- TECard.java: This class is mainly for getting Hard Value or Soft Value.

- AceCard.java: This class handles ace card values: 1 or 11.

- FaceCard.java: This class handles face card values.

- TEDeck.java: This class handles cards in a deck.

- TEHand.java: This class is related to the hand and to get the total value.

- Winner.java: This class is to check the winner: player(s) or dealer/banker.

- TEWinner.java: This class handles everything related to finding a winner, outstanding balance of players, etc.

- PlayerAction.java: It's an interface for everything regarding the player's decision and choice.

- TriantaEna.java: This class is the main center for everything related to our game: Trianta Ena.

## Notes
---------------------------------------------------------------------------
1. The majority of common game test cases are working but some might not be tested.
2. The UML diagram is a separate .png file and I couldn't attach it in the design documentation pdf because the diagram is too big and would have been not easy to see/refer.

## How to compile and run
---------------------------------------------------------------------------
A. Compile and Run in an IDE (eg. IntelliJ):
1) Create a new java project and add the above .java classes files in the "/src" folder of your created project.
2) Goto "StartGame.java" and click the "Run" button (Ctrl + R) to run this project.

B. Run in the Terminal (Mac):
1) cd towards the directory/folder where you have saved this project (after unzipping) in your Mac and press "Enter"
2) Type "javac StartGame.java" and press "Enter"
3) Type "java StartGame" and press "Enter"

## Input/Output Example
---------------------------------------------------------------------------
Hello Friends 👋 Welcome to TRIANTA ENA: Go Big or Go Bust!

Note that the default balance for each player is 100 (so for the dealer would be 300)
Enter Y to change the default balance OR any other key to stay with the default balance of 100
Input: N
The game will use default balance. Here We Go!

❗️Before we start, the maximum number of players allowed (including the dealer/banker) are 9
Please enter an integer between 2 and 9 for your desired number of players
Input: 3
The game will have 3 player(s) in the beginning.

Game begins!

----------------------------
Round: 1

Player 1's current hand is: Heart 9
Player 1's current hand has value of: 9
Current balance of the player 1 is: 100
Player 1, please enter an integer between 1 to 100 as bet 💶
Enter 0 if you decide to fold
Input: 50

Player 2's current hand is: Spade 10
Player 2's current hand has value of: 10
Current balance of the player 2 is: 100
Player 2, please enter an integer between 1 to 100 as bet 💶
Enter 0 if you decide to fold
Input: 75


Player 1 starts! 🏁
Player 1, Bet for this hand = $50, Balance = $50
Dealer's face-up card is: Diamond 8
Player 1's current hand is: Heart 9, Diamond 5, Heart 7
Player 1's current hand has value of: 21
Select your next move with its respective number
For hit: enter 1	For stand: enter 2	
Input: 1
Your choice: hit
Player 1's current hand is: Heart 9, Diamond 5, Heart 7, Spade K
Player 1's current hand has value of: 31
WAY TO GO 👏 Your current hand is a Trianta Ena!

Player 2 starts! 🏁
Player 2, Bet for this hand = $75, Balance = $25
Dealer's face-up card is: Diamond 8
Player 2's current hand is: Spade 10, Heart J, Diamond J
Player 2's current hand has value of: 30
Select your next move with its respective number
For hit: enter 1	For stand: enter 2	
Input: 2
Your choice: stand
Player 2's current hand is: Spade 10, Heart J, Diamond J
Player 2's current hand has value of: 30

All players' terms end!

Now, the Dealer starts! 🏁
Dealer's current hand is: Club 4, Diamond 8, Spade 5
Dealer's current hand has value of: 17

Dealer hits
Dealer's current hand is: Club 4, Diamond 8, Spade 5, Spade 4
Dealer's current hand has value of: 21

Dealer hits
Dealer's current hand is: Club 4, Diamond 8, Spade 5, Spade 4, Club J
Dealer's current hand has value of: 31

Congrats 🥳 Your current hand is a Trianta Ena!

Dealer's term ends!

At round 1, Player 1 loses $50 🙁
Player 1's current balance is $50
Player 1, do you want to cash out?
Enter 'Y' for yes OR press any other key for no
Input: N

At round 1, Player 2 loses $75 🙁
Player 2's current balance is $25
Player 2, do you want to cash out?
Enter 'Y' for yes OR press any other key for no
Input: N

At round 1, Dealer 3 has balance of $425

No one is eligible to become the new dealer

----------------------------
Round: 2

Player 1's current hand is: Diamond 4
Player 1's current hand has value of: 4
Current balance of the player 1 is: 50
Player 1, please enter an integer between 1 to 50 as bet 💶
Enter 0 if you decide to fold
Input: 25

Player 2's current hand is: Club 9
Player 2's current hand has value of: 9
Current balance of the player 2 is: 25
Player 2, please enter an integer between 1 to 25 as bet 💶
Enter 0 if you decide to fold
Input: 20


Player 1 starts! 🏁
Player 1, Bet for this hand = $25, Balance = $25
Dealer's face-up card is: Heart 10
Player 1's current hand is: Diamond 4, Diamond 6, Diamond 2
Player 1's current hand has value of: 12
Select your next move with its respective number
For hit: enter 1	For stand: enter 2	
Input: 1
Your choice: hit
Player 1's current hand is: Diamond 4, Diamond 6, Diamond 2, Spade 7
Player 1's current hand has value of: 19
Select your next move with its respective number
For hit: enter 1	For stand: enter 2	
Input: 1
Your choice: hit
Player 1's current hand is: Diamond 4, Diamond 6, Diamond 2, Spade 7, Heart 8
Player 1's current hand has value of: 27
Select your next move with its respective number
For hit: enter 1	For stand: enter 2	
Input: 2
Your choice: stand
Player 1's current hand is: Diamond 4, Diamond 6, Diamond 2, Spade 7, Heart 8
Player 1's current hand has value of: 27

Player 2 starts! 🏁
Player 2, Bet for this hand = $20, Balance = $5
Dealer's face-up card is: Heart 10
Player 2's current hand is: Club 9, Diamond K, Club Q
Player 2's current hand has value of: 29
Select your next move with its respective number
For hit: enter 1	For stand: enter 2	
Input: 2
Your choice: stand
Player 2's current hand is: Club 9, Diamond K, Club Q
Player 2's current hand has value of: 29

All players' terms end!

Now, the Dealer starts! 🏁
Dealer's current hand is: Club 8, Heart 10, Heart 2
Dealer's current hand has value of: 20

Dealer hits
Dealer's current hand is: Club 8, Heart 10, Heart 2, Spade J
Dealer's current hand has value of: 30


Dealer's term ends!

At round 2, Player 1 loses $25 🙁
Player 1's current balance is $25
Player 1, do you want to cash out?
Enter 'Y' for yes OR press any other key for no
Input: N

At round 2, Player 2 loses $20 🙁
Player 2's current balance is $5
Player 2, do you want to cash out?
Enter 'Y' for yes OR press any other key for no
Input: Y

Player 2 exits the game with $5

At round 2, Dealer 3 has balance of $470

No one is eligible to become the new dealer

----------------------------
Round: 3

Player 1's current hand is: Club 3
Player 1's current hand has value of: 3
Current balance of the player 1 is: 25
Player 1, please enter an integer between 1 to 25 as bet 💶
Enter 0 if you decide to fold
Input: 25


Player 1 starts! 🏁
Player 1, Bet for this hand = $25, Balance = $0
Dealer's face-up card is: Diamond 10
Player 1's current hand is: Club 3, Club K, Heart 4
Player 1's current hand has value of: 17
Select your next move with its respective number
For hit: enter 1	For stand: enter 2	
Input: 1
Your choice: hit
Player 1's current hand is: Club 3, Club K, Heart 4, Spade 3
Player 1's current hand has value of: 20
Select your next move with its respective number
For hit: enter 1	For stand: enter 2	
Input: 1
Your choice: hit
Player 1's current hand is: Club 3, Club K, Heart 4, Spade 3, Heart 5
Player 1's current hand has value of: 25
Select your next move with its respective number
For hit: enter 1	For stand: enter 2	
Input: 2
Your choice: stand
Player 1's current hand is: Club 3, Club K, Heart 4, Spade 3, Heart 5
Player 1's current hand has value of: 25

All players' terms end!

Now, the Dealer starts! 🏁
Dealer's current hand is: Heart A, Diamond 10, Club A
Dealer's current hand has value of: 22

Dealer hits
Dealer's current hand is: Heart A, Diamond 10, Club A, Spade 9
Dealer's current hand has value of: 31

Congrats 🥳 Your current hand is a Trianta Ena!

Dealer's term ends!

At round 3, Player 1 loses $25 🙁
Player 1's current balance is $0
Player 1 exits the game with $0

At round 3, Dealer 3 has balance of $495

Game ends!



