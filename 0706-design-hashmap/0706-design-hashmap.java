class MyHashMap {
    class LinkedList{
        class Node{
            int key,val;
            Node next;
            Node(int key,int val){
                this.key=key;
                this.val=val;
            }
        }
        
        Node head,tail;

        LinkedList(){
            head = null;
            tail=null;
        }
        
        void add(int key,int val){
               Node cur=head;
             while(cur!=null){
               if(cur.key==key){
                cur.val=val;  // Update value for existing key
                 return;
                 }
       cur=cur.next;
   }
            
            if(head==null){
                head=tail=new Node(key,val);
                
            }
            else{
                tail.next=new Node(key,val);
                tail=tail.next;
            }
        }
        
        void remove(int key){
            Node prev=null;
            Node curr = head;
            while(curr!=null&&curr.key!=key){
                prev=curr;
                curr=curr.next;
            }
            
            if(curr==null)
                return;
            if(prev==null)
            {
                Node temp = head;
                head=head.next;
                temp.next=null;
            }else{
                prev.next=curr.next;
                 if(curr == tail){ // If we are removing last element update tail
                     tail=prev;
                }
        
                curr.next=null;
            }
            
        }
        
        int search(int key){
            Node curr= head;
            while(curr!=null&&curr.key!=key)
                curr=curr.next;
            
            return curr==null?-1:curr.val;
        }
        
    }
    
    LinkedList[] la = new LinkedList[1000001];
    public MyHashMap() {
        
    }
    
    public void put(int key, int value) {
        if(la[key]==null)
            la[key]=new LinkedList();
        
        la[key].add(key,value);
    }
    
    public int get(int key) {
        if(la[key]==null)
            return -1;
        else 
            return la[key].search(key);
    }
    
    public void remove(int key) {
        if(la[key]==null)
            return;
        else {
            la[key].remove(key);
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */