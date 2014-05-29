/*
The card class that will just have basic attributes. NO CARDS WILL BE CREATED IN THIS CLASS! Later on will make an arraylist of type Card to use for the game
Instance variables: color, suit, value, boolean value of flipped or no
have accesor methods
only thing that can be changed will be the boolean value flipped!



 */

import java.util.*;
import java.io.*;



public class Card{
    private String _suit;
    private int _value; 
    private String _actVal;
    private boolean _flipped;

    //later on we can just have a couple of simple for loops that will set these cards 
    public Card(int v, String s){
	_suit= s;
	_value = v;
	if (1< v && v <= 10)
	    _actVal=""+_value;
	else if (v ==11)
	    _actVal= "Jack";
	else if (v ==12)
	    _actVal= "Queen";
	else if (v ==13)
	    _actVal= "King";
	else
	    _actVal="Ace";
	_flipped = false;
    }
   
    //I changed the accessor methods to public from private so that other files in the folder can use it - Nazifa 
    public String getActVal(){
	return _actVal;
    }
    public String getSuit(){
	return _suit;
    }

    public int getValue(){
	return _value;
    }

    public boolean isFlipped(){
	return _flipped;
    }

    public void flip(){
	_flipped= !_flipped;
    }

  public static void main( String[] args ) {

      Card test = new Card(5,"Spade" );
      System.out.println(test.getSuit());

	System.out.println(test.getActVal());
	System.out.println(test.isFlipped());
	
  }


}
