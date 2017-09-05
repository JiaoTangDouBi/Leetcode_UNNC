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
    //Travel the whole tree in in-order sequence.
    /*For every node there is an upper-bound and lower-bound number.
      In recursion steps, be careful to update those two boundaries recursively.
    */
    public boolean isValidBST(TreeNode root) {
        return InOrderTravel(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    public boolean InOrderTravel(TreeNode root, long low, long up){
        if(root == null){
            return true;
        }
        else{
            if(root.val < up && root.val > low){
                return InOrderTravel(root.left, low, root.val)&&InOrderTravel(root.right, root.val, up);
            }
            else{
                return false;
            }
        }
    }
}