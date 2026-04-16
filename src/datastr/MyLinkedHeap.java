package datastr;

public class MyLinkedHeap<Ttype> {
	private MyNode<Ttype> rootNode = null;
	private MyNode<Ttype> lastNode = null;
	private int howManyElements = 0;
	
	public int getHowManyElements() {
		return howManyElements;
	}
	//setteri nav nepiecie'sams nevienam mainigajam
	
	//konstruktors/konstruktori - bezargumenta kons bus no Object klases
	
	//isFull
	public boolean isFull() {
		try {
			new MyNode<Character>('A');
			return false;
		}
		catch(OutOfMemoryError e) {
			return true;
		}
	}
	//isEmpty
	public boolean isEmpty() {
		return (howManyElements == 0);
	}
	public void enqueue(Ttype newElement) throws Exception{
		if (isFull()) {
			throw new Exception("Kaudz ir pilna un nav iespejams pievinot elementu");
		}
		if(newElement == null) {
			throw new Exception("Elements nevar but null");
		}
		if(isEmpty()) {
			MyNode<Ttype> newNode = new MyNode<Ttype>(newElement);
			rootNode = newNode;
			lastNode = newNode;
			howManyElements++;
		}
	}
	
	
}
