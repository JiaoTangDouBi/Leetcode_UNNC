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
    //Instead of using recursion, this time we use iteration with the help from stack.
    public List<Integer> inorderTraversal(TreeNode root) {
        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> output = new ArrayList<Integer>();
        
        while(current != null || !stack.empty()){
            while(current != null){
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            output.add(current.val);
            current = current.right;
        }
        return output;
    }
}