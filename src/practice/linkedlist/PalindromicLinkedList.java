package practice.linkedlist;

public class PalindromicLinkedList {

    public static void main(String[] args) {

        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(3);
        Node six = new Node(2);
        Node seven = new Node(1);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;
        six.next = seven;

        System.out.println("the linkedList is : " + isPalindromic(one));
    }

    private static boolean isPalindromic(Node head) {

        if (head == null) return true;
        Node mid = middle(head);

/*        if (head.next.next == null){
            if (head.data == head.next.data) return true;
        }*/
        Node last = reverse(mid);

        Node curr = head;
        while (last != null){
            if (last.data != curr.data){
                return false;
            }
            curr = curr.next;
            last = last.next;
        }
        return true;
    }

    private static Node reverse(Node head){

        Node curr = head;
        Node prev = null;

        while (curr != null){
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;

    }
    private static Node middle(Node head){

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null){

            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
