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
    private boolean _faceUp;

    //later on we can just have a couple of simple for loops that will set these cards 
    public Card(int v, String s){
	_suit= s;
	_value = v;
	if (1< v && v <= 10)
	    _actVal=""+_value;
	else if (v ==11)
	    _actVal= "J";
	else if (v ==12)
	    _actVal= "Q";
	else if (v ==13)
	    _actVal= "K";
	else
	    _actVal="A";
	_faceUp = false;
    }
   
    //I changed the accessor methods to public from private so that other files in the folder can use it 
    //Also, can I add some mutators? - Nazifa
    public String getActVal(){
	return _actVal;
    }
    public String getSuit(){
	return _suit;
    }

    public int getValue(){
	return _value;
    }

    public boolean isFaceUp(){
	return _faceUp;
    }

    public void flip(){
	_faceUp= !_faceUp;
    }

    public String toString() {
	if ( !isFaceUp() ) 
	    return " # ";
	if ( _value == 10 )
	    return _suit + _actVal;
	else
	    return _suit + _actVal + " ";
    }
    // Need to change this for when it's flipped or not, we'll do that later
    
  public static void main( String[] args ) {

      Card test = new Card(5,"Spade" );
      System.out.println(test.getSuit());

	System.out.println(test.getActVal());
	System.out.println(test.isFaceUp());
	
	
  }


}
