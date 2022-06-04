package practice.linkedlist;

public class LinkedList {

    Node head;

    static class Node{
        int data;
        Node next;

        Node(int d){
            this.data = d;
            next = null;
        }
    }
    public void iteratorLinkedList(){
        Node n = head;
        while (n != null){
            System.out.println(n.data + " ");
            n = n.next;
        }
    }
    public void insert(Node head, int value, int pos){

        Node toAdd = new Node(value);

        if (pos == 0){
            toAdd.next = head;
            head = toAdd;
        }
        Node prev = head;

        for (int i = 0; i < pos - 1 ; i++) {
            prev = prev.next;
        }
        toAdd.next = prev.next;
        prev.next = toAdd;
    }

    public void delete(Node head, int pos){

        if (pos == 0){
            head = head.next;
            return;
        }

        Node prev = head;
        for (int i = 0; i <pos-1 ; i++) {
            prev = prev.next;
        }
        prev.next = prev.next.next;
        prev.next.next = null;
    }

    public static void main(String[] args) {

        LinkedList list = new LinkedList();

        list.head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);

        list.head.next = second;
        second.next = third;

        list.iteratorLinkedList();
        list.insert(list.head, 10,2);
        System.out.println("After Isertion");
        list.iteratorLinkedList();
        list.delete(list.head, 2);
        System.out.println("After Deletion");
        list.iteratorLinkedList();
        list.insert(list.head, 7,3);
        System.out.println("again After Isertion");
        list.iteratorLinkedList();

    }
}
