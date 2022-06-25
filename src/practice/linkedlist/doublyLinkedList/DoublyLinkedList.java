package practice.linkedlist.doublyLinkedList;

/**
 * traversing in browser - can traverse in both direction
 * can delete a node in O(1) time
 * can insert or delete before any node in O(1) time
 * insert and delete both end with O(1) time
 * extra space for prev
 * code becomes more complex
 */
public class DoublyLinkedList {

    public static void main(String[] args) {
        Node head = new Node(10);
        Node first = new Node(20);
        Node second = new Node(30);

        head.next = first;
        first.prev = head;
        first.next = second;
        second.prev = first;
    }

}
class Node{
    Node next;
    Node prev;
    int data;

    Node(int data){
        this.data = data;
        prev = null; // optional
        next = null; // optional
    }
}