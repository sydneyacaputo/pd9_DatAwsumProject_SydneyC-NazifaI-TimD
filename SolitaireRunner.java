public class SolitaireRunner {
    private Deck cardsLeft;
    private Suits spade, heart, club, diamond;
    private Ranks r1, r2, r3, r4, r5, r6, r7;

    public SolitaireRunner() {
	cardsLeft = new Deck();

	spade = new Suits();
	heart = new Suits();
	club = new Suits();
	diamond = new Suits();
    
	r1 = new Ranks();
	r2 = new Ranks();
	r3 = new Ranks();
	r4 = new Ranks();
	r5 = new Ranks();
	r6 = new Ranks();
	r7 = new Ranks();

	cardsLeft.deal(r1, r2, r3, r4, r5, r6, r7);
    }

    public String update() {
	String ret = "";
	ret = ret + "Cards remaining in the deck: " + cardsLeft.getSize();
	ret = 
    public static void main(String[] args) {
	System.out.println("HELLO, THE GAME IS BEGINNING.")
	    }//end main 
}//end class SolitaireRunner 
