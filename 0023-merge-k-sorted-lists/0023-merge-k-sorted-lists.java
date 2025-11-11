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
        ListNode head = new ListNode(0);
        ListNode point = head;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>(){
            @Override
            public int compare(ListNode n1, ListNode n2){
                if(n1.val==n2.val) return 0;
                else if(n1.val>n2.val) return 1;
                else  return -1;
            }
        });

        for(ListNode node : lists) if(node!=null) pq.add(node);

        while(!pq.isEmpty()){
            ListNode node = pq.poll();
            point.next = node;
            point = point.next;
            node = node.next;
            if(node != null) pq.add(node);
        }
        
        return head.next;
    }
}