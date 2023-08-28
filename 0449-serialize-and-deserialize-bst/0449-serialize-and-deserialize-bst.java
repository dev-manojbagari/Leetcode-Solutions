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
        if(root==null)
            return;
        
        sb.append(root.val).append(",");
        serialize(root.left,sb);
        serialize(root.right,sb);
    }
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data==null||data.length()==0)
            return null;
        
        Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
        
        return deserialize(q,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    
    private TreeNode deserialize(Queue<String> q,int min,int max){
        if(q.isEmpty())
            return null;
        
        int val = Integer.parseInt(q.peek());
        TreeNode node=null;
        
        if(min<val&&val<max){
            node = new TreeNode(Integer.parseInt(q.poll()));
            node.left = deserialize(q,min,val);
            node.right = deserialize(q,val,max);
        }
        
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;