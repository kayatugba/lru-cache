package com.tugbakaya.lrucache;

import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class LRUCache {

	HashSet<Integer> hashset;
	Deque<Integer> deque;
	Integer csize;

	public LRUCache(int n) {
		this.hashset = new HashSet<Integer>();
		this.deque = new LinkedList<Integer>();
		csize = n;

	}

	public void refer(Integer x) {
		// already in cache
		if (hashset.contains(x)) {
			deque.remove(x);
			this.display();
			System.out.println("Already in cache and after removed ");
			deque.addFirst(x);
			System.out.println("Already in cache and after added ");
		}
		// not in cache
		else {
			if (deque.size() == csize) {
				Integer lastElement = deque.removeLast();
				hashset.remove(lastElement);
			}
			deque.addFirst(x);
			hashset.add(x);
		}
	}

	public void display() {

		Iterator it = deque.iterator();
		while (it.hasNext()) {
			System.out.print(it.next() + " ");
		}

	}

	public static void main(String[] args) {
		LRUCache ca = new LRUCache(4);
		ca.refer(2);
		ca.refer(1);
		ca.refer(3);
		ca.refer(1);
		ca.refer(4);
		ca.refer(5);
		ca.display();

	}

}
