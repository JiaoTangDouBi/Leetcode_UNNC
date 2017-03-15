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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> output = new LinkedList<Integer>();
        TreeNode cur = root;
        Stack<TreeNode> s = new Stack<TreeNode>();
        
        while(cur != null || !s.empty() ){
            while(cur!=null){
                output.add(cur.val);
                s.add(cur);
                cur=cur.left;
            }
            cur = s.pop();
            cur = cur.right;
        }
        return output;
    }
}