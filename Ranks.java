
public class Ranks implements Pile {
	
	private int _size;
	private Card _head, _tail; 
	
	public Ranks {
		_size = 0;
		_head = _tail = null;
	}
	
	public Card peek() {
		return _end
	}
	
	void add( Card c ) {
		_tail = new Card(); 
		
		if ( _size == 0 ) 
			_head = _tail;
		else 
			_tail.getPrev().setNext( _tail ); //have these methods in Card? 
		_size++;
	}
	
	public Card remove() {
		Card ret = _tail; 
		//if isEmpty? 
		if ( size() == 1) {
			_head = _tail = null; 
		}
		else {
			_tail = _tail.getPrev(); 
			_tail.setNext( null );
		}
		size--;
		return ret; 
	}
	
	int getSize() {
		return _size; 
	}
	
	public String toString() {
		String retStr  "HEAD->"; 
		Card tmp = _head; 
		while ( tmp !=null ) {
			//retStr = tmp.getWhateverTheValue + "->";
			tmp = tmp.getNext(); 
		}
		retStr += "NULL";
		return retStr; 
	}
	
}//end class