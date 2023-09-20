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
        if(root==null)
            return "";
        StringBuilder sb = new StringBuilder();
        preorder(root,sb);
        return sb.toString();
    }

    private void preorder(TreeNode root,StringBuilder sb){
        if(root==null)
            return;
        sb.append(root.val).append(",");
        preorder(root.left,sb);
        preorder(root.right,sb);
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
        
        if(min<val&&val<max){
             TreeNode node = new TreeNode(Integer.parseInt(q.poll()));           
             node.left = deserialize(q,min,node.val);
             node.right = deserialize(q,node.val,max);
             return node;
        }else
            return null;
    }
    
    
    
    
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;