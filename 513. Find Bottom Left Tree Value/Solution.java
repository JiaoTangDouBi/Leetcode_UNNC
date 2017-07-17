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
    public int findBottomLeftValue(TreeNode root) {
        int[] temp = findBottomLeftValueHelp(root, 0);
        return temp[0];
    }
    public int[] findBottomLeftValueHelp(TreeNode root, int depth){
        int[] output = new int[2]; int[] left = new int[2]; int[] right = new int[2];
        output[0] = root.val;
        output[1] = depth;

        if(root.left != null){
            left = findBottomLeftValueHelp(root.left, depth+1);
        }
        if(root.right!= null)
            right= findBottomLeftValueHelp(root.right,depth+1);
        
        if(left[1] == 0 && right[1] == 0){
            return output;
        }
        else{
            if(left[1] >= right[1]){
                return left;
            }
            else{
                return right;
            }
        }
    }
}