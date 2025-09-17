
public class ProduceConsumer {
    int n = 0;
    boolean available = false; // false = empty, true = full

    private synchronized void produce(int n) throws InterruptedException {
        while (available) {   // if buffer full, wait
            wait();
        }
        this.n = n;
        System.out.println("Produced: " + n);
        available = true;     // mark as full
        notify();
    }

    private synchronized void consume() throws InterruptedException {
        while (!available) {  // if buffer empty, wait
            wait();
        }
        System.out.println("Consumed: " + n);
        available = false;    // mark as empty
        notify();
    }

    public static void main(String[] args) {
        ProduceConsumer produceConsumer = new ProduceConsumer();

        Thread consumer = new Thread(() -> {
            while (true) {
                try {
                    produceConsumer.consume();
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread producer = new Thread(() -> {
            int n = 1;
            while (true) {
                try {
                    produceConsumer.produce(n++);
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
