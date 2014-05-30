import java.util.*;

public class DrawPile implements Pile {

    private ArrayList<Card> _deck;
    private int _size;

    public DrawPile() {
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
	for ( int k=51; k>=0; k-- ) {
	    int j = (int) Math.random() * k;
	    Card temp = _deck.get(k);
	    _deck.set( k, _deck.get(j) );
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

    public boolean isEmpty() {
	return _size == 0;
    }

    public String toString() {
	String ret = "";
	for ( Card c : _deck )
	    ret = ret + c + ", ";
	return ret;
    }

    public void deal( NumSort r1, NumSort r2, NumSort r3, NumSort r4, NumSort r5, NumSort r6, NumSort r7 ) {
        NumSort[] field = { r1, r2, r3, r4, r5, r6, r7 };
	for ( int i=0; i<7; i++ ) {
	    for ( int j=i; j<7; j++ )
		field[j].add(remove());
	}
    }

    public static void main( String[] args ) {

	DrawPile test = new DrawPile();
	System.out.println(test);
	
	System.out.println(test.peek());
	System.out.println(test.remove());
	System.out.println(test);

    }
	
}
