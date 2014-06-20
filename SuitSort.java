import java.util.*;

public class SuitSort implements Pile {
    
    private Stack<Card> _pile;
    private String _suit;
    private int _size;
       
    public SuitSort( String suit ) {
	_pile = new Stack<Card>();
	_suit = suit;
    }

    public Card peek() {
	if ( _pile.size() == 0 )
	    return null;
	return _pile.peek();
    }

    public boolean add( Card c ) {
	if ( _pile.isEmpty()){
	    if( c.getValue() == 1  && c.getSuit().equals( _suit )) {
	    _pile.push(c);
	    _size++;
	    return true;}
	    else {
		System.out.println("Thats the wrong suit!");
		return false;
	    }}
	else if ( c.getValue() == _pile.peek().getValue() + 1 && 
	     c.getSuit().equals( _suit ) ) {
	    _pile.push(c);
	    _size++;
	    return true;
	} else {
	    System.out.println("You can't place that here!");
	    return false;
	}
    }

    public Card remove() {
	if ( isEmpty() ) {
	    System.out.println("The pile is empty!");
	    return null; 
	}
	_size--;
	return _pile.pop();
    }

    public int getSize() {
	return _size;
    }

    public String toString() {  
	if ( isEmpty() )
	    return "   ";
	return peek().toString();
    }

    public boolean isEmpty() {
	return _pile.isEmpty();
    }
}
