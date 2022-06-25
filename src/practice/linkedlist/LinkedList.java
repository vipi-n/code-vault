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
    //O(n)
    public void iteratorLinkedList(Node head){
        Node n = head;
        while (n != null){
            System.out.println(n.data + " ");
            n = n.next;
        }
    }

    public void iterateWithRecursion(Node head){

        if (head == null) return;

        System.out.println(head.data);
        iterateWithRecursion(head.next);
    }

    // O(1)
    public Node insertAtBegining(Node head, int val){
        Node node = new Node(val);
        node.next = head;

        return node;
    }

    // O(n)
    public Node insertAtEnd(Node head, int val){
        Node node = new Node(val);
        if (head == null) return node;

        Node prev = head;
        while (prev.next != null){
            prev = prev.next;
        }
        prev.next = node;
        return head;
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
    // handled all the cases
    public Node insertAtGivenPos(Node head, int value, int pos){

        Node toAdd = new Node(value);
        if (pos == 0){
             toAdd.next = head;
             return toAdd;
        }
        Node prev = head;
        for (int i = 0; i < pos - 1 && prev != null; i++) {
            prev = prev.next;
        }
        if (prev == null) {
            return head;
        }
        toAdd.next = prev.next;
        prev.next = toAdd;
        return head;
    }

    // O(1)
    public Node deleteHeadNode(Node head){
        if (head == null) return null;
        return head.next;
    }

    // theta(n)
    public Node deleteLastNode(Node head){
        if (head == null || head.next == null) return null;

        Node prev = head;
        while (prev.next.next != null){
            prev = prev.next;
        }
        prev.next = null;
        return head;
    }

    public void delete(Node head, int pos){

        if (pos == 0){
            head = head.next;
            return;
        }

        Node prev = head;
        for (int i = 0; i < pos-1 ; i++) {
            prev = prev.next;
        }
        prev.next = prev.next.next;
        prev.next.next = null;
    }

    public static void main(String[] args) {

        LinkedList list = new LinkedList();

/*        Node head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);

        head.next = second;
        second.next = third;*/

        /*list.iteratorLinkedList(head);
        list.insert(list.head, 10,2);
        System.out.println("After Isertion");
        list.iteratorLinkedList();
        list.delete(list.head, 2);
        System.out.println("After Deletion");
        list.iteratorLinkedList();
        list.insert(list.head, 7,3);
        System.out.println("again After Isertion");
        list.iteratorLinkedList();
        System.out.println("----------------");
        list.iterateWithRecursion(head);*/
        System.out.println("Inserting at begining : ");
        Node head = null;

        /*head = list.insertAtBegining(head,30);
        head = list.insertAtBegining(head,40);
        head = list.insertAtBegining(head, 50);*/

        head = list.insertAtEnd(head, 10);
        head = list.insertAtEnd(head, 20);
        Node newHead = list.insertAtGivenPos(head, 45,15);


        list.iterateWithRecursion(newHead);

    }
}
