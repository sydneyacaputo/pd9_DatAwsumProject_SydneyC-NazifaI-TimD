/*
 * 
NumSort is for the 7 piles of cards that the player will sort. The cards will be alternating colors and are organized in a LinkedList<Card>
 
*/

import java.util.*;

import javax.smartcardio.Card;

public class NumSort {

    private LinkedList<Card> _rank; 
    
    //Constructor 
    public NumSort() {    	
    	_rank = new LinkedList<Card>();	
    }

   public boolean isEmpty() {return _rank.size() == 0;}

   public String checkColor( Card c ) {
    		String suit = c.getSuit();
    		if ( suit == "Heart" || suit == "Diamond" ) 
    			return "red";
    		return "black";
    }
    
/*    public Card get( int i ) {
    	return _rank.get(i); 
   }
	
	public Card peek() {
	    return _rank.peekLast();
	}
	
	void add( Card c ) {
	    if ( peek().checkColor().equals( c.checkColor() )
		 && peek().getValue() ) {
		
	    }
	    
	    _rank.add( c ); 
		 
	}
	
	public Card remove() {
		
	
	}*/
	
	public String toString() {
		String retStr = "TOP-> |"; 
		Card c;
		for (int i = 0; i < _rank.size(); i++){
			c = _rank.get(i);
			retStr += " suit: " + _suit; 
			retStr += " value: " + _value;
			retStr += " flipped: " + _flipped; 
		}
		retStr += " | <-BOTTOM";
		return retStr; 
	}
	
	public static void main ( String[] args) {
		
	}
	
}//end class
