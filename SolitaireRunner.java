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
	for ( int n=numArray.length; n>0; n++ ) {
	    for ( int i=0; i<19; i++ ) {
		if ( i >= numArray[n].getSize() )
		    board[i+1][8-n] = "  ";
		else
		    board[i+1][8-n] = numArray[n].get(i).toString();
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
	if ( !isValidMove( r1, c1 ) ) {
	    System.out.println("Invalid spot!");
	    move();
	}
	System.out.println("Choose a place to move " + board[r1][c1] + " to:");
	int r2 = rowInput();	
	int c2 = colInput();
	if ( !isValidSpot( r1, c1, r2, c2 ) ) {
	    System.out.println("Invalid spot!");
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
	/* This needs to check:
	   1. If the spot is not a facedown card (board[row][col] =/= " # ")
	   2. If the spot is an actual card (board[row][col] =/= "   ")
	*/
	return true;
    }
    
    public boolean isValidSpot( int rowInit, int colInit, int rowFinal, int colFinal ) {
	/* This needs to check:
	   1. If the spot is not a facedown card (board[row][col] =/= " # ")
	   2. If the spot is an actual card (board[row][col] =/= "   ")
	   3. If the spot is an appropriate place to add the cards
	*/
	return true;
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

	System.out.println("YOU HAVE WON!");
	System.out.println("   ____     ____        __      _      _____    ______       ____     ________    _____  _______
  / ___)   / __ \      /  \    / )    / ___ \  (   __ \     (    )   (___  ___)  / ____\ \     /
 / /      / /  \ \    / /\ \  / /    / /   \_)  ) (__) )    / /\ \       ) )    ( (___    \   / 
( (      ( ()  () )   ) ) ) ) ) )   ( (  ____  (    __/    ( (__) )     ( (      \___ \    ) (  
( (      ( ()  () )  ( ( ( ( ( (    ( ( (__  )  ) \ \  _    )    (       ) )         ) )   \_/  
 \ \___   \ \__/ /   / /  \ \/ /     \ \__/ /  ( ( \ \_))  /  /\  \     ( (      ___/ /     _   
  \____)   \____/   (_/    \__/       \____/    )_) \__/  /__(  )__\    /__\    /____/     (_) ";
	   


    }//end main 
}//end class SolitaireRunner 
