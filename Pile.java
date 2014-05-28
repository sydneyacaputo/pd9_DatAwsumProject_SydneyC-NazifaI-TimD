
public interface Pile {

    int _size;
	
    Card peek();

    void add( Card c );

    Card remove();

    int getSize(); 

    public String toString();
    
    //add isEmpty? 
	
}// end interface Pile 
