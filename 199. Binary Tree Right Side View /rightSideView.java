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
    //Use the recursion
    /*For a given TreeNode, we also have an integer refers to the depth of its right-hand sibling.
      All the node in this sub-tree whose levels are not greater than its sibling depth are hidden.
      We only care about the nodes whose depth are more deeply.
      Firstly, check the right sub-tree of this tree and if the depth of it is greater than the given integer,
      travel the nodes and add it into output list and rember the depth because those extra nodes also block some deeper nodes in its left hand side.
      Now for the left sub-tree, the given integer should be the bigger value between the given intger and the depth of right sub-tree.
      Every time we move from the parent to its children, the value of given integer should decrease 1.
      Travel the whole tree top -> bottom until the leaves.
    */
    List<Integer> out = new ArrayList<Integer>();
    public List<Integer> rightSideView(TreeNode root) {
        rightSideViewHelp(root, 0);
        return out;
    }
    
    public int rightSideViewHelp(TreeNode root, int depth){
        if(root == null){
            return 0;
        }
        else{
            if(depth == 0){
                out.add(root.val);
                int rightDep = rightSideViewHelp(root.right, 0);
                int leftDep = rightSideViewHelp(root.left, rightDep);
                return 1 + Math.max(rightDep, leftDep);
            }
            else{
                int rightDep = rightSideViewHelp(root.right, depth-1);
                int leftDep = rightSideViewHelp(root.left, Math.max(depth-1, rightDep));
                return 1 + Math.max(rightDep, leftDep);
            }
        }
    }
}