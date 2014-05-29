/*
we should have a discription at the beginning of each file so we all know what it is and what it contains 

should become a linked list
the ranks is for the 7 piles of cards that the player will order their cards alternating colors 
*/
public class Ranks implements Pile {

    private LinkedList<Card> _rank; 
    
    public Ranks {
	_rank = new LinkedList<Card>();
    }

    public boolean isEmpty() {
	
	return size() == 0;
    }

    public String checkColor( Card c ) {
	String suit = c.getSuit;
	if ( suit == "Hearts" || suit == "Diamond" ) 
	    return "red";
	return "black";

    }
    
    public Card get( int i ) {

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
		Card ret = _tail; 
		//if isEmpty? 
		if ( size() == 1) {
			_head = _tail = null; 
		}
		else {
			_tail = _tail.getPrev(); 
			_tail.setNext( null );
		}
		size--;
		return ret; 
	}
	
	int getSize() {
		return _size; 
	}
	
	public String toString() {
		String retStr  "HEAD->"; 
		Card tmp = _head; 
		while ( tmp !=null ) {
			//retStr = tmp.getWhateverTheValue + "->";
			tmp = tmp.getNext(); 
		}
		retStr += "NULL";
		return retStr; 
	}
	
}//end class
