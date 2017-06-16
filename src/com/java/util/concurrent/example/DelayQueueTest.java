package com.java.util.concurrent.example;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;

/*
 * Java DelayQueue is a collection and an implementation of BlockingQueue. Unlike ArrayBlockingQueue, DelayQueue is an unbounded collection. The BlockingQueue methods are implemented in such a way that only delay expired elements can be taken out of the queue. If the delay has not expired for any elements in the queue then the poll method will return null
 *Expiry of an element is decided using the getDelay() method of the element. When it returns a value less than or equal to zero that element is considered to be expired.
 *
 *public interface Delayed extends Comparable {

    long getDelay(TimeUnit unit);
}
 */
public class DelayQueueTest {
	public static void main(String[] args) {
		final BlockingQueue<DelayElement> queue = new DelayQueue<DelayElement>();

		DelayQueueProducer queueProducer = new DelayQueueProducer(queue);
		new Thread(queueProducer).start();

		DelayQueueConsumer queueConsumer1 = new DelayQueueConsumer(queue);
		new Thread(queueConsumer1).start();

		DelayQueueConsumer queueConsumer2 = new DelayQueueConsumer(queue);
		new Thread(queueConsumer2).start();

	}
}
