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
        return deserialize(q,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    
    TreeNode deserialize(Queue<String> q,int min,int max){
        String  valStr = q.peek();
       
        if(valStr==null)
            return null;
        int val = Integer.parseInt(valStr);
        if(min>=val||val>=max)
            return null;
        
        TreeNode node = new TreeNode(Integer.parseInt(q.poll()));
        node.left = deserialize(q,min,node.val);
        node.right = deserialize(q,node.val,max);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;