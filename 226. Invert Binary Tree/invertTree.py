# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
from collections import deque
class Solution(object):
    def invertTree_re(self, root):
        """
        :type root: TreeNode
        :rtype: TreeNode
        """
        if root is None:
            return None
        root.left, root.right = self.invertTree(root.right), self.invertTree(root.left)
        return root
        
    def invertTree_dfs(self, root):
        """
        :type root: TreeNode
        :rtype: TreeNode
        """
        if root is None:
            return root
        # DFS
        stack = deque([root])
        while stack:
            node = stack.pop()
            node.right, node.left = node.left, node.right
            if node.right:
                stack.append(node.right)
            if node.left:
                stack.append(node.left)
        return root
        
    def invertTree(self, root):
            """
            :type root: TreeNode
            :rtype: TreeNode
            """
            if root is None:
                return root
            # BFS
            queue = deque([root])
            while queue:
                node = queue.popleft()
                node.right, node.left = node.left, node.right
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
            return root