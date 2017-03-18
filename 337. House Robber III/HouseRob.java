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
    //Use dynamic programming
    //OPT[a] refers to the maximum property a thief can rob from a tree map whose root is a.
    //So there are only two possible selection for thief at a:
    //1. rob it: OPT[a] = a+OPT[a.left.left]+OPT[a.left.right]+OPT[a.right.left]+OPT[a.right.right]
    //2. does not rob it: OPT[a] = OPT[a.left]+OPT[a.right]
    public int rob(TreeNode root) {
        int[] result = recurrence(root);
        return Math.max(result[0], result[1] );
    }
    //use an array with size of 2 to record the maximum value for selecting root house or not respectively.
    /*0 - select
      1 - not select
    */
    public int[] recurrence(TreeNode root){
        int[] output = new int[2];
        if(root == null)
            return output;
        else{
            int[] left = recurrence(root.left);
            int[] right= recurrence(root.right);
            output[0] = root.val + left[1] + right[1];
            output[1] = Math.max(left[0] + right[0], left[1]+right[0]);
            int temp  = Math.max(left[0]+right[1],left[1]+right[1]);
            output[1] = Math.max(output[1], temp);
            return output;
        }
    }
}