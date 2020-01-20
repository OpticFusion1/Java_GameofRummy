
public class Game{

  //instance variables
  private Deck main;
  private Die dice;
  private Deck hand;
  private Utils help;
  //constructor
  public Game(int rank){
    this.main = new Deck(rank);
    this.dice = new Die();
  }
  //this function follows the logic of the rummy game it creates and shuffles a deck then it deals 7 cards followed by rolling of a die.
  //based on what the user rolls they make melds(2-6) or they discard a card(1). this repeats until they run out of cards in their hand
  public void play(){
    //shuffling the initialized deck from constructor
    main.shuffle();
    hand = main.deal(8);
    int roundNum = 0;
    //game runs in this loop
    while(hand.size()>0){
      System.out.println("This is your hand printed in two ways (First line is by suit, second line is by ranks). \nDiamond = 0, Club = 1, Heart = 2, Spade = 3");
      hand.print();
      dice.roll();
      int rollNum = dice.getValue();
      System.out.println("rolling the dice.....");
      System.out.println();
      System.out.println(dice.toString());
      if (main.size() == 0){
        rollNum = 1;
        System.out.println("The deck is out of cards. You will only roll 1");
      }
      //if 1 is rolled then the user discards a card if the card is in the hand discard the card if the card is not in the hand reprompt user and restart loop.
      if (rollNum == 1){
        boolean discarded = false;
        while (discarded == false){
          System.out.println("You rolled a 1, which card would you like to discard? ");
          System.out.println("If you enter an invalid card you will be reprompted");
          System.out.println();
          Card discard = help.readCard();
          discarded = hand.remove(discard);
        }
        System.out.println("This is your new hand");
        System.out.println(hand.toString());
        System.out.println("Round " +roundNum+ " is Over");
        roundNum++;
      }
      // if 2-6 is rolled add 2-6 cards from main deck to hand and ask users to make melds
      else{
      	if (main.size() == 0){
      		System.out.println("This Deck is out of cards");
      	}
      	else{
        	Deck addtohand = main.deal(rollNum+1);
        	System.out.println("This is your new hand");
        	hand.addAll(addtohand);
    	}
        hand.print();
        boolean value = help.readYesOrNo("Would you like to enter a meld yes or no? ");
        //While user wants to make melds
        while(value){
          Deck melds = help.readCards("Enter the cards that forms a meld. If your meld is not valid you will be reprompted.\n(Say yes if you want to enter a meld, no otherwise)");
            //if the meld is a kind meld or a seq meld and hand contains all meld cards then remove melds from hand else redo loop.
          if ((melds.isKind() || melds.isSeq()) && hand.containsAll(melds)){
            hand.removeAll(melds);
            }
          else{
            System.out.println("You have entered a invalid meld try again");
          }
          value = help.readYesOrNo("Would you like to enter a meld yes or no? ");
        }

        System.out.println("This is your new hand");
        System.out.println(hand.toString());
        System.out.println("Round " +roundNum+ " is Over");
        roundNum++;
    }
          }
    //congrats message
    System.out.println("You completed the game in "+ roundNum+" rounds!");
        }
      }
