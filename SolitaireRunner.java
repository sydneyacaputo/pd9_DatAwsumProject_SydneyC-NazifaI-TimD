public class SolitaireRunner {
    private DrawPile cardsLeft;
    private SuitSort spade, heart, club, diamond;
    private NumSort r1, r2, r3, r4, r5, r6, r7;

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
    }
    public setUp (){
	//this is to set up the initial board
	//need to decide if this actually going to be a 2D array
	// if so will start setup like this:
	//WAIT we cant make a 2D array to hold everything because it will not
	// be able to take the different type
	int outline[][] = new int[20][7];
	for(int x =0; x<20; x++)
	    outline[x][0]=x+1;
	for(int y=1; y<8; y++)
	    outlin[0][y]=y;


    }
    public String update() {
	String ret = "";
	ret = ret + "Cards remaining in the deck: " + cardsLeft.getSize();
	ret = 
    public static void main(String[] args) {
	System.out.println("HELLO, THE GAME IS BEGINNING.")
	    }//end main 
}//end class SolitaireRunner 
