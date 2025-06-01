// https://leetcode.com/problems/add-two-numbers/

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

       ListNode prev =  new ListNode(0);
       ListNode head = prev;
       int carry = 0;

       while(l1 != null || l2 != null || carry != 0) {
        
        ListNode curr =  new ListNode(0);
        int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val: 0) + carry;
        curr.val = sum % 10;
        carry = sum / 10;
        prev.next = curr;
        prev = prev.next;

        if(l1 != null) l1 = l1.next;
        if(l2 != null) l2 = l2.next; 
       }
       return head.next;

    }
}
