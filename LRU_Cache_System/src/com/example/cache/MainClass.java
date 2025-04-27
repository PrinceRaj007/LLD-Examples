package com.example.cache;

public class MainClass {

	public static void main(String[] args) {
//		Cache<Integer,String> cache = new Cache<>(0);
//		cache.put(1,"Prince");
//		cache.get(1);
		Cache<Integer, String> cache = new Cache<>(3);
		cache.put(1, "Prince");
		cache.put(2, "Ram");
		cache.put(3, "Shyam");
		cache.put(4, "Ghanshyam");
		cache.get(2);
		cache.put(6, "Krishna");
	}

}
