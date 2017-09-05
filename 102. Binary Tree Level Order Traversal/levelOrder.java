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
    //Travel the tree level by level.
    List<List<Integer>> output;
    public List<List<Integer>> levelOrder(TreeNode root) {
        output = new ArrayList<List<Integer>>();
        iterateTree(root, 1);
        return output;
    }
    
    public void iterateTree(TreeNode root, int lv){
        if(root == null){
            return;
        }
        else{
            if(output.size()<lv){
                List<Integer> temp = new ArrayList<>();
                temp.add(root.val);
                output.add(temp);
            }
            else{
                List<Integer> temp = output.get(lv-1);
                temp.add(root.val);
            }
            
            iterateTree(root.left, lv+1);
            iterateTree(root.right,lv+1);
            return;
        }
    }
}