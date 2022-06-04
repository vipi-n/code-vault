package practice.linkedlist;

public class ReverseLinkedList {

    public static void main(String[] args) {
        Node head = new Node(2);
        Node second = new Node(4);
        Node third = new Node(6);
        Node fourth = new Node(10);
        head.next = second;
        second.next = third;
        third.next = fourth;

        System.out.println("LinkedList before reverse :");
        iterate(head);
        System.out.println("LinkedList after reverse :");
        Node reverseHead = reverse(head);
        iterate(reverseHead);
    }

    public static Node reverse(Node head){

        Node curr = head;
        Node pre = null;

        while (curr != null){

            Node temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        return pre;
    }

    public static void iterate(Node head){
        Node curr = head;
        while (curr != null){
            System.out.println(curr.data);
            curr = curr.next;
        }
    }
    static class Node{

        Node next;
        int data;
        Node(int data){
            this.data = data;
            next = null;
        }
    }
}
