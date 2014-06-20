// This will be the main class from which the game is run
import java.util.*;

public class SolitaireRunner {

    private DrawPile deck,leftovers;
    private SuitSort spade, heart, club, diamond;
    private String[][] board;
    private NumSort[] numArray;

    Scanner sc = new Scanner(System.in);

    public SolitaireRunner() {
	deck = new DrawPile();
	leftovers = new DrawPile();

	spade = new SuitSort("Spade");
	heart = new SuitSort("Heart");
	club = new SuitSort("Club");
	diamond = new SuitSort("Diamond");

	numArray = new NumSort[7];
	for ( int x=0; x<7; x++ )
	    numArray[x] = new NumSort();

	deck.deal( numArray );

        board = new String[20][8];
	for ( int c=0; c<board[0].length; c++ ) {
	    if ( c < 10 )
		board[0][c] = " " + c + " ";
	    else 
		board[0][c] = "" + c;
	}
	for ( int r=0; r<board.length; r++ ) {
	    if ( r < 10 )
		board[r][0] = "0" + r;
	    else
		board[r][0] = "" + r;
	}
	// System.out.println(r1);	
	// System.out.println(r2);


	merge();
    }

    public void update() {
        System.out.println("Cards remaining in the deck: " + deck.getSize());
        System.out.println("               S  |  H  |  C  |  D ");
        System.out.println("Sorted piles: " + spade + " | " + heart + " | " + club + " | " + diamond);

	String output = "";
        for ( int r=0; r<board.length; r++ ) {
            for ( int c=0; c<board[0].length; c++ ) {
                output += " " + board[r][c];
            }
            output += "\n";
        }
	System.out.println(output);
    } // needs to be tweaked

    public void merge() {
	for ( int n=numArray.length-1; n>=0; n-- ) {
	    for ( int i=0; i<19; i++ ) {
		if ( i >= numArray[n].getSize() )
		    board[i+1][7-n] = "  ";
		else
		    board[i+1][7-n] = numArray[n].get(i).toString();
	    }
	}
    }

    public boolean checkComplete() {
	if ( spade.peek() == null ||
	     heart.peek() == null ||
	     club.peek() == null ||
	     diamond.peek() == null )
	    return false;
	if ( spade.peek().equals("SK") &&
	     heart.peek().equals("HK") &&
	     club.peek().equals("CK") &&
	     diamond.peek().equals("DK") )
	    return true;
	return false;
    }

    public void turn() {
	System.out.print("What do you want to do? Move a card (m) or deal (d)? ");
	String str = "" + sc.next();
	if ( str.equals("m") )
	    move();
	else if ( str.equals("d") )
	    deal();
	else {
	    System.out.println("Invalid response!");
	    turn();
	}
    }
  
    public void deal() {
	if ( deck.isEmpty() ) {
	    deck = leftovers;
	    leftovers = new DrawPile();
	}
	    
	System.out.println("The next card dealt is: " + deck.peek());
	System.out.print("Do you want to move this card? (y/n): ");
	String str1 = "" + sc.next();	
	if ( str1.equals("y") ) {
	    Card card = deck.remove();
	    System.out.print("Move to a suit pile (s) or a mixed pile (m)? ");
	    String str2 = "" + sc.next();
	    if ( str2.equals("s") ) {
		System.out.print("Which pile? Spades (s)? Hearts (h)? Clubs (c)? or Diamonds (d)? ");
		String str3 = "" + sc.next();
		if ( str3.equals("s") )
		    spade.add(card);
		else if ( str3.equals("h") )
		    heart.add(card);
		else if ( str3.equals("c") )
		    club.add(card);
		else if ( str3.equals("d") )
		    diamond.add(card);
		else {
		    System.out.println("Invalid response!");
		    move();
		}
	    } else if ( str2.equals("m") ) {
		System.out.println("Choose where you want to place " + card.toString() + ":");
		int c2 = colInput();	
		numArray[c2-1].addPile( card );		    
	    } else {
		System.out.println("Invalid response!");
		move();
	    }
	} else if ( str1.equals("n") ) {
	    leftovers.add(deck.remove());
	} else {
	    System.out.println("Invalid response!");
	    deal();
	}
	
    }

