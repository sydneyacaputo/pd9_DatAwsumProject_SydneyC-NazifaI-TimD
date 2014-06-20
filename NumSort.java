/*
 * 
 NumSort is for the 7 piles of cards that the player will sort. The cards will be alternating colors and are organized in a LinkedList<Card>
 
*/

import java.util.*;


public class NumSort implements Pile{

    private LinkedList<Card> _rank; 
    
    //Constructor 
    public NumSort() {    	
    	_rank = new LinkedList<Card>();	
    }

    public boolean isEmpty() {return _rank.size() == 0;}

    public String checkColor( Card c ) {
	String suit = c.getSuit();
	if ( suit == "H" || suit == "D" ) 
	    return "red";
	return "black";
    }

    public int getSize() {
	return _rank.size();
    }

    public Card get( int index ) {
	return _rank.get(index);
    }

    public Card peek() {
	if ( isEmpty() ) return null;
		
	return _rank.peekLast();
    }
	
    /*
     * In order to add a new card 
     * it must be an alternate color from the last card color and one value lower  
     * OR if the last card is flipped, and this card is flipped, it can be added. This condition is not for the user but for the coder. 
     * When Deck deals out the cards at random in the beginning of the game, add() must account for it 
     */
    public boolean add( Card c ) {
	if ( isEmpty() || !(peek().isFaceUp()) ) {
	    _rank.add( c );
	    return true;
	}
	else if ( checkColor( peek() ).equals( checkColor( c ) )
		  || peek().getValue() - c.getValue() != 1 )
	    return false;
	else {
	    _rank.add( c );
	    return true;
	}
    }
	
    public boolean addPile( int x, NumSort oldRank ) {
	if ( isEmpty() ) {
	    if ( c.getValue() != 13 ) {
		System.out.println("You can't place that here!");
		return false;
	    } else {
		LinkedList<Card> tempList = new LinkedList<Card>();
		Card target = oldRank.get(x);
		int i = oldRank.size() - 1;
		while ( oldRank.get(i) != target ) {
		    tempList.add(oldRank.remove());
		    i--;
		}
		tempList.add(target);
		oldRank.remove(target);
		for ( int j=tempList.size()-1; j >= 0; j--) 
		    _rank.add(tempList.remove(j));
		return true;
	    }
    	} 

	if ( checkColor( peek() ).equals( checkColor( oldRank.get(x) ) ) ||
	     peek().getValue() - oldRank.get(x).getValue() != 1 )
	    return false;
	else { 
	    LinkedList<Card> tempList = new LinkedList<Card>();
	    Card target = oldRank.get(x);
	    int i = oldRank.size() - 1;
	    while ( oldRank.get(i) != target ) {
		tempList.add(oldRank.remove());
		i--;
	    }
	    tempList.add(target);
	    oldRank.remove(target);
	    for ( int j=tempList.size()-1; j >= 0; j--) 
		_rank.add(tempList.remove(j));
	    return true;
	}
		
    }
	
    public boolean addPile( Card c ) {
	if ( isEmpty() ) {
	    if ( c.getValue() == 13 ) {
		_rank.add(c);
		return true;
	    } else { 
		System.out.println("You can't place that here!");
		return false;
	    }
	} else if ( checkColor( peek() ).equals( checkColor( c ) ) 
		  || peek().getValue() - c.getValue() != 1 )
	    return false;
	else {
	    _rank.add(c);
	    return true;
	}
    }
	
    public Card remove() {
	if ( isEmpty() ) return null;
	return _rank.removeLast(); 	
    }
	
    public Card remove(Card c) {
	_rank.remove(c);
	return c;
    }
	
    public int size() {
	return _rank.size();
    }
	
    public String toString() {
	if (isEmpty()) return "NULL"; 
	String retStr = "TOP-> | "; 
	Card c;
	for (int i = 0; i < _rank.size(); i++){
	    c = _rank.get(i);
	    retStr += "suit: " + c.getSuit() + " , "; 
	    retStr += "value: " + c.getActVal()+ " | ";
	}
	retStr += " <-BOTTOM";
	return retStr; 
    }
	
    /*	public static void main ( String[] args ) {
	NumSort rank1 = new NumSort();
	NumSort rank2 = new NumSort();
	//		 System.out.println("Testing toString... ");
	//		 System.out.println(rank); 
	Card t1 = new Card(5,"Spade" );
	Card t2 = new Card(4,"Heart" );
	Card t3 = new Card(3,"Club" );
	Card t4 = new Card(1,"Diamond" );
	//		 System.out.println("Testing add...");
	rank1.add( t1 );
	//		 System.out.println("Added first card");
	//		 System.out.println(rank);
	rank1.add( t2 );
	System.out.print("Displaying rank1: ");
	System.out.println(rank1);
	//		 System.out.println("Added second card");
	//		 System.out.println(rank);
	rank2.add( t3 );
	//		 System.out.println("Added third card");
	//		 System.out.println(rank);
	rank2.add( t4 );
	System.out.print("Displaying rank2: ");
	System.out.println(rank2);
	System.out.println("Testing addPile...");
	rank1.addPile(0, rank2 );
	System.out.print("Displaying rank1: ");
	System.out.println(rank1);
	//		 System.out.println("Added error card");
	//		 System.out.println(rank);
	//		 System.out.println("Testing remove...");
	//		 System.out.println("Removed a card");
	//		 rank.remove();
	//		 System.out.println(rank);
	//		 System.out.println("Removed a card");
	//		 rank.remove();
	//		 System.out.println(rank);
	//		 System.out.println("Removed a card");
	//-		 rank.remove();
	//System.out.println(rank);
		 
		
	}//end main 
    */
}//end class
