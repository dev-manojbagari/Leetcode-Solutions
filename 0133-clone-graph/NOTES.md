```
class Solution {
public Node cloneGraph(Node node) {
if(node==null)
return null;
Map<Node,Node> map = new HashMap<>();
return cloneGraph(node,map);
}
private Node cloneGraph(Node node,Map<Node,Node> map){
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
```