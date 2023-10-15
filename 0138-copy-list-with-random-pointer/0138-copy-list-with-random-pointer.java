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
        Node curr= head;
        
        while(curr!=null){
            Node temp = new Node(curr.val);
            temp.next=curr.next;
            curr.next=temp;
            curr=curr.next.next;
        }
        curr=head;
        
        while(curr!=null){
            Node temp = curr.next;
            temp.random = curr.random!=null?curr.random.next:null;
            curr=curr.next.next;
        }
        
        
        Node preHead = new Node(-1);
        Node ptr= preHead;
        curr=head;
       
        while(curr!=null){
            Node temp = curr.next;
            
            curr.next= curr.next.next;
            ptr.next=temp; 
            
            curr= curr.next;
            ptr=ptr.next;
        }
        
        return preHead.next;
    }
}