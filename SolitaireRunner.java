public class SolitaireRunner {
    private DrawPile cardsLeft;
    private SuitSort spade, heart, club, diamond;
    private NumSort r1, r2, r3, r4, r5, r6, r7;
    private String[][] board;

    public SolitaireRunner() {
	cardsLeft = new DrawPile();

	spade = new SuitSort();
	heart = new SuitSort();
	club = new SuitSort();
	diamond = new SuitSort();
    
	r1 = new NumSort();
	r2 = new NumSort();
	r3 = new NumSort();
	r4 = new NumSort();
	r5 = new NumSort();
	r6 = new NumSort();
	r7 = new NumSort();

	cardsLeft.deal(r1, r2, r3, r4, r5, r6, r7);

        board = new String[20][8];
	for ( int r=0; r<board.length; r++ ) 
	    board[r][0] = "" + (r+1);
	for ( int c=0; c<board[0].length; c++ ) 
	    board[0][c] = "" + (c+1);
    }

    public void update() {
        System.out.println("Cards remaining in the deck: " + cardsLeft.getSize());
        System.out.println("Sorted piles: " + spade + " | " + heart + " | " club + " | " + diamond);

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
    }//end main 
}//end class SolitaireRunner 
