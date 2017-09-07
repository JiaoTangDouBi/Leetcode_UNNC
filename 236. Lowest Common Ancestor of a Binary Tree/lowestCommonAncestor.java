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
    //if p and q seperate in twoo diff branches, return root.
    //o/w we only need to check one sub-branch recursively.
    //when either p or q is the answer, we will output p/q directly.
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q){
            return root;
        }
        else{
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right=lowestCommonAncestor(root.right, p, q);
            //p and q are in different branches
            if(left != null && right != null){
                return root;
            }
            else{
                if(left == null){
                    return right;
                }
                else
                    return left;
            }
        }
    }
}