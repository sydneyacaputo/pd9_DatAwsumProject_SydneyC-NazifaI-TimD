import java.util.*;

public class DrawPile implements Pile {

    private ArrayList<Card> _deck;
    private int _size;

    public DrawPile() {
	_deck = new ArrayList<Card>();
	
	for ( int i=0; i<52; i++ ) {
	    if ( i < 13 )
	        add( new Card(i+1,"S") );
	    else if ( i < 26 )
	        add( new Card(i-12,"H") );
	    else if ( i < 39 )
	        add( new Card(i-25,"C") );
	    else 
	        add( new Card(i-38,"D") );
	}
	//how are we accounting for the different face cards?
	//also should i exclude the color because that is known by the suit?
    
	shuffle();
    }

    public void shuffle() {
	for ( int k=51; k>=0; k-- ) {
	    int j = (int) (Math.random() * 51);
	    Card temp = _deck.get(k);
	    System.out.println("temp: " + temp);
	    _deck.set( k, _deck.get(j) );
	    System.out.println(_deck.get(k));
	    _deck.set( j, temp );
	    System.out.println(_deck.get(j));
	    }
	System.out.println("deck: " + _deck);
    }
	    
    public Card peek() {
	return _deck.get(0);
    }

    public Card get( int index ) {
	return _deck.get(index);
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

	System.out.println("first " + test.get(0));
	System.out.println("second " + test.get(1));
	System.out.println("third " + test.get(2));
	
	/*	System.out.println(test.peek());
	System.out.println(test.remove());
	System.out.println(test); */

    }
	
}
