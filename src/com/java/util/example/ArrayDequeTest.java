package com.java.util.example;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Resizable-array implementation of the {@link Deque} interface.  Array
 * deques have no capacity restrictions; they grow as necessary to support
 * usage.  They are not thread-safe; in the absence of external
 * synchronization, they do not support concurrent access by multiple threads.
 * Null elements are prohibited.  This class is likely to be faster than
 * {@link Stack} when used as a stack, and faster than {@link LinkedList}
 * when used as a queue.
 * 
 * ArrayDeque<E> extends AbstractCollection<E>
 *                          implements Deque<E>, Cloneable, Serializable
 * Deque<E> extends Queue<E> 
 *   
 * Deque -A linear collection that supports element insertion and removal at
 * both ends.  The name <i>deque</i> is short for "double ended queue"
 * and is usually pronounced "deck".  Most {@code Deque}
 * implementations place no fixed limits on the number of elements
 * they may contain, but this interface supports capacity-restricted
 * deques as well as those with no fixed size limit.
 * 
 * Queue functionality implemented:
 * 
 * This interface extends the {@link Queue} interface.  When a deque is
 * used as a queue, FIFO (First-In-First-Out) behavior results.  Elements are
 * added at the end of the deque and removed from the beginning.  The methods
 * inherited from the {@code Queue} interface are precisely equivalent to
 * {@code Deque} methods
 * 
 * Stack functionality implemented:
 * 
 * Deques can also be used as LIFO (Last-In-First-Out) stacks.  This
 * interface should be used in preference to the legacy {@link Stack} class.
 * When a deque is used as a stack, elements are pushed and popped from the
 * beginning of the deque.  Stack methods are precisely equivalent to
 * {@code Deque} methods
 *   
 * @author Robert Rosario
 *
 */
public class ArrayDequeTest {
	
public static void main(String... args){
	
		ArrayDeque<String> aq= new ArrayDeque<String>();
		aq.add("A");
		aq.add("B");
		aq.add("C");
		
		//offerFirst-adds elements at the front of the ArrayDeque 
		aq.offerFirst("D");
		
		//offerLast inserts the element at the last of ArrayDeque 
		aq.offerLast("E");
		
		aq.addFirst("R");
		aq.addLast("O");
		
		//Queue operations
		//Poll -Retrieves and removes the head of this queue,or returns {@code null} if this queue is empty
	    System.out.println(aq.poll());
		System.out.println(aq.element());
		System.out.println(aq.peek());
		System.out.println(aq);
		
		
		aq.forEach(System.out::println);
		
		
/**
 * Out put
* 	R
	D
	D
	[D, A, B, C, E, O]
	D
	A
	B
	C
	E
	O
		 */
	}

}
