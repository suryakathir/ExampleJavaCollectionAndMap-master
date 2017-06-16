package com.java.util.example;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

public class IdentityHashMapTest {
	public static void main(String args[]) {
		// Created HashMap and IdentityHashMap objects

		Map hashmapObject = new HashMap();
		Map identityObject = new IdentityHashMap();

		// Putting keys and values in HashMap and IdentityHashMap Object

		hashmapObject.put(new String("key"), "Google");
		hashmapObject.put(new String("key"), "Facebook");

		identityObject.put(new String("identityKey"), "Google");
		identityObject.put(new String("identityKey"), "Facebook");

		// Print HashMap and IdentityHashMap Size : After adding keys

		System.out.println("HashMap after adding key :" + hashmapObject);
		System.out.println("IdentityHashMap after adding key :" + identityObject);
	}
}
