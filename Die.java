
// importing random class
import java.util.Random;

public class Die{
//decaration of a constant MAXVALUE which is 6
public static final int MAXVALUE = 6;
//declaration of instance variables
private int value = 0;
// new object of the java class random to generate random number
Random rand = new Random();
// constructor that sets value to a random int value from 1-6
public Die(){
  this.value = rand.nextInt(MAXVALUE) + 1;
}
 // method allows other classes to get the value of the die
public int getValue(){
  return value;
}

public void roll(){ //method changes the value of the die
  value = rand.nextInt(MAXVALUE) + 1;
}
//returns value of the die in the form of a string
public String toString(){
  String result;
  result = "Die " +"{value:" +value +"}";
  return result;
}
}
