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
    public ListNode middleNode(ListNode head) {
        int middle = 0;
        ListNode tmp = head;
        while(tmp.next != null){
            tmp = tmp.next;
            middle++;
        }
        for(int i = 0; i < (middle+1)/2 ; i++){
            head = head.next;
        }
        return head;
    }
}