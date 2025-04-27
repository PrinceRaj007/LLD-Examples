package com.example.cache;

public class DoublyLinkedList<Key> {
	Key key;
	Node<Key> head;
	Node<Key> tail;

	public DoublyLinkedList() {
		head = new Node<>(null);
		tail = new Node<>(null);

		head.next = tail;
		tail.prev = head;
	}

	public void detachNode(Node<Key> node) {
		if (node != null) {
			node.prev.next = node.next;
			node.next.prev = node.prev;
		}
	}

	public void addNodeAtLast(Node<Key> node) {
		tail.prev.next = node;
		node.prev = tail.prev;
		node.next = tail;
		tail.prev = node;
	}
	public Node addElementAtLast(Key key) {
		Node node = new Node(key);
		addNodeAtLast(node);
		return node;
	}
	public Node getFirstNode() {
		if(head.next==tail) {
			return null;
		}
		return head.next;
	}

	
}
