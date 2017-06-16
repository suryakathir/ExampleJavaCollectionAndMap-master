package com.java.util.example;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

import com.java.util.utility.Customer;

/**
 * PriorityQueue class was introduced in Java 1.5 and it’s part of Java
 * Collections Framework.
 *
 * PriorityQueue is an unbounded queue based on a priority heap and the elements
 * of the priority queue are ordered by default in natural order. We can provide
 * a Comparator for ordering at the time of instantiation of priority queue.
 *
 * Java Priority Queue doesn’t allow null values and we can’t create
 * PriorityQueue of Objects that are non-comparable. We use java Comparable and
 * Comparator for sorting Objects and Priority Queue use them for priority
 * processing of it’s elements.
 *
 * The head of the priority queue is the least element based on the natural
 * ordering or comparator based ordering, if there are multiple objects with
 * same ordering, then it can poll any one of them randomly. When we poll the
 * queue, it returns the head object from the queue.
 *
 * Java Priority Queue size is unbounded but we can specify the initial capacity
 * at the time of it’s creation. When we add elements to the priority queue,
 * it’s capacity grows automatically.
 *
 * PriorityQueue is not thread safe, so java provides PriorityBlockingQueue
 * class that implements the BlockingQueue interface to use in java
 * multithreading environment.
 * 
 * For example:
 * let’s say we have an application that generates stocks reports
 * for daily trading session. This application processes a lot of data and takes
 * time to process it. So customers are sending request to the application that
 * is actually getting queued but we want to process premium customers first and
 * standard customers after them. So in this case PriorityQueue implementation
 * in java can be really helpful.
 * 
 * 
 */
public class PriorityQueueTest {
	public static void main(String[] args) {

		// natural ordering example of priority queue
		Queue<Integer> integerPriorityQueue = new PriorityQueue<>(7);
		Random rand = new Random();
		for (int i = 0; i < 7; i++) {
			integerPriorityQueue.add(new Integer(rand.nextInt(100)));
		}
		for (int i = 0; i < 7; i++) {
			Integer in = integerPriorityQueue.poll();
			System.out.println("Processing Integer:" + in);
		}

		// PriorityQueue example with Comparator
		Queue<Customer> customerPriorityQueue = new PriorityQueue<>(7, idComparator);
		addDataToQueue(customerPriorityQueue);

		pollDataFromQueue(customerPriorityQueue);

	}

	// Comparator anonymous class implementation
	public static Comparator<Customer> idComparator = new Comparator<Customer>() {

		@Override
		public int compare(Customer c1, Customer c2) {
			return (int) (c1.getId() - c2.getId());
		}
	};

	// utility method to add random data to Queue
	private static void addDataToQueue(Queue<Customer> customerPriorityQueue) {
		Random rand = new Random();
		for (int i = 0; i < 7; i++) {
			int id = rand.nextInt(100);
			customerPriorityQueue.add(new Customer(id, "Pankaj " + id));
		}
	}

	// utility method to poll data from queue
	private static void pollDataFromQueue(Queue<Customer> customerPriorityQueue) {
		while (true) {
			Customer cust = customerPriorityQueue.poll();
			if (cust == null)
				break;
			System.out.println("Processing Customer with ID=" + cust.getId());
		}
	}

}
