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
	
	
}
