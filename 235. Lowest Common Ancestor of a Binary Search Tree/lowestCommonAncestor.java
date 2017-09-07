/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    //if p.val < root < q.val || p.val > root > q.val, then return root.
    //if p.val < root && p.val <root, then  move to the root.left and solve this problem recursively.
    //o/w, move to the right branch.
    TreeNode result = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == p || root == q)
            return root;
        else{
            if ((p.val < root.val && root.val < q.val) || (p.val > root.val && root.val > q.val))
                return root;
            else if(p.val < root.val && q.val < root.val)
                return lowestCommonAncestor(root.left, p, q);
            else
                return lowestCommonAncestor(root.right,p, q);
        }
    }
}