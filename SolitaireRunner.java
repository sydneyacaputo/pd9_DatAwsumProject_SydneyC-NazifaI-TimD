// This will be the main class from which the game is run

import java.util.*;

public class SolitaireRunner {

    private DrawPile deck;
    private SuitSort spade, heart, club, diamond;
    private NumSort r1, r2, r3, r4, r5, r6, r7;
    private String[][] board;

    Scanner s = new Scanner(System.in);

    public SolitaireRunner() {
	deck = new DrawPile();

	spade = new SuitSort("Spade");
	heart = new SuitSort("Heart");
	club = new SuitSort("Club");
	diamond = new SuitSort("Diamond");
    
	r1 = new NumSort();
	r2 = new NumSort();
	r3 = new NumSort();
	r4 = new NumSort();
	r5 = new NumSort();
	r6 = new NumSort();
	r7 = new NumSort();

	deck.deal(r1, r2, r3, r4, r5, r6, r7);

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
	for ( int a=0; a<19; a++ ) {
	    if ( a >= r7.getSize() )
		board[a+1][1] = "  ";
	    else
		board[a+1][1] = r7.get(a).toString();
	}
	for ( int b=0; b<19; b++ ) {
	    if ( b >= r6.getSize() )
		board[b+1][2] = "  ";
	    else
		board[b+1][2] = r6.get(b).toString();
	}
	for ( int c=0; c<19; c++ ) {
	    if ( c >= r5.getSize() )
		board[c+1][3] = "  ";
	    else
		board[c+1][3] = r5.get(c).toString();
	}
	for ( int d=0; d<19; d++ ) {
	    if ( d >= r4.getSize() )
		board[d+1][4] = "  ";
	    else	   
		board[d+1][4] = r4.get(d).toString();
	}
	for ( int e=0; e<19; e++ ) { 
	    if ( e >= r3.getSize() )
		board[e+1][5] = "  ";
	    else   
		board[e+1][5] = r3.get(e).toString();
	}
	for ( int f=0; f<19; f++ ) {
	    if ( f >= r2.getSize() )
		board[f+1][6] = "  ";
	    else    
		board[f+1][6] = r2.get(f).toString();
	}
	for ( int g=0; g<19; g++ ) { 
	    if ( g >= r1.getSize() )
		board[g+1][7] = "  ";
	    else
		board[g+1][7] = r1.get(g).toString();
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
    }// wait wouldnt we be peeking at the 2?

    public void turn() {
	update();
	System.out.print("What do you want to do? Move a card (m) or deal (d)? ");
	if ( s.nextLine().equals("m") ) {
	    System.out.println("Choose a card to move:");
	    System.out.print("What row? (--) ");
	    int r = s.nextInt();
	    System.out.print("What column? (-) ");
	    int c = s.nextInt();
	}
    }

    public static void main(String[] args) {
	System.out.println("HELLO, THE GAME IS BEGINNING.");

	SolitaireRunner s = new SolitaireRunner();
	// s.update();

	while ( !s.checkComplete() ) {
	    s.turn();
	}
    }//end main 
}//end class SolitaireRunner 
