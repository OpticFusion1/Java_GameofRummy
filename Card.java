

public class Card{
// constant declarations
public static final int DIAMOND = 0;
public static final int CLUB = 1;
public static final int HEART = 2;
public static final int SPADE = 3;
//declaration of instance variables
private int suit = 0;
private int rank = 0;
// constructor
public Card(int suit, int rank){
  this.suit = suit;
  this.rank = rank;
}
//method returns value of the suit
public int getSuit(){
  return suit;
}
//method returns value of the rank
public int getRank(){
  return rank;
}
//method equals returns true if the cards have the same value and false if the other object is not of class card or not the same {suit,rank}
public boolean equals(Object object) {
    if (! (object instanceof Card)) {
        return false;
    }
    //creating an object of type card and setting it to be a type cast of object
    Card other;
    other = (Card) object;
    //if the rank and suit of other matches this cards rank and suit then return true otherwise false
    if((other.suit == this.suit)&&(other.rank == this.rank)){
      return true;
    }
    else{
      return false;
    }
}
//returns the suit and ranked in string representation {suit,rank}
public String toString(){
  String result;
  result = "{"+suit+","+rank+"}";
  return result;
}
}
