package practice.linkedlist.circularLinkedList;

public class CircularLinkedList {

    public static void main(String[] args) {

        Node head = new Node(10);
        Node first = new Node(20);
        Node second = new Node(30);
        Node third = new Node(40);
        // 10->20->30->40->10
        head.next = first;
        first.next = second;
        second.next = third;
        third.next = head;
        System.out.println(checkCircular(head));


    }

    public static boolean checkCircular(Node head){

        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next; // 20 30
            fast = fast.next.next; //30 10
            if (slow == fast){
                return true;
            }
        }
        return false;
    }
}
class Node{
    int data;
    Node next;

    Node(int data){
        this.data = data;
    }
}
