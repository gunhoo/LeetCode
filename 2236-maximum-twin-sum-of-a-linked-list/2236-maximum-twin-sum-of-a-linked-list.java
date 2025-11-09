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
    public int pairSum(ListNode head) {
        int maxSum = 0;
        int total = 0;
        Map<Integer, Integer> map = new HashMap<>(); // index, value
        while(head != null){
            total++;
            map.put(total, head.val);
            head = head.next;
        }
        for(int i=total/2+1; i<=total; i++){
            maxSum = Math.max(maxSum, map.get(i)+map.get(total-i+1));
        }
        return maxSum;
    }
}