    public void move() {
	System.out.print("Move from the field (f) or the suit piles (s)? ");
	String str1 = "" + sc.next();
	Card card = new Card(1,"S");
	int c1 = 0;
	int r1 = 0;
	boolean twoParam = true;
	if ( str1.equals("f") ) {
	    System.out.println("Choose a card to move:");
	    r1 = rowInput();	
	    c1 = colInput();
	    card = numArray[c1-1].get(r1-1);
	    if ( !isValidMove( r1, c1 ) ) {
		System.out.println("Invalid spot!");
		move();
	    }
	} else if ( str1.equals("s") ) {
	    System.out.println("Which pile? Spades (s)? Hearts (h)? Clubs (c)? or Diamonds (d)? ");
	    String str2 = "" + sc.next();
		
	    if ( str2.equals("s") )
		card = spade.remove();
	    else if ( str2.equals("h") )
		card = heart.remove();
	    else if ( str2.equals("c") )
		card = club.remove();
	    else if ( str2.equals("d") )
		card = diamond.remove();
	    else {
		System.out.println("Invalid response!");
		move();
	    }
	    twoParam = false;
	} else {
	    System.out.println("Invalid response!");
	    move();
	}
	
	System.out.println("Move to a suit pile (s) or a mixed pile (m)? ");
	String str3 = "" + sc.next();
	if ( str3.equals("s") ) {
	    System.out.println("Which pile? Spades (s)? Hearts (h)? Clubs (c)? or Diamonds (d)? ");
	    String str4 = "" + sc.next();
	    if ( str4.equals("s") )
	        spade.add(card);
	    else if ( str4.equals("h") )
		heart.add(card);
	    else if ( str4.equals("c") )
	        club.add(card);
	    else if ( str4.equals("d") )
		diamond.add(card);
	    else {
		System.out.println("Invalid response!");
		move();
	    }
	} else if ( str3.equals("m") ) {
	    System.out.println("Choose where you want to place " + card.toString() + ":");
	    int c2 = colInput();
	    if ( twoParam )
		numArray[c2-1].addPile( r1, numArray[c1-1] );
	    else {
		int size = numArray[c2].getSize();
		numArray[c2-1].addPile( card );
		if ( numArray[c2-1].getSize() - size != 1 ) {
		    if ( card.getSuit().equals("S") )
			spade.add(card);
		    else if ( card.getSuit().equals("H") )
			heart.add(card);
		    else if ( card.getSuit().equals("C") )
			club.add(card);
		    else 
			diamond.add(card);
		}
	    }
	} else {
	    System.out.println("Invalid response!");
	    move();
	}
    }

    public int rowInput() {
	System.out.print("What row? (--) ");
	int row = -1;
        try {
	    row = sc.nextInt();
	} catch ( InputMismatchException e ) {
	    System.out.print("\n");
	    System.out.println("Invalid response!");
	    return rowInput();
	}
	return row;
    }

    public int colInput() {
	System.out.print("What column? (-) ");
	int col = -1;
        try {
	    col = sc.nextInt();
	} catch ( InputMismatchException e ) {
	    System.out.print("\n");
	    System.out.println("Invalid response!");
	    return colInput();
	}
	return col;
    }

    public boolean isValidMove( int row, int col ) {
	if ( row > numArray[col].getSize() )
	    return false;
	Card card = numArray[col].get(row);
	if ( card.isFaceUp() == false )
	    return false;
	return true;
    }

    
    public static void main(String[] args) {
	System.out.println("HELLO, THE GAME IS BEGINNING.");

	SolitaireRunner s = new SolitaireRunner();
        

        while ( !s.checkComplete() ) {
	    s.update();
	    s.turn();
	    s.merge();
	}

	System.out.println("YOU HAVE WON!");

	   


    }//end main 
}//end class SolitaireRunner 
