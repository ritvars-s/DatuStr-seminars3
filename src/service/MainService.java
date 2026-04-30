package service;

import datastr.MyLinkedHeap;
import model.Patient;

//leftchindex = parentindex * 2 + 1
//rightchindex = parentindex * 2 + 2
//parentindex = (leftchindex -1) / 2
//parentindex = (rightchindex - 2) / 2
public class MainService {
	public static void main(String[] args) throws Exception {
		MyLinkedHeap<Integer> h1 = new MyLinkedHeap<Integer>();
		try {
			h1.enqueue(40);
			h1.enqueue(50);
			h1.enqueue(35);
			h1.enqueue(99);
			h1.enqueue(55);
			h1.enqueue(2);
			h1.print();
			
			System.out.println("==========");
			System.out.println(h1.dequeue());
			System.out.println("==========");
			h1.print();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		MyLinkedHeap<Patient> p1 = new MyLinkedHeap<Patient>();
		try {
			p1.enqueue(new Patient("Janis", "Shags", 1));
			p1.enqueue(new Patient("Liga", "Bome", 3));
			p1.enqueue(new Patient("Baiba", "Kalnina", 2));
			p1.enqueue(new Patient("Juris", "Trakais", 5));
			p1.print();
			System.out.println("==========");
			System.out.println(p1.dequeue());
			System.out.println("==========");
			p1.print();
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	

}
