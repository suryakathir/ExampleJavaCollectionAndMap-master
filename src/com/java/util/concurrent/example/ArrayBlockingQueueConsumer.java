package com.java.util.concurrent.example;

import java.util.concurrent.BlockingQueue;

import com.java.util.utility.Message;

public class ArrayBlockingQueueConsumer implements Runnable{

private BlockingQueue<Message> queue;
    
    public ArrayBlockingQueueConsumer(BlockingQueue<Message> q){
        this.queue=q;
    }

    @Override
    public void run() {
        try{
            Message msg;
            //consuming messages until exit message is received
            while((msg = queue.take()).getMsg() !="exit"){
            Thread.sleep(10);
            System.out.println("Consumed "+msg.getMsg());
            }
        }catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}