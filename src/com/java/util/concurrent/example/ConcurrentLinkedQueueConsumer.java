package com.java.util.concurrent.example;

import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentLinkedQueueConsumer implements Runnable {
	 
	   ConcurrentLinkedQueue<String> queue;
	   ConcurrentLinkedQueueConsumer(ConcurrentLinkedQueue<String> queue){
	      this.queue = queue;
	   }
	   public void run() {
	      String str;
	      System.out.println("Consumer Started");
	      for (int x = 0; x < 10; x++) {
	         while ((str = queue.poll()) != null) {
	            System.out.println("Removed: " + str);
	         }
	         try {
	            Thread.currentThread().sleep(500);
	         } catch (Exception ex) {
	            ex.printStackTrace();
	         }
	      }
	   }
	}
