// This will be the main class from which the game is run

import java.util.*;

public class SolitaireRunner {

    private DrawPile deck,leftovers;
    private SuitSort spade, heart, club, diamond;
    private NumSort r1, r2, r3, r4, r5, r6, r7;
    private String[][] board;

    Scanner sc = new Scanner(System.in);

    public SolitaireRunner() {
	deck = new DrawPile();
	leftovers = new DrawPile();

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
    }

    public void turn() {
	System.out.print("What do you want to do? Move a card (m) or deal (d)? ");
	if ( sc.nextLine().equals("m") )
	    move();
	else if ( sc.nextLine().equals("d") )
	    deal();
	else {
	    System.out.println("Invalid response!");
	    turn();
	}
    }

    public void move() {
	System.out.println("Choose a card to move:");
	int r1 = rowInput();	
	int c1 = colInput();

	System.out.println("Choose a place to move " + board[r1][c1] + " to:");
	int r2 = rowInput();	
	int c2 = colInput();

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

	for ( int i=0; i<board[row].length; i++ ) {
	    if ( board[row][i] == null || board[row][i].equals(" # ") ) {
		System.out.println("Invalid response!");
		return rowInput();
	    }
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

	for ( int i=0; i<board.length; i++ ) {
	    if ( board[i][col] == null || board[i][col].equals(" # ") ) {
		System.out.println("Invalid response!");
		return colInput();
	    }
	}

	return col;
    }
    public void deal() {
	System.out.println("The next card dealt is: " + deck.peek());
	System.out.print("Do you want to move this card? (y/n): ");
	if ( sc.nextLine().equals("y") ) {
	    move();
	} else if ( sc.nextLine().equals("n") ) {
	    return;
	} else {
	    System.out.println("Invalid response!");
	    deal();
	}
    }
    
    public static void main(String[] args) {
	System.out.println("HELLO, THE GAME IS BEGINNING.");

	SolitaireRunner s = new SolitaireRunner();
        s.update();
	/*
	  What we need for the game:
	  - ask if they want to draw a card first
	      - if yes, then we ask if they want to move it and then where
	      - if they dont want to use that card just give the option to pick a regular card
	  - if no then we have to ask if they want to move it
	  - for the suitsort piles they just have to indicate the suit of the pile 
	  - for the numsort piles they have to indicate the row,column that they want

	 */
	/*	while ( !s.checkComplete() ) {
	    s.update();
	    s.turn();
	    } */

    }//end main 
}//end class SolitaireRunner 
