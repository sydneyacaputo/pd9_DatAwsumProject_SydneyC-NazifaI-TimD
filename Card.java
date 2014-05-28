/*
The card class that will just have basic attributes. NO CARDS WILL BE CREATED IN THIS CLASS! Later on will make an arraylist of type Card to use for the game
Instance variables: color, suit, value, boolean value of flipped or no
have accesor methods
only thing that can be changed will be the boolean value flipped!



 */

import java.util.*;
import java.io.*;



public class Card{
    private String color;
    private String suit;
    private String value; //we could make these numbers and then convert for the face cards? or just keep as strings, will discuss later 
    private boolean flipped;

    //later on we can just have a couple of simple for loops that will set these cards 
    public Card(String s, String c, String v){
	suit= s;
	color = c;
	value = v;
	flipped = false;
    }
   
    private String getColor(){
	return color;
    }

    private String getSuit(){
	return suit;
    }

    private String getValue(){
	return value;
    }

    private boolean isFlipped(){
	return flipped;
    }

    private void flip(){
	flipped= !flipped;
    }
}
