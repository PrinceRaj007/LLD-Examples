package com.example.cache;

import java.util.HashMap;
import java.util.Map;

import com.example.cache.exceptions.NotFoundException;
import com.example.cache.exceptions.StorageFullException;

public class HashMapStorage<Key, Value> implements Storage<Key, Value> {

	int capacity;
	Map<Key, Value> map;

	HashMapStorage(int size) {
		map = new HashMap<>();
		capacity = size;
	}

	@Override
	public void add(Key key, Value value) throws StorageFullException {
		if(isFull()) {
			throw new StorageFullException();
		}
		map.put(key, value);
	}

	@Override
	public void remove(Key key) throws NotFoundException {
		if(map.isEmpty() || !map.containsKey(key)) {
			throw new NotFoundException();
		}
		map.remove(key);

	}

	@Override
	public Value get(Key key) throws NotFoundException {
		if(map.isEmpty() || !map.containsKey(key)) {
			throw new NotFoundException();
		}
		return map.get(key);
	}
	public boolean isFull() {
		return capacity <= map.size();
	}
}
