/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int maxDepth(TreeNode root) {
       int n = 0;
       if (root!= null){
        n++;
        int a = maxDepth(root.left);
        int b = maxDepth(root.right);
        if (a>b){
            return n+a;
        }
        else {
            return n+b;
        }
       }
       else {
           return n;
       }
       
    }
}