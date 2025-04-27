package com.example.cache;

import com.example.cache.exceptions.NotFoundException;
import com.example.cache.exceptions.StorageFullException;

public class Cache<Key, Value> {

	Storage<Key, Value> storage;
	EvictionPolicyStrategy<Key> evictionPolicy;

	public Cache(int size) {
		storage = new HashMapStorage<Key, Value>(size);
		evictionPolicy = new LRUEvictionPolicyStrategy<Key>();
	}

	public void put(Key key, Value value) {
		try {
			System.out.println("Adding..... Key: " + key + " with Value: " + value);
			storage.add(key, value);
			System.out.println("\tKey: " + key + " with Value: " + value + " Added in the cache");
			evictionPolicy.keyAccessed(key);
		} catch (StorageFullException e) {
			System.out.println("\tCache is full. Initiating Eviction...");
			Key keyToBeRemoved = evictionPolicy.evictKey();
			System.out.println("\tKey to be Removed is: " + keyToBeRemoved);
			try {
				storage.remove(keyToBeRemoved);
			} catch (NotFoundException e1) {
				System.out.println("\tEviction FAILED, Check the SIZE of the Cache");
				e1.printStackTrace();
				return;
			}
			System.out.println("\tEviction Completed...Key: " + keyToBeRemoved + " Removed from Cache");
			put(key, value);
		}
	}

	public Value get(Key key) {
		Value value;
		try {
			System.out.println("Fetching..... Key: " + key);
			value = storage.get(key);
			System.out.println("\tKey: " + key + " with Value: " + value + " fetched Successfully !!");
			evictionPolicy.keyAccessed(key);
			return value;
		} catch (NotFoundException e) {
			System.out.println("\tCan't find any Value for the Key: " + key);
			return null;
		}

	}

}
