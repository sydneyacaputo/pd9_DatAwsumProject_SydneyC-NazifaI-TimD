import java.util.*;

public class Deck implements Pile {

    private ArrayList<Card> _deck;
    private int _size;

    public Deck() {
	_deck = new ArrayList<Card>();
	
	for ( int i=0; i<52; i++ ) {
	    if ( i < 13 )
	        add( new Card(i+1,"Spade") );
	    else if ( i < 26 )
	        add( new Card(i-12,"Heart") );
	    else if ( i < 39 )
	        add( new Card(i-25,"Club") );
	    else 
	        add( new Card(i-38,"Diamond") );
	}
	//how are we accounting for the different face cards?
	//also should i exclude the color because that is known by the suit?
	for ( int i=52; i>0; i-- ) {
	    int j = (int) Math.random() * i;
	    Card temp = _deck.get(i);
	    _deck.set( i, _deck.get(j) );
	    _deck.set( j, temp );
	}	    
    }

    public Card peek() {
	return _deck.get( _size - 1 );
    }

    public void add( Card c ) {
	_deck.add(c);
	_size++;
    }

    public Card remove() {
	_size--;
	return _deck.remove(0);
    }

    public int getSize() {
	return _size;
    }

    /*
    public String toString() {
	String ret = "";
	for ( Card c : _deck )
	    ret = ret + c + " ";
	ret = ret.substring( 0, _deck.size()*2 - 1 );
	return ret;
    }
    */

    public void deal( Ranks r1, Ranks r2, Ranks r3, Ranks r4, Ranks r5,Ranks r6,Ranks r7 ) {
        Ranks[] field = { r1, r2, r3, r4, r5, r6, r7 };
	for ( int i=0; i<7; i++ ) {
	    for ( int j=i; j<7; j++ )
		field[j] = remove();
	}
    }

    public static void main( String[] args ) {

	Deck test = new Deck();
	System.out.println(test);
	
	System.out.println(test.peek());
	System.out.println(test.remove());
	System.out.println(test);

    }
	
}
