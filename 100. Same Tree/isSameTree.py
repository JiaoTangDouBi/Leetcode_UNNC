# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

from collections import deque

class Solution(object):
    def isSameTree(self, p, q):
        """
        :type p: TreeNode
        :type q: TreeNode
        :rtype: bool
        """
        if p is None or q is None:
            return p == q
            
        stack = deque([(p, q)])
        while stack:
            (node_p, node_q) = stack.pop()
            if node_p is None and node_q is None:
                continue
            elif node_p is None or node_q is None:
                return False
            elif node_p.val != node_q.val:
                return False
            else:
                stack.append((node_p.right, node_q.right))
                stack.append((node_p.left, node_q.left))
        return True