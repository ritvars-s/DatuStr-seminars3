package datastr;

public class MyLinkedHeap<Ttype> {
	private MyNode<Ttype> rootNode = null;
	private MyNode<Ttype> lastNode = null;
	private int howManyElements = 0;
	private int level = 0;
	
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
		if(isEmpty()) { //ja tiek pievionot pirmais elements
			MyNode<Ttype> newNode = new MyNode<Ttype>(newElement);
			rootNode = newNode;
			lastNode = newNode;
			howManyElements++;
		}
		else {
			MyNode<Ttype> newNode = new MyNode<Ttype>(newElement);
			//ja bus saknes elementam kreisais berns
			if(howManyElements == 1) {
				rootNode.setLeftChNode(newNode);
				newNode.setParentNode(rootNode);
				lastNode = newNode;
				howManyElements++;
				level++;
				reHeapUpMax(newNode);
				return;
			}
			
			if(lastNode.getLeftChNode() == null && lastNode.getRightChNode() == null) {
				lastNode.setLeftChNode(newNode);
				newNode.setParentNode(lastNode);
				lastNode = newNode;
				howManyElements++;
				reHeapUpMax(newNode);
				return;
			}
			
			//kad pedejam blokam nav blakus labais bloks
			if(lastNode.getParentNode() != null && lastNode.getRightChNode() == null) {
				MyNode<Ttype> parentNodeTemp = lastNode.getParentNode();
				parentNodeTemp.setRightChNode(parentNodeTemp);
				
				lastNode = newNode;
				howManyElements++;
				reHeapUpMax(newNode);
				return;
			}
			//2^0 = 1 elements 0 limeni
			//2^1 = 2 elementi 1 limeni
			//utt
			int sum = 0;
			//es nosakidroju cik ir jabut blokiem lidz sim limenim ieskaitot
			for(int i = 0; i <= level; i++) {
				sum =(int) (sum + Math.pow(2, i));
			}
			//last node ir ka pedejais bloks sava limeni
			if (sum == howManyElements) {
				MyNode<Ttype> currentNode = rootNode;
				while(currentNode.getLeftChNode() != null) {
					currentNode = currentNode.getLeftChNode();
				}
				lastNode = currentNode;
				
				lastNode.setLeftChNode(newNode);
				newNode.setParentNode(lastNode);
				lastNode = newNode;
				howManyElements++;
				level++;
				reHeapUpMax(newNode);
				return;
			}
			//TODO izveidot pedejo scenariju, kurs no laba berna spej parlekt uz blakus apakskoka bernu
		}
	}
	public void reHeapUpMax(MyNode<Ttype> nodeTemp) {
		if(nodeTemp.getParentNode() != null) {
			MyNode<Ttype> parentTempNode = nodeTemp.getParentNode(); 
			if(((Comparable)nodeTemp.getElement()).compareTo(parentTempNode.getElement()) > 0) {
				//mainam vietam vertibas
				swap(parentTempNode, nodeTemp);
				reHeapUpMax(parentTempNode); //izsaucam so pasu funkciju rekursivi
				
			}
		}
	}
	public void swap(MyNode<Ttype> node1, MyNode<Ttype> node2) {
		Ttype tempelement = node1.getElement();
		node1.setElement(node2.getElement());
		node2.setElement(tempelement);
	}
	public void print() throws Exception{
		if(isEmpty()) {
			throw new Exception("Kaudze ir tuksa");
		}
		printHelper(rootNode);
		
	}
	private void printHelper(MyNode<Ttype> nodeTemp) {
		if(nodeTemp != null) {
			System.out.println("P: " + nodeTemp.getElement());
			//nosakidrojam vai eksisste kreisais berns
			if(nodeTemp.getLeftChNode() != null) {
				System.out.println("P: " + nodeTemp.getElement() + " Left child: " + nodeTemp.getLeftChNode().getElement());
				printHelper(nodeTemp.getLeftChNode());
			}
			if(nodeTemp.getRightChNode() != null) {
				System.out.println("P: " + nodeTemp.getElement() + " Right child: " + nodeTemp.getRightChNode().getElement());
				printHelper(nodeTemp.getRightChNode());
			}
		}
		
	}
}
