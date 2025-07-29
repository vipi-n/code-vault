// https://leetcode.com/problems/rotate-list/
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
    public ListNode rotateRight(ListNode head, int k) {

        if(head == null || k == 0) return head;

        ListNode tail = head;
        int len = 1;

        while (tail.next != null) {
            tail = tail.next;
            len++;
        }

        if (k % len == 0) return head;
        k = k % len;
        // attach tail to head
        tail.next = head;
        ListNode newLastNode = findNthNode(head, len - k);
        head = newLastNode.next;
        newLastNode.next = null;

        return head;
    }

    public ListNode findNthNode(ListNode temp, int n) {
        int count = 1;
        while (temp != null) {
            if (count == n) {
                return temp;
            }
            temp = temp.next;
            count++;
        }
        return temp;
    }
}
