/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        
        Map<Node,Node> map = new HashMap<>();
        return cloneGraph(node,map);
        
    }
    
    private Node cloneGraph(Node node,Map<Node,Node> map){
        if(node==null)
            return null;
        
        if(map.containsKey(node))
            return map.get(node);
        
        Node tempNode = new Node(node.val);
        
        map.put(node,tempNode);
        tempNode.neighbors=new ArrayList<>();
        
        for(Node x:node.neighbors){
            tempNode.neighbors.add(cloneGraph(x,map));
        }
        
        return tempNode;
    }
}