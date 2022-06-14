package practice.linkedlist;


public class MidOfLinkedList {

    public static void main(String[] args) {

        Node head = new Node(3);
        Node second = new Node(4);
        Node third = new Node(6);
        Node fourth = new Node(10);
        Node fifth = new Node(20);
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;

        System.out.println("middle is : " +middle(head).data);
    }

    private static Node middle(Node head) {

        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
