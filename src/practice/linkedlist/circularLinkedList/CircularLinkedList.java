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
        System.out.println(detectCycle(head));


    }

    public static Node detectCycle(Node head){

        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next; // 20 30
            fast = fast.next.next; //30 10
            if (slow == fast){
                return slow;
            }
        }
        return null;
    }
    public void removeCycle(Node head){

        Node detectedNode = detectCycle(head);
        Node start = head;
        Node prev = detectedNode;

        while(head != detectedNode){
           start = start.next;
           prev = detectedNode;
           detectedNode = detectedNode.next;
        }
        prev.next = null;

    }
}
class Node{
    int data;
    Node next;

    Node(int data){
        this.data = data;
    }
}
