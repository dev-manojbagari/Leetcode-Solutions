/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node,Node> map = new HashMap<>();
        Node curr= head;
        
        while(curr!=null){
            Node temp = new Node(curr.val);
            map.put(curr,temp);
            curr=curr.next;
        }
        
        curr=head;
        
        while(curr!=null){
            Node node = map.get(curr);
            node.next = curr.next!=null?map.get(curr.next):null;
            node.random=curr.random!=null?map.get(curr.random):null;
            curr=curr.next;
        }
        
        
        return map.get(head);
        
    }
}