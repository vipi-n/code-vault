// https://leetcode.com/problems/reorder-list/description/

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
    public void reorderList(ListNode head) {

    if(head == null || head.next == null || head.next.next == null) return;
      // Devide the LL into 2 parts, find the mid, mid.next would be the 2ndHead of the 2nd LL, make mid.next= null so that 1st LL will be independent
      // now start inserting each node from 2nd LL into first LL
      // store the next nodes for both LL else it will be lost and use them as the new head once operation is done for 1 iteration
      // in the iteration, store the next node for both then assign firstHead.next to secondHead and secondHead.next = n1;
      // then make firstHead = n1 and secondHead = n2 because these will be now new head
       ListNode mid = mid(head);
       ListNode secondHead = reverse(mid.next);
       mid.next = null;
       ListNode firstHead = head;

       while(firstHead != null && secondHead != null) {
           ListNode n1 = firstHead.next;
           ListNode n2 = secondHead.next;

           firstHead.next = secondHead;
           secondHead.next = n1;

           firstHead = n1;
           secondHead = n2;
       }

       
    }

    public ListNode mid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
               
               slow = slow.next;
               fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverse(ListNode head) { 
        
        ListNode prev = null;
        ListNode curr = head;

        while(curr != null) {

            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}
