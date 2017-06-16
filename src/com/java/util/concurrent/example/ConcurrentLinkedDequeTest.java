package com.java.util.concurrent.example;

import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * java.util.concurrent.ConcurrentLinkedDeque has been introduced in JDK 7 and
 * is the part of java collection framework. ConcurrentLinkedDeque is an
 * unbounded concurrent deque. ConcurrentLinkedDeque works on the basis of
 * linked nodes. As ConcurrentLinkedDeque is thread safe so removal, insertion
 * and other operation can be performed concurrently. Null values or not
 * permitted in this collection. Iterating values from this collection will not
 * return correct values if at the same time there is adding or removal going
 * on. However ConcurrentLinkedDeque is good choice when we are looking for
 * adding and deleting in concurrent environment. 
 *
 * This is an implementation of a concurrent lock-free deque(Stack operations as
 * well) supporting interior removes but not interior insertions, as required to
 * support the entire Deque interface.
 *
 */
public class ConcurrentLinkedDequeTest {
	
	static ConcurrentLinkedDeque<String> cld=new ConcurrentLinkedDeque<String>();
	public static void main(String[] args) {
		ExecutorService exService = Executors.newFixedThreadPool(2);
		ThreadOne elementAdd = new ConcurrentLinkedDequeTest().new ThreadOne();
		ThreadTwo elementGet = new ConcurrentLinkedDequeTest().new ThreadTwo();
		exService.execute(elementAdd);
		exService.execute(elementGet);
		exService.shutdown();
	}
	class ThreadOne implements Runnable{
		@Override
		public void run() {
			for(int i=0;i<5;i++){
					cld.add("A"+i);
			}
		}
	}
	class ThreadTwo implements Runnable{
		@Override
		public void run() {
			for(int i=0;i<5;i++){
					String s= cld.poll();
					System.out.println("Element received is: "+s);
			}
		}
	}
}
 


