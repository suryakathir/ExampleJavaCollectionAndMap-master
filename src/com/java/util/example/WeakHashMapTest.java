package com.java.util.example;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * Hash table based implementation of the <tt>Map</tt> interface, with
 * <em>weak keys</em>.
 * An entry in a <tt>WeakHashMap</tt> will automatically be removed when
 * its key is no longer in ordinary use.  More precisely, the presence of a
 * mapping for a given key will not prevent the key from being discarded by the
 * garbage collector, that is, made finalizable, finalized, and then reclaimed.
 * When a key has been discarded its entry is effectively removed from the map,
 * so this class behaves somewhat differently from other <tt>Map</tt>
 * implementations.
 *
 * <p> Both null values and the null key are supported. This class has
 * performance characteristics similar to those of the <tt>HashMap</tt>
 * class, and has the same efficiency parameters of <em>initial capacity</em>
 * and <em>load factor</em>.
 *
 * <p> Like most collection classes, this class is not synchronized.
 * A synchronized <tt>WeakHashMap</tt> may be constructed using the
 * {@link Collections#synchronizedMap Collections.synchronizedMap}
 * method.
 * 
 * WeakHashMap<K,V> extends AbstractMap<K,V> implements Map<K,V>
 * @author Robert Rosario
 *
 */
public class WeakHashMapTest {
	public static void main(String[] args) {
		Map hashMap= new HashMap();
		
        Map weakHashMap = new WeakHashMap();
        
        String keyHashMap = new String("keyHashMap");
        String keyWeakHashMap = new String("keyWeakHashMap");
        
        hashMap.put(keyHashMap, "Robert");
        weakHashMap.put(keyWeakHashMap, "Rosario");
       
        System.gc();
        System.out.println("Before: hash map value:"+hashMap.get("keyHashMap")+" and weak hash map value:"+weakHashMap.get("keyWeakHashMap"));
        
        keyHashMap = null;
        keyWeakHashMap = null;
       
        System.gc();  
        
        System.out.println("After: hash map value:"+hashMap.get("keyHashMap")+" and weak hash map value:"+weakHashMap.get("keyWeakHashMap"));
    
	/*
	 * Before: hash map value:Robert and weak hash map value:Rosario
	 *  After: hash map value:Robert and weak hash map value:null
	 */
	}

}
