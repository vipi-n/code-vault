//https://leetcode.com/problems/merge-k-sorted-lists/

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
    public ListNode mergeKLists(ListNode[] lists) {

        if(lists == null || lists.length == 0) return null;

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        PriorityQueue<ListNode> pq = 
        new PriorityQueue<ListNode>(lists.length, (a, b) -> a.val - b.val);

        for(ListNode list : lists) {

            if(list != null) {
               pq.add(list); 
            }
        }
        while(!pq.isEmpty()) {
            tail.next = pq.poll();
            tail = tail.next;

               if(tail.next != null) {
                 pq.add(tail.next);
                }
            }
        return dummy.next;
    }
}
