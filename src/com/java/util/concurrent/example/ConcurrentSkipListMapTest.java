package com.java.util.concurrent.example;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/*
 *ConcurrentNavigableMap  interface is a type of SortedMap that provides navigation methods that returns the closest match for given search targets. It has methods like lowerEntry, floorEntry, ceilingEntry, higherEntry which return Map.Entry instances based on the key passed respectively less than, less than or equal, greater than or equal and greater than. Similar set of methods available for returning keys too. These can be navigated by ascending or descending order too
 *Combined with all the above operations of a NavigableMap it also extends the ConcurrentMap interface. So this is a super-dooper Map we get.
 *ConcurrentSkipListMap is an implementation of ConcurrentNavigableMap provided in the JDK since 1.6. The elements are sorted based on their natural sorting order of keys. The order can be customized using a Comparator provided during the time of initialization
 *
 *Skip List:
 *A skip list is a type of data structure that allows fast search in an ordered sequence of elements. This is built using multiple sequence of layers. The lowest layer linking all the elements by a linked list and subsequent layers above skips some elements in between the links. Thus the highest layer contains the least number of elements in the linked sequence. The elements that are to be sipped in between are chosen probabilistically.
 *
 *Difference between ConcurrentHashMap and ConcurrentSkipListMap:
 *By specification, ConcurrentHashMap does no guarantee the runtime of its operations. Wherein ConcurrentSkipListMap guarantees O(log(n)) performance for most of its operations.
 *ConcurrentHashMap allows to modify the number of threads to tune the concurrency behaviour wherein ConcurrentSkipListMap does not allow to modify the concurrent thread count.
 *ConcurrentHashMap is not NavigableMap and also not a SortedMap, But ConcurrentSkipListMap is both a NavigableMap and a SortedMap.
 *ConcurrentSkipListMap is a skip list and CocurrentHashMap is not.
 *
 *ConcurrentSkipListMap<K,V> extends AbstractMap<K,V>
    implements ConcurrentNavigableMap<K,V>, Cloneable, Serializable
 */
public class ConcurrentSkipListMapTest {
	 public static void main(String[] args) {
	        ConcurrentNavigableMap concurrentSkipListMap = new ConcurrentSkipListMap();
	        concurrentSkipListMap.put("3", "Apple");
	        concurrentSkipListMap.put("2", "Ball");
	        concurrentSkipListMap.put("1", "Car");
	        concurrentSkipListMap.put("5", "Doll");
	        concurrentSkipListMap.put("4", "Elephant");

	        System.out.println("ceilingEntry-2: " + concurrentSkipListMap.ceilingEntry("2"));
	        NavigableSet navigableSet = concurrentSkipListMap.descendingKeySet();
	        System.out.println("descendingKeySet: ");
	        Iterator itr = navigableSet.iterator();
	        while (itr.hasNext()) {
	            String s = (String) itr.next();
	            System.out.println(s);
	        }
	        System.out.println("firstEntry: " + concurrentSkipListMap.firstEntry());
	        System.out.println("lastEntry: " + concurrentSkipListMap.lastEntry());
	        System.out.println("pollFirstEntry: " + concurrentSkipListMap.pollFirstEntry());
	        System.out.println("now firstEntry: " + concurrentSkipListMap.firstEntry());
	        System.out.println("pollLastEntry: " + concurrentSkipListMap.pollLastEntry());
	        System.out.println("now lastEntry: " + concurrentSkipListMap.lastEntry());
	    }

}
