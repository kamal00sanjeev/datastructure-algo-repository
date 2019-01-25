package com.ds.htable;

public class HashTableTest {

	public static void main(String[] args) {

		HashTable<Integer, String> ht = new HashTable<>();
		ht.put(1, "one");
		ht.put(2,  "two");
		System.out.println(ht.put(3, "three"));
		ht.put(1,  "111");
		ht.put(null,  "000");
		//ht.put(null,  "0101");
		System.out.println(ht.put(2, "2121"));
		
		System.out.println(ht);
		System.out.println("Hashtable size: "+ht.getSize());
		ht.remove(2);
		System.out.println(ht);
	}

}
