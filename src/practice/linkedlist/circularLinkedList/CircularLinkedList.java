package practice.linkedlist.circularLinkedList;

public class CircularLinkedList {

    public static void main(String[] args) {

        Node head = new Node(10);
        Node first = new Node(20);
        Node second = new Node(30);
        Node third = new Node(40);

        head.next = first;
        first.next = second;
        second.next = third;
        third.next = head;


    }
}
class Node{
    int data;
    Node next;

    Node(int data){
        this.data = data;
    }
}
