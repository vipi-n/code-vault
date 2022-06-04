package practice.stack;

public class StackWithLinkedList {

    static class Node{

        Node next;
        int data;

        Node(int data){
            this.data = data;
            next = null;
        }
    }

    Node head;
    int size;

    StackWithLinkedList(){
        head = null;
        size = 0;
    }

    int size(){
        return size;
    }

    boolean isEmpty(){
        return head == null;
    }

    void push(int data){
        Node curr = new Node(data);
        curr.next = head;
        head = curr;
        size++;
    }

    int pop(){
        if (head == null) return Integer.MAX_VALUE;
        int res = head.data;
        head = head.next;
        size--;
        return res;
    }

    int peek(){
        if (head == null) return Integer.MIN_VALUE;
        return head.data;
    }

    public static void main(String[] args) {

        StackWithLinkedList s=new StackWithLinkedList();
        s.push(5);
        s.push(10);
        s.push(20);
        System.out.println(s.pop());
        System.out.println(s.size());
        System.out.println(s.peek());
        System.out.println(s.isEmpty());
    }
}

