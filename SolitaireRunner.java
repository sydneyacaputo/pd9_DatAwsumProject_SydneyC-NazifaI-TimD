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
	for ( int a=0; a<r1.getSize(); a++ ) 
	    board[1][a+1] = r1.get(a).toString();
	for ( int b=0; b<r2.getSize(); b++ ) 
	    board[1][b+1] = r2.get(b).toString();
	for ( int c=0; c<r3.getSize(); c++ ) 
	    board[1][c+1] = r3.get(c).toString();
	for ( int d=0; d<r4.getSize(); d++ ) 
	    board[1][d+1] = r4.get(d).toString();
	for ( int e=0; e<r5.getSize(); e++ ) 
	    board[1][e+1] = r5.get(e).toString();
	for ( int f=0; f<r6.getSize(); f++ ) 
	    board[1][f+1] = r6.get(f).toString();
	for ( int g=0; g<r7.getSize(); g++ ) 
	    board[1][g+1] = r7.get(g).toString();
    }

    public static void main(String[] args) {
	System.out.println("HELLO, THE GAME IS BEGINNING.");

	SolitaireRunner s = new SolitaireRunner();
	s.update();
    }//end main 
}//end class SolitaireRunner 
