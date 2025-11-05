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
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while(head != null){
            ListNode next = new ListNode();
            next.val = head.val;
            next.next = prev;
            prev = next;
            head = head.next;
        }
        return prev;

    }
}