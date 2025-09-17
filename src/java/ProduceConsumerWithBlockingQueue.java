

package org.example;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProduceConsumer {

    public static void main(String[] args) {

        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);

        Thread consumer = new Thread(() -> {
            for (int i = 1; i < 11; i++) {
                try {

                    int num = queue.take();
                    System.out.println("Consumed : " + num);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread producer = new Thread(() -> {
            for (int i = 1; i < 11; i++) {
                try {
                    queue.put(i);
                    System.out.println("Produced : " + i);
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        producer.start();
        consumer.start();
    }
}
