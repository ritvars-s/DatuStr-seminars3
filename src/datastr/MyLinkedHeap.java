package datastr;

import java.util.LinkedList;
import java.util.Queue;

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
	
//	public void enqueue(Ttype newElement) throws Exception{
//		if (isFull()) {
//			throw new Exception("Kaudz ir pilna un nav iespejams pievinot elementu");
//		}
//		if(newElement == null) {
//			throw new Exception("Elements nevar but null");
//		}
//		if(isEmpty()) { //ja tiek pievionot pirmais elements
//			MyNode<Ttype> newNode = new MyNode<Ttype>(newElement);
//			rootNode = newNode;
//			lastNode = newNode;
//			howManyElements++;
//		}
//		else {
//			MyNode<Ttype> newNode = new MyNode<Ttype>(newElement);
//			//ja bus saknes elementam kreisais berns
//			if(howManyElements == 1) {
//				rootNode.setLeftChNode(newNode);
//				newNode.setParentNode(rootNode);
//				lastNode = newNode;
//				howManyElements++;
//				level++;
//				reHeapUpMax(newNode);
//				return;
//			}
//			
//			if(lastNode.getLeftChNode() == null && lastNode.getRightChNode() == null) {
//				lastNode.setLeftChNode(newNode);
//				newNode.setParentNode(lastNode);
//				lastNode = newNode;
//				howManyElements++;
//				reHeapUpMax(newNode);
//				return;
//			}
//			
//			//kad pedejam blokam nav blakus labais bloks
//			if(lastNode.getParentNode() != null && lastNode.getRightChNode() == null) {
//				MyNode<Ttype> parentNodeTemp = lastNode.getParentNode();
//				parentNodeTemp.setRightChNode(parentNodeTemp);
//				
//				lastNode = newNode;
//				howManyElements++;
//				reHeapUpMax(newNode);
//				return;
//			}
//			//2^0 = 1 elements 0 limeni
//			//2^1 = 2 elementi 1 limeni
//			//utt
//			int sum = 0;
//			//es nosakidroju cik ir jabut blokiem lidz sim limenim ieskaitot
//			for(int i = 0; i <= level; i++) {
//				sum =(int) (sum + Math.pow(2, i));
//			}
//			//last node ir ka pedejais bloks sava limeni
//			if (sum == howManyElements) {
//				MyNode<Ttype> currentNode = rootNode;
//				while(currentNode.getLeftChNode() != null) {
//					currentNode = currentNode.getLeftChNode();
//				}
//				lastNode = currentNode;
//				
//				lastNode.setLeftChNode(newNode);
//				newNode.setParentNode(lastNode);
//				lastNode = newNode;
//				howManyElements++;
//				level++;
//				reHeapUpMax(newNode);
//				return;
//			}
//			//TODO izveidot pedejo scenariju, kurs no laba berna spej parlekt uz blakus apakskoka bernu
//		}
//	}
	
	//nav pabeigts
	public void enqueue(Ttype element) throws Exception {
		if (isFull()) {
			throw new Exception("Kaudze ir pilna un nav iespējams pievienot elementu");
		}

		if (element == null) {
			throw new Exception("Elements nevar būt null");
		}

		if (isEmpty()) {// ja tiek pievienots pirmais elements
			MyNode<Ttype> newNode = new MyNode<Ttype>(element);
			rootNode = newNode;
			lastNode = newNode;
			howManyElements++;
		} else// ja tiek pievienots kārtējais ( ne pirmais) elements
		{
			MyNode<Ttype> newNode = new MyNode<Ttype>(element);
			// ja būs saknes elementam kreisais bērns
			if (howManyElements == 1) {
				rootNode.setLeftChNode(newNode);
				newNode.setParentNode(rootNode);
				lastNode = newNode;
				howManyElements++;
				level++;
				reHeapUpMax(newNode);
				return;
			}

			// kad pedjeam blokam nav blakus labais bloks
			if (lastNode.getParentNode() != null && lastNode.getParentNode().getRightChNode() == null) {

				MyNode<Ttype> parentNodeTemp = lastNode.getParentNode();
				parentNodeTemp.setRightChNode(newNode);
				newNode.setParentNode(parentNodeTemp);

				lastNode = newNode;
				howManyElements++;
				reHeapUpMax(newNode);
				return;

			}
			// 2^0 = 1 elements 0.līmenī
			// 2^1 = 2 elementi 1.līmenī
			// 2^2 = 4 elementi 2.līmenī
			int sum = 0;
			// es noskaidroju, cik ir jābūt blokiem līdz šim līmenim ieskaitot
			for (int i = 0; i <= level; i++) {
				sum = (int) (sum + Math.pow(2, i));
			}

			// lastNode ir kā pēdejais bloks sava līmenī
			if (sum == howManyElements) {
				MyNode<Ttype> currentNode = rootNode;

				// ja blokam ir kreisais berns, tad jelec uz to
				while (currentNode.getLeftChNode() != null) {
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

			} else {
				// pēdējam blokam ir abi bērni
				if (lastNode.getParentNode().getLeftChNode() != null
						&& lastNode.getParentNode().getRightChNode() != null) {
					int numberForNewNode = howManyElements;
					int numberForNewNodeParent = (numberForNewNode-1 -1)/2;
					MyNode<Ttype> currentParent = findInsertionNode();
					currentParent.setLeftChNode(newNode);
					newNode.setParentNode(currentParent);
					lastNode = newNode;
					reHeapUpMax(newNode);
					howManyElements++;
					return;
				}

				// pēdējam blokam nav neviens no bērniem
				if (lastNode.getLeftChNode() == null && lastNode.getRightChNode() == null) {
					lastNode.setLeftChNode(newNode);
					newNode.setParentNode(lastNode);
					lastNode = newNode;
					howManyElements++;
					reHeapUpMax(newNode);
					return;
				}

			}

			
		}

	}
	private MyNode<Ttype> findInsertionNode() {
		Queue<MyNode> queue = new LinkedList<>();
		queue.add(rootNode);
		while (!queue.isEmpty()) {
			MyNode currentNode = queue.poll();
			if (currentNode.getRightChNode() == null) {
				return currentNode;
			} else {
				queue.add(currentNode.getRightChNode());
			}
			if (currentNode.getLeftChNode() == null) {
				return currentNode;
			} else {
				queue.add(currentNode.getLeftChNode());
			}

		}
		return null;
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
	//veicamvisas parbaudes
	//saglabasim root elementu mainigaja
	//pedejo bloka vertubu ieliekam root bloka
	//samazinam how manyelements
	//last nnode samainit leve ...
	public Ttype dequeue() throws Exception {
		if(isEmpty()) {
			throw new Exception("kaudze ir tuksa nevar izmantot dequeue");
		}
		Ttype elem;
		elem = rootNode.getElement();
		rootNode.setElement(lastNode.getElement());
		if(lastNode == rootNode) {
			lastNode = null;
			rootNode = null;
			howManyElements--;
			return elem;
		}
		
		if(lastNode.getParentNode().getLeftChNode() == lastNode) {
			lastNode.getParentNode().setLeftChNode(null);
		}
		if(lastNode.getParentNode().getRightChNode() == lastNode) {
			lastNode.getParentNode().setRightChNode(null);
		}
		//lastNode jasamaina
		howManyElements--;
		reheapDown(rootNode);
		
		return elem;
		
	}
	
	private void reheapDown(MyNode<Ttype> root) throws Exception{
		
		if(root != null) {
			if(root.getLeftChNode() !=null && root.getRightChNode() == null) {
				if(((Comparable)root.getElement()).compareTo(root.getLeftChNode().getElement()) < 0) {
					swap(root, root.getLeftChNode());
				}
			}
			//parbaudam vai kreisais berns lielaks par labo
			else if (root.getLeftChNode() != null && root.getRightChNode() != null) {
				if(((Comparable)root.getLeftChNode().getElement()).compareTo(root.getRightChNode().getElement()) > 0) {
					if(((Comparable)root.getLeftChNode().getElement()).compareTo(root.getElement()) > 0){
						swap(root, root.getLeftChNode());
						reheapDown(root.getLeftChNode());
					}
				}
			}
			else {
				if(((Comparable)root.getRightChNode().getElement()).compareTo(root.getLeftChNode().getElement()) > 0) {
					if(((Comparable)root.getRightChNode().getElement()).compareTo(root.getElement()) > 0){
						swap(root, root.getRightChNode());
						reheapDown(root.getRightChNode());
			}
		}
		
		
	}

}
}
}