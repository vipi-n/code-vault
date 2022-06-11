package practice.queue;

public class QueueWithCircularArray {
    int arr[];
    int front;
    int cap;
    int size;
    int rear;

    QueueWithCircularArray(int cap){
        this.cap = cap;
        arr = new int[cap];
        front = size = 0;
        rear = cap - 1;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public boolean isFull(){
        return size == cap;
    }
    public int getFront(){
        if (isEmpty()) return -1;
        return arr[front];
    }
    public int getRear(){
        if (isEmpty()) return -1;
        int rear = (front + size -1) % cap;
        return arr[rear];
    }
    public void enqueue(int x){
        if (isFull()) return ;
        int rear = getRear();
        rear = (rear + 1) % cap;
        arr[rear] = x;
        size++;
    }

    public int dequeue(){
        if (isEmpty()) return -1;
        front = (front + 1) % cap;
        size--;
        return front;
    }

    public static void main(String[] args) {
        QueueWithCircularArray queue = new QueueWithCircularArray(1000);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);

        System.out.println(queue.dequeue()+ " dequeued from queue\n");
        System.out.println("Front item is " + queue.getFront());
        System.out.println("Rear item is " + queue.getRear());
    }

}
