public class SolitaireRunner {
    private DrawPile deck;
    private SuitSort spade, heart, club, diamond;
    private NumSort r1, r2, r3, r4, r5, r6, r7;
    private String[][] board;

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
	for ( int r=0; r<board.length; r++ ) {
	    if ( r < 10 )
		board[r][0] = "0" + r;
	    else
		board[r][0] = "" + r;
	}
	for ( int c=0; c<board[0].length; c++ ) {
	    if ( c < 10 )
		board[0][c] = "0" + c;
	    else 
		board[0][c] = "" + c;
	}
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


    public static void main(String[] args) {
	System.out.println("HELLO, THE GAME IS BEGINNING.");

	SolitaireRunner s = new SolitaireRunner();
	s.update();
    }//end main 
}//end class SolitaireRunner 
