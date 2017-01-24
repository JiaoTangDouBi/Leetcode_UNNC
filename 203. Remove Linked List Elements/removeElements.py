# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    # RuntimeError: maximum recursion depth exceeded
    # def removeElements_re(self, head, val):
    #     """
    #     :type head: ListNode
    #     :type val: int
    #     :rtype: ListNode
    #     """
    #     if not head:
    #         return head
        
    #     head.next = self.removeElements(head.next, val)
        
    #     if head.val == val:
    #         return head.next
    #     else:
    #         return head
    def removeElements(self, head, val):
            """
            :type head: ListNode
            :type val: int
            :rtype: ListNode
            """
            head, head.next = ListNode(0), head
            cur = head
            while cur.next:
                if cur.next.val == val:
                    cur.next = cur.next.next
                else:
                    cur = cur.next
            return head.next