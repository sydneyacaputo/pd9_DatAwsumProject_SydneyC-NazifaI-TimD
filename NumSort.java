/*
we should have a discription at the beginning of each file so we all know what it is and what it contains 

should become a linked list
the ranks is for the 7 piles of cards that the player will order their cards alternating colors 
*/

import java.util.*;

public class Ranks {

    private LinkedList<Card> _rank; 
    
    //Constructor 
    public Ranks() {    	
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
		
	
	}
	
	public String toString() {
		String retStr = "HEAD->"; 
		Card tmp = _head; 
		while ( tmp !=null ) {
			//retStr = tmp.getWhateverTheValue + "->";
			tmp = tmp.getNext(); 
		}
		retStr += "NULL";
		return retStr; 
	}*/
	public static void main ( String[] args) {
		System.out.println("passed the compiler");
	}
	
}//end class
