# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def swapPairs(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        result = pre = ListNode(0)
        pre.next = head
        while pre.next and pre.next.next:
            #    pre -> first -> second -> second.next
            # => pre -> second -> first -> second.next
            first = pre.next
            second = first.next
            pre.next, second.next, first.next = second, first, second.next
            pre = first
        return result.next