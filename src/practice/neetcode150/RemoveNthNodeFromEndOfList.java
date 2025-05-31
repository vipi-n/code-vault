// https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode curr = head;
        int size = 0;

        // Count the length
        while (curr != null) {
            curr = curr.next;
            size++;
        }

        // If head needs to be removed
        if (n == size) {
            return head.next;
        }

        // Go to the (size - n)th node
        curr = head;
        for (int i = 1; i < size - n; i++) {
            curr = curr.next;
        }

        // Remove the nth node from end
        curr.next = curr.next.next;

        return head;
    }
}
