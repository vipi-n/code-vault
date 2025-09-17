
public class Printer {

    private int num = 1;
    private final int MAX = 10;
    private final Object lock = new Object();


    private void printEven() { // we can just do synchronized here and dont use lock as well
        synchronized (lock) {
            while (num < MAX) {
                if (num % 2 == 0) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("Thread: " +Thread.currentThread() +"Even: " + num);
                num++;
                lock.notify();
            }
        }
    }

    private void printOdd() {
        synchronized (lock) {
            while (num < MAX) {
                if (num % 2 != 0) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("Thread: " +Thread.currentThread() +"Odd: " + num);
                num++;
                lock.notify();
            }
        }
    }



    public static void main(String[] args) {

        Printer printer = new Printer();
        Thread thread1 = new Thread(() -> printer.printOdd());
        Thread thread2 = new Thread(() -> printer.printEven());

        thread1.start();
        thread2.start();
    }
}
