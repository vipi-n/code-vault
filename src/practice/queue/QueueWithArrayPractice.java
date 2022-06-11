package practice.queue;

public class QueueWithArrayPractice {

    int arr[];
    int cap; // capacity of an array
    int size; // current size of an array

    public QueueWithArrayPractice(int cap){
        this.cap = cap;
        this.size = 0;
        arr = new int[cap];
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public boolean isFull(){
        return size == cap;
    }
    public int getFront(){
        if (isEmpty()) return -1;
        return arr[0];
    }
    public int getRear(){
        if (isEmpty()) return -1;
        return arr[size -1];
    }
    public void enqueue(int x){
        if (isFull()) return ;
        arr[size] = x;
        size++;
    }
    public int dequeue(){
        if (isEmpty()) return -1;
        int res = arr[0];
        for (int i = 0; i < arr.length -1; i++) {
            arr[i] = arr[i+1];
        }
        size--;
        return res;
    }

    public static void main(String[] args) {
        QueueWithArrayPractice queue = new QueueWithArrayPractice(1000);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);

        System.out.println(queue.dequeue()+ " dequeued from queue\n");
        System.out.println("Front item is " + queue.getFront());
        System.out.println("Rear item is " + queue.getRear());
    }
}
