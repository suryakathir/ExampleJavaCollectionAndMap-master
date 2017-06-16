package com.java.util.concurrent.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/**
 * 
 * CopyOnWriteArrayList in Java is a thread safe implementation of List interface. CopyOnWriteArrayList was added in Java 1.5 and part of Collections framework
 *
 *CopyOnWriteArrayList<E>
    implements List<E>, RandomAccess, Cloneable, java.io.Serializable {
 */
public class CopyOnWriteArrayListTest {
	public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("5");
        // get the iterator
        Iterator<String> it = list.iterator();
        
        //manipulate list while iterating
        while(it.hasNext()){
            System.out.println("list is:"+list);
            String str = it.next();
            System.out.println(str);
            if(str.equals("2"))list.remove("5");
            if(str.equals("3"))list.add("3 found");
            //below code don't throw ConcurrentModificationException
            //because it doesn't change modCount variable of list
            if(str.equals("4")) list.set(1, "4");
        }
    }
}
