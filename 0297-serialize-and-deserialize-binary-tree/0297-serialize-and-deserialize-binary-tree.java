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
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if(root==null)
            return sb.toString();
        serialize(root,sb);
        return sb.toString();
    }

    void serialize(TreeNode root,StringBuilder sb){
        if(root==null){
            sb.append("#,");
            return;
        }
        
        sb.append(root.val).append(",");
        serialize(root.left,sb);
        serialize(root.right,sb);
    }

    public TreeNode deserialize(String data) {
        if(data==null||data.length()==0)
            return null;
        
        Queue<String> q  = new LinkedList<>(Arrays.asList(data.split(",")));
        
        return deserialize(q);
    }
    
        TreeNode deserialize(Queue<String> q){
            String str = q.poll();
            if(str==null||str.equals("#"))
                return null;
            
            TreeNode node = new TreeNode(Integer.parseInt(str));
            
            node.left = deserialize(q);
            node.right = deserialize(q);
        
            return node;
        }

}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));