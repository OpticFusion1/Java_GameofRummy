
import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private ArrayList<Card> cards;
    /**
    * A constructor for the class <code>Deck</code>. It creates the initial
    * <code>ArrayList</code> that will be used to store the cards of Otherwise
    * deck.
    */
    public Deck() {
        cards = new ArrayList<Card>();
    }
    /**
    * A constructor for the class <code>Deck</code>. It creates the initial
    * <code>ArrayList</code> that will be used to store the cards of Otherwise
    * deck. The parameter specifies the number of ranks for the cards. Finally,
    * it also initializes this deck to contain 4 x n cards, where n is the value
    * of the parameter.
    *
    * @param range the number of ranks for the cards
    */
    public Deck(int range) {
      cards = new ArrayList<Card>();
      for(int i=0; i < 4; i++){
        for(int j=1; j < range+1; j++){
          cards.add(new Card(i,j));
        }
      }
    }
    //method returns size of the ArrayList
    public int size(){
      return cards.size();
    }
    //if the size of the Arraylist card is greater than or equal to 1 return true else false
    public boolean hasCards(){
      if(cards.size()>= 1){
        return true;
      }
      else{
        return false;
      }
    }
    //returns the value of the card at the position pos by using the built in get function in class ArrayList
    public Card get(int pos){
      return cards.get(pos);
    }
    //returns nothing but adds a card to the end of the ArrayList
    public void add(Card card){
      cards.add(card);
    }
    //using the built in addAll function of class ArrayList to all of the elements in Arraylist other to cards it then removes all elements from other using clear
    public void addAll(Deck other){
      cards.addAll(other.cards);
      other.cards.clear();
    }
    //returns the last card of the deck and removes the card from the deck
    public Card removeLast(){
      Card result = cards.get(cards.size()-1);
      cards.remove(cards.size()-1);
      return result;
    }
    //returns the first card of the deck then removes the card from deck
    public Card removeFirst(){
      Card result = cards.get(0);
      cards.remove(0);
      return result;
    }
    //returns true only if there is an occurance of card in the ArrayList otherwise false if occurance is found it is removed
    public boolean remove(Card card){
      boolean value = false;
      for(int k = 0; k < cards.size(); k++){
        if(cards.get(k).equals(card)){
          cards.remove(k);
          value = true;
          break;
        }
        }
        return value;
      }
    //returns nothing removes all cards from the deck that is in other
    public void removeAll(Deck other){
      cards.removeAll(other.cards);
    }
    //using the built in shuffle function shuffle() shuffles the ArrayList
    public void shuffle(){
      Collections.shuffle(cards);
    }
    //returns a new deck containing the last n cards of the arraylist cards
    public Deck deal(int n){
      Deck tempdeck = new Deck();
      for (int l = 1; l < n; l++ ){
        if(cards.size() != 0){
          tempdeck.cards.add(cards.get(cards.size()-1));
          cards.remove(cards.size()-1);
        }
        else{
          break;
        }
      }
      return tempdeck;
    }
    // similar to remove(), checks whether the card is contained within arraylist cards
    public boolean contains(Card card){
      boolean value = false;
      for(int m = 0; m < cards.size(); m++){
        if(cards.get(m).equals(card)){
          value = true;
          break;
        }
        }
        return value;
    }
    //using the built in containsAll checks if cards contains all values in
    public boolean containsAll(Deck other){
      return cards.containsAll(other.cards);
    }
    //checks to see if the deck has all the same rank to see if this deck is discardable type returns true if yes and false if no
    public boolean isKind(){
      boolean value = true;
      for(int i=0; i<cards.size()-1; i++){
        if(cards.get(i).getRank() != cards.get(i+1).getRank()){
            value = false;
        }
      }
      if((cards.size()>=2) &&(value)){
          return true;
      }
      else{
        return false;
      }
    }
    //checks the use input of cards. checks if 1) the cards are in right order in terms of suit,
    //2) if input was bigger than 2, 3) the cards are in right order in terms of rank.
    public boolean isSeq(){
        Deck c = this;
        boolean result = true;
        for(int i=0; i<cards.size()-1; i++){
            if(cards.get(i).getSuit() != cards.get(i+1).getSuit()){
                result = false;
            }
        }

        if (cards.size()<3){
            result = false;
        }

        c.sortByRank();
        for(int a=0; a<cards.size()-1;a++){
            if(cards.get(a+1).getRank() != cards.get(a).getRank()+1){
                result = false;
            }
        }

        return result;
    }
    //sorts the cards by suit. uses the bubblesort algorithm. 
    //visits every element using two for loops, then if the previous card's suit is bigger than the next cards suit,
    //changes their location in the arraylist using .set
    public void sortBySuit(){
        for (int i=0; i<cards.size() -1;i++){
          for (int a=0; a<cards.size()-i-1; a++){
            if (cards.get(a).getSuit() > cards.get(a+1).getSuit()){
              Card tempCards = cards.get(a);
              cards.set(a, cards.get(a+1));
              cards.set(a+1, tempCards);
            }
          }
        }
    }
    //sorts the cards by rank. uses the bubblesort algorithm. 
    //visits every element using two for loops, then if the previous card's rank is bigger than the next cards rank,
    //changes their location in the arraylist using .set
    public void sortByRank(){
        for (int i=0; i<cards.size() -1;i++){
          for (int a=0; a<cards.size()-i-1; a++){
            if (cards.get(a).getRank() > cards.get(a+1).getRank()){
              Card tempCards = cards.get(a);
              cards.set(a, cards.get(a+1));
              cards.set(a+1, tempCards);
            }
          }
        }
    }
    //prints the hand in two ways. calls the sortBySuit to rearrange the hand by suit then prints the cards.
    // then calls on sortByRank to rearrange the hand by rank, then prints it too.
    public void print(){
        this.sortBySuit();
        for (int i=0; i<cards.size();i++){
            System.out.print("'"+cards.get(i)+"', ");
        }
        System.out.println();
        this.sortByRank();
        for (int i=0; i<cards.size();i++){
            System.out.print("'"+cards.get(i)+"', ");
        }
        System.out.println();
    }
    //change the type of cards in hand to string.
    public String toString(){
        String stringRepresentation = "";
        for (int i=0; i<cards.size();i++){
          if (i < cards.size()){
            stringRepresentation = stringRepresentation + cards.get(i) +"," ;
          }
          if (i==cards.size()){
            stringRepresentation = stringRepresentation + cards.get(i);
          }
        }
        return stringRepresentation;
    }
}
