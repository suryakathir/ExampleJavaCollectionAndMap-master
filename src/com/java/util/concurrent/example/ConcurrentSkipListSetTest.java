package com.java.util.concurrent.example;

import java.util.concurrent.ConcurrentSkipListSet;

/**
 * Since ConcurrentSkipListSet implements NavigableSet, it is a sorted set just
 * like TreeSet with added feature of being concurrent. Which essentially means
 * it is a sorted data structure which can be used by multiple threads where as
 * TreeSet is not thread safe.
 * 
 * The elements of the set are kept sorted according to their natural ordering,
 * or by a Comparator provided at set creation time, depending on which
 * constructor is used.
 * 
 * ConcurrentSkipListSet provides a constructor that takes a comparator as a
 * parameter.
 * 
 * ConcurrentSkipListSet(Comparator<? super E> comparator) - Constructs a new,
 * empty set that orders its elements according to the specified comparator.
 * ConcurrentSkipListSet implementation provides expected average log(n) time
 * cost for the contains, add, and remove operations and their variants.
 * Insertion, removal, and access operations safely execute concurrently by
 * multiple threads.
 * 
 * No Nulls:
 * 
 * ConcurrentSkipListSet does not permit the use of null elements, because null
 * arguments and return values cannot be reliably distinguished from the absence
 * of elements.
 * 
 *
 */
public class ConcurrentSkipListSetTest {
	ConcurrentSkipListSet<String> csls= new ConcurrentSkipListSet<String>();
    class AddThread implements Runnable {
        @Override
        public void run() {
            //adds specified element in the set
            csls.add("A");
            csls.add("B");
            csls.add("B");

            // returns the first element
            String s1=csls.first();

            System.out.println(s1);
            //returns the last element.
            String s2=csls.last();

            System.out.println(s2);
            System.out.println(csls);
        }
    }
    class SubThread implements Runnable {
        @Override
        public void run() {
            // removes the specified element from the set.
           csls.remove("A");
        }
    }
    public static void main(String... args) {
    	ConcurrentSkipListSetTest ob = new ConcurrentSkipListSetTest();
        new Thread(ob.new AddThread()).start();
        new Thread(ob.new SubThread()).start();
    }
}