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

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        
        if(root==null)
            return sb.toString();
        preorder(root,sb);
        return sb.toString();
    }
    
    void preorder(TreeNode node,StringBuilder sb){
        if(node==null){
           sb.append("#").append(",");
            return;
    }
        
        sb.append(node.val).append(",");
        preorder(node.left,sb);
        preorder(node.right,sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length()==0)
            return null;
        Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
        
        return deserialize(q);
    }
    
    TreeNode deserialize(Queue<String> q){
        String  valStr = q.poll();
        if(valStr==null||"#".equals(valStr))
            return null;
        
        TreeNode node = new TreeNode(Integer.parseInt(valStr));
        node.left = deserialize(q);
        node.right = deserialize(q);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));