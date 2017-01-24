# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

from collections import deque
class Solution(object):
    def lowestCommonAncestor_rev(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """
        if root in (None, p, q):
            return root
        
        left = self.lowestCommonAncestor(root.left, p, q)
        right = self.lowestCommonAncestor(root.right, p, q)
        
        # find both p and q
        if left and right:
            return root
        # return None if nor, or return p or q
        else:
            return left or right
    
    # super slow?????
    def lowestCommonAncestor(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """
        def path(root, target):
            stack = deque([([root], root)])
            while stack:
                (path, node) = stack.pop()
                if node != target:
                    if node.right:
                        stack.append((path + [node.right], node.right))
                    if node.left:
                        stack.append((path + [node.left], node.left))
                else:
                    break
            return path
            
        if root in (None, p, q):
            return root
        
        path_p = path(root, p)
        path_q = path(root, q)
        
        i = 0
        while i < len(path_p) and i < len(path_q):
            pp = path_p[i]
            pq = path_q[i]
            if pp == pq:
                i += 1
            else:
                break
                
        return path_p[i-1]
    
    
    