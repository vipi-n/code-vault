package practice.linkedlist;

public class SortedInsert {

    public static void main(String[] args) {

        Node head = new Node(2);
        Node second = new Node(4);
        Node third = new Node(7);
        head.next = second;
        second.next = third;

        Node newHead = insertSorted(head,1);
        iterateWithRecursion(newHead);
    }

    public static Node insertSorted(Node head, int data){

        Node curr = head;
        Node toAdd = new Node(data);

        if (head == null) {
            return toAdd;
        }
        if (data < head.data){
            toAdd.next = head;
            return toAdd;
        }
        while (curr.next != null && curr.next.data < data){
            curr = curr.next;
        }
        toAdd.next = curr.next;
        curr.next = toAdd;
        return head;

        }

    public static void iterateWithRecursion(Node head){

        if (head == null) return;

        System.out.println(head.data);
        iterateWithRecursion(head.next);
    }

        }