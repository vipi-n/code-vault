package practice.linkedlist;

// TC O(n) for both iterative or recursive but in recursive we need O(n) auxiliary space due to call stack
// O(logn) is not possible in LL because we cannot find mid node in constant time
public class SearchInLinkedList {
    public static void main(String[] args) {

        Node head = new Node(15);
        Node first = new Node(20);
        Node second = new Node(3);
        head.next = first;
        first.next = second;

        System.out.println(iterativeSearch(head, -20));
        System.out.println(recursiveSearch(head,3));
    }

    public static int iterativeSearch(Node head, int key){

        Node node = head;
        int count = 0;
        while (node != null){
            if (node.data == key){
                return count;
            }else{
                count++;
                node = node.next;
            }
        }
        return -1;
    }

    public static int recursiveSearch(Node head, int key){

        if (head == null) return -1;
        if (head.data == key) {
            return 0;
        }

        int res =  recursiveSearch(head.next, key);
        if (res == -1) return -1;
        else return res + 1;

    }
}
