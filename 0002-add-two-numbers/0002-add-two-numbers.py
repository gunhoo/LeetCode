# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        carry = 0
        dummyHead = ListNode(0)
        idx = dummyHead
        while(l1 != None or l2 != None or carry != 0):
            a = l1.val if l1 else 0
            b = l2.val if l2 else 0
            sum_val = a+b+carry
            carry = sum_val // 10
            newNode = ListNode(sum_val % 10)
            idx.next = newNode
            idx = newNode
            l1 = l1.next if l1 else None
            l2 = l2.next if l2 else None
        return dummyHead.next