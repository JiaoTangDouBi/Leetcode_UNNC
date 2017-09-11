/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    //Inorder traversal the tree and Convert the tree to a string and mark the null node to X.
    //Use comma(,) to split each node.
    //Then use a stack to rebuild the tree in deserialize func.
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String s = buildString(root);
        return s.substring(0, s.length()-1);
    }
    
    public String buildString(TreeNode root){
        if (root == null)
            return "X,";
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(root.val) + ",");
        sb.append(buildString(root.left));
        sb.append(buildString(root.right));
        
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        if(nodes.length == 1)   
            return null;
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        TreeNode iter = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        stack.add(root);
        boolean right = false;
        for(int i = 1; i < nodes.length; i++){
            if(nodes[i].equals("X")){
                iter = stack.pop();
                right = true;
            }
            else{
                if(right){
                    iter.right = new TreeNode(Integer.parseInt(nodes[i]));
                    iter = iter.right;
                    right = false;
                }
                else{
                    iter.left = new TreeNode(Integer.parseInt(nodes[i]));
                    iter = iter.left;
                }
                stack.push(iter);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));