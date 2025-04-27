package com.example.cache;

import java.util.HashMap;
import java.util.Map;

public class LRUEvictionPolicyStrategy<Key> implements EvictionPolicyStrategy<Key>{

	Map<Key,Node> map;
	DoublyLinkedList<Key> dll;
	
	public LRUEvictionPolicyStrategy() {
		map = new HashMap<>();
		dll = new DoublyLinkedList<>();
	}
	@Override
	public void keyAccessed(Key key) {
		if(map.containsKey(key)) {
			dll.detachNode(map.get(key));
			dll.addNodeAtLast(map.get(key));
		}else {
			Node node = dll.addElementAtLast(key);
			map.put(key, node);
		}
	}

	@Override
	public Key evictKey() {
		Node<Key> first = dll.getFirstNode();
		if(first!=null) {
			dll.detachNode(first);
			map.remove(first.getKey());
			return first.getKey();
		}
		return null;
	}
	

}
