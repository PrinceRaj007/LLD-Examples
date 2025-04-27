package com.example.cache;

public interface EvictionPolicyStrategy<Key> {
	public void keyAccessed(Key key);
	public Key evictKey();
}
