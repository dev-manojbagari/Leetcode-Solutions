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
        
        serialize(root,sb);
        
        return sb.toString();
    }

    private void serialize(TreeNode root,StringBuilder sb){
        if(root==null){
            sb.append("#,");
            return;
        }
        
        sb.append(root.val+",");
        
        serialize(root.left,sb);
        serialize(root.right,sb);
        
    }
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data==null||data.length()==0)
            return null;
        
        Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
        
        return deserialize(q);
    }
    
    private TreeNode deserialize(Queue<String> q){
        if(q.isEmpty())
            return null;
        
        String val = q.poll();
        
        if(val.equals("#"))
            return null;
        
        TreeNode node = new TreeNode(Integer.parseInt(val));
        
        node.left= deserialize(q);
        node.right= deserialize(q);
        
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));