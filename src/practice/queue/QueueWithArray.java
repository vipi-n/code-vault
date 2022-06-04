package practice.queue;

public class QueueWithArray {

    int size;
    int cap;
    int[] arr;

    QueueWithArray(int c){
        cap = c;
        size = 0;
        arr = new int[size];
    }
    boolean isEmpty(){
        return size == 0;
    }

    boolean isFull(){
        return size == cap;
    }

    int getFront(){
        if (isEmpty()) return -1;
        return arr[0];
    }

    int getRear(){
        if (isEmpty()) return -1;
        return arr[size - 1];
    }
    void enqueue(int x){
        if (isFull()) return;
        arr[size] = x;
        size++;
    }
    void dequeue(){
        if (isEmpty()) return;
        for (int i = 0; i < size - 1; i++) {
            arr[i] = arr[i + 1];
            size --;
        }
    }
}
