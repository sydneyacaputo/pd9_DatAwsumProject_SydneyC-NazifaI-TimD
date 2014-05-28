/*
The card class that will just have basic attributes. NO CARDS WILL BE CREATED IN THIS CLASS! Later on will make an arraylist of type Card to use for the game
Instance variables: color, suit, value, boolean value of flipped or no
have accesor methods
only thing that can be changed will be the boolean value flipped!



 */

import java.util.*;
import java.io.*;



public class Card{
    private String suit;
    private int value; 
    private String actVal;
    private boolean flipped;

    //later on we can just have a couple of simple for loops that will set these cards 
    public Card(int v, String s){
	suit= s;
	value = v;
	if (1< v && v <= 10)
	    actVal=""+value;
	else if (v =11)
	    actVal= "Jack";
	else if (v =12)
	    actVal= "Queen";
	else if (v =13)
	    actVal= "King";
	else
	    actVal="Ace";
	flipped = false;
    }
   
    
    private String getActVal(){
	return actVal;
    }
    private String getSuit(){
	return suit;
    }

    private int getValue(){
	return value;
    }

    private boolean isFlipped(){
	return flipped;
    }

    private void flip(){
	flipped= !flipped;
    }
}
