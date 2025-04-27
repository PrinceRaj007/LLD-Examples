package com.example.cache;

public class Node<Key> {
	Key key;
	Node next;
	Node prev;
	
	public Node(Key key) {
		this.key = key;
	}

	public Key getKey() {
		return key;
	}
	
}
