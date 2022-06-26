package practice.linkedlist;

public class FindNthNodeFromTheEnd {

    public static void main(String[] args) {
        Node head = new Node(2);
        Node second = new Node(4);
        Node third = new Node(7);
        Node fourth = new Node(9);
        Node fifth = new Node(6);
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next =fifth;
        System.out.println(findFromEnd(head,2));
        System.out.println(find(head, 9));
    }

    public static int findFromEnd(Node head, int n){

        Node temp = head;
        int size = 0;

        while (temp != null){
            size++;
            temp = temp.next;
        }

        if (n > size) return -1;
        Node curr = head;
        for (int i = 1; i <= size - n ; i++) {
            curr = curr.next;
        }
        return curr.data;
    }

    // two pointers concept
    public static int find(Node head, int n){

        if (head == null) return -1;

        Node slow = head;
        Node fast = head;

        for (int i = 0; i < n ; i++) {
            if (fast == null) return -1;
            fast = fast.next;
        }
        if (fast == null)
        while (fast != null){
            slow = slow.next;
            fast = fast.next;
        }
        return slow.data;
    }
}
