package service;

import datastr.MyLinkedHeap;

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
			h1.enqueue(36);
			h1.print();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
