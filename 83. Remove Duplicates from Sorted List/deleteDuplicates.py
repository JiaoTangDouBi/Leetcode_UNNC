# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def deleteDuplicates(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        ptr = head
        while ptr and ptr.next:
            while ptr.next and ptr.val == ptr.next.val:
                ptr.next = ptr.next.next
            ptr = ptr.next
        return head
        