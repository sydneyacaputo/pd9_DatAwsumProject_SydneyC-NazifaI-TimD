/*
 * Pile is an interface that is implemented in classes DrawPile.java, SuitSort.java, and NumSort.java  
 */
public interface Pile {
	
    Card peek(); //peeks the top cards

    boolean add( Card c );

    Card remove();

    public String toString();
	
}// end interface Pile 
