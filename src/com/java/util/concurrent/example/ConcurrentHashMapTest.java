package com.java.util.concurrent.example;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ava ConcurrentHashMap Example. If you are a Java Developer, I am sure that
 * you must be aware of ConcurrentModificationException that comes when you want
 * to modify the Collection object while using iterator to go through with all
 * its element. Actually Java Collection Framework iterator is great example of
 * iterator design pattern implementation
 * 
 * @author Robert Rosario
 *
 */

public class ConcurrentHashMapTest {
	
	public static void main(String[] args) {

		//ConcurrentHashMap
		Map<String,String> myMap = new ConcurrentHashMap<String,String>();
		myMap.put("1", "1");
		myMap.put("2", "1");
		myMap.put("3", "1");
		myMap.put("4", "1");
		myMap.put("5", "1");
		myMap.put("6", "1");
		System.out.println("ConcurrentHashMap before iterator: "+myMap);
		Iterator<String> it = myMap.keySet().iterator();

		while(it.hasNext()){
			String key = it.next();
			if(key.equals("3")) myMap.put(key+"new", "new3");
		}
		System.out.println("ConcurrentHashMap after iterator: "+myMap);

		//HashMap
		myMap = new HashMap<String,String>();
		myMap.put("1", "1");
		myMap.put("2", "1");
		myMap.put("3", "1");
		myMap.put("4", "1");
		myMap.put("5", "1");
		myMap.put("6", "1");
		System.out.println("HashMap before iterator: "+myMap);
		Iterator<String> it1 = myMap.keySet().iterator();
/*
 * Exception comes here because  of String key = it1.next();
 * 
 * It means that the new entry got inserted in the HashMap but Iterator is failing. Actually Iterator on Collection objects are fail-fast i.e any modification in the structure or the number of entry in the collection object will trigger this exception thrown by iterator.

 *So How does iterator knows that there has been some modification in the HashMap. We have taken the set of keys from HashMap once and then iterating over it.

 *HashMap contains a variable to count the number of modifications and iterator use it when you call its next() function to get the next entry.
 * 
 * transient volatile int modCount; in Hashmap
 */
		while(it1.hasNext()){
			String key = it1.next();
			if(key.equals("3")) myMap.put(key+"new", "new3");
		}
		System.out.println("HashMap after iterator: "+myMap);
	}


}
