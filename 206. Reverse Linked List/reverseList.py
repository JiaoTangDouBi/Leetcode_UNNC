# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def reverseList_loop(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        # new_head -> ... -> head -> cur -> cur.next (temp)
        # cur -> new_head -> ... -> head -> temp
        new_head = None
        cur = head
        while cur is not None:
            # change links
            temp = cur.next
            cur.next = new_head
            head.next = temp
            # step next
            new_head = cur
            cur = temp
            
        return new_head
        
    def reverseList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        def reverse_list_helper(cur, prev):
            if cur is None:
                return prev
            temp = cur.next
            cur.next = prev
            return reverse_list_helper(temp, cur)
            
        return reverse_list_helper(head, None)
            
            
            