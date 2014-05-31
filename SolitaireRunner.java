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
	


    }
    public String update() {
	String ret = "";
	ret = ret + "Cards remaining in the deck: " + cardsLeft.getSize();
	ret = 
    public static void main(String[] args) {
	System.out.println("HELLO, THE GAME IS BEGINNING.")
	    }//end main 
}//end class SolitaireRunner 
