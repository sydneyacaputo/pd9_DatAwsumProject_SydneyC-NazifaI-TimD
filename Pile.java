/*
 * Pile is an interface that is implemented in classes DrawPile.java, SuitSort.java, and NumSort.java  
 */
public interface Pile {
	
	boolean isEmpty(); 
	
    Card peek(); //peeks the top cards

    void add( Card c );

    Card remove();

    public String toString();
	
}// end interface Pile 
