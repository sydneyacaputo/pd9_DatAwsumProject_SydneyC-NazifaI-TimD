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
	return _pile.peek();
    }

    public void add( Card c ) {
        if ( c.getValue() == _pile.peek().getValue() + 1
	     && c.getSuit().equals( _suit ) ) {
	    _pile.push(c);
	    _size++;
	} else 
	    System.out.println("You can't place that here!");
    }

    public Card remove() {
	_size--;
	return _pile.pop();
    }

    public int getSize() {
	return _size;
    }

    public String toString() {        
	return peek().toString();
    }
}
