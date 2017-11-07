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
    //Solve this question by recursion
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;
        else{
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right=lowestCommonAncestor(root.right, p, q);
            
            if(left == null && right == null){
                return null;
            }
            if(left == null && right != null){
                return right;
            }
            if(left != null && right == null)
                return left;
            else
                return root;
        }
    }
}