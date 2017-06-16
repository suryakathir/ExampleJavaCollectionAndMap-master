package com.java.util.concurrent.example;

import java.util.concurrent.BlockingQueue;

import com.java.util.utility.Message;

public class ArrayBlockingQueueProducer implements Runnable {
private BlockingQueue<Message> queue;
    
    public ArrayBlockingQueueProducer(BlockingQueue<Message> q){
        this.queue=q;
    }
    @Override
    public void run() {
        //produce messages
        for(int i=0; i<100; i++){
            Message msg = new Message(""+i);
            try {
                Thread.sleep(i);
                queue.put(msg);
                System.out.println("Produced "+msg.getMsg());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
        }
        //adding exit message
       
        Message msg = new Message("exit");
        try {
            queue.put(msg);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}