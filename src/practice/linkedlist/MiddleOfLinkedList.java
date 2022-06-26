package practice.linkedlist;

public class MiddleOfLinkedList {

    public static void main(String[] args) {

        Node head = new Node(2);
        Node second = new Node(4);
        Node third = new Node(7);
        head.next = second;
        second.next = third;
        System.out.println(findMiddle(head).data);
    }
    public static Node findMiddle(Node head){

        if (head == null) return null;

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
