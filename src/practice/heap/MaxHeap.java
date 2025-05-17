// Implement max heap

public class MaxHeap {

    int size = 0;
    int capacity = 0;
    int[] heap;

    public MaxHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        heap = new int[capacity];
    }

    public int parent(int i) {
        return (i - 1) / 2;
    }
    public int left(int i) {
        return 2 * i + 1;
    }

    public int right(int i) {
        return 2 * i + 2;
    }

    public void insert(int val) {

        if(size == capacity) return;
        heap[size] = val;
        int  i = size;
        size++;

        while(i != 0 && heap[parent(i)] < heap[i]) {
            swap(i, parent(i));
            i = parent(i);
        }


    }
    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(10);
        maxHeap.insert(3);
        maxHeap.insert(2);
        maxHeap.insert(15);
        maxHeap.insert(20);

        maxHeap.printHeap();
    }

    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
    }
}
