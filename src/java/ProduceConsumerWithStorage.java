package org.example;

import java.util.LinkedList;
import java.util.Queue;

public class ProduceConsumerWithStorage {

    int capacity = 0;
    Queue<Integer> queue = new LinkedList<>();

    ProduceConsumer(int capacity) {
        this.capacity = capacity;
    }

    private synchronized void produce(int n) throws InterruptedException {
        while (queue.size() == capacity) {
            wait();
        }
        queue.add(n);
        System.out.println("Produced: " + queue.peek());
        notify();
    }

    private synchronized void consume() throws InterruptedException {
        while (queue.isEmpty()) {
            wait();
        }
        System.out.println("Consumed: " + queue.poll());
        notify();
    }

    public static void main(String[] args) {
        ProduceConsumer produceConsumer = new ProduceConsumer(10);

        Thread consumer = new Thread(() -> {
            for (int i = 1; i < 11; i++) {
                try {
                    produceConsumer.consume();
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread producer = new Thread(() -> {
            for (int i = 1; i < 11; i++) {
                try {
                    produceConsumer.produce(i);
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
