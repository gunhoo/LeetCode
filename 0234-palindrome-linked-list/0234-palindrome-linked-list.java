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
    public boolean isPalindrome(ListNode head) {
        int mid = 0;
        ListNode tmp = head;
        ArrayDeque<Integer> total = new ArrayDeque<>();
        
        while(tmp.next != null){
            total.add(tmp.val);
            tmp = tmp.next;
            mid++;
        }
        total.add(tmp.val);
        for(int i = 0 ; i < (mid+1)/2 ; i++){
            if(head.val != total.removeLast()) return false;
            head = head.next;
        }
        return true;
    }
}