class LFUCache {
    Map<Integer,DLinkedList> counter=new HashMap<>();
    Map<Integer,Node> map = new HashMap<>();
    int minFreq=0;
    int capacity;
   
    public LFUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
             Node node = map.get(key);
             counter.get(node.freq).delete(node);
             if(minFreq==node.freq&&counter.get(minFreq).isEmpty()) minFreq++;
             node.freq++;
             counter.computeIfAbsent(node.freq,(k->new DLinkedList())).add(node);
            return node.val;
        }else
            return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            counter.get(node.freq).delete(node);
            if(minFreq==node.freq && counter.get(node.freq).isEmpty()) minFreq++;            
            node.freq++;
            node.val=value;
            counter.computeIfAbsent(node.freq,(k->new DLinkedList())).add(node);
            return;
        }else {
            if(map.size()==capacity){
            counter.get(minFreq).pop();
                       if(counter.get(minFreq).isEmpty()) minFreq++;
            }
        
        
        Node node = new Node(key,value,1);
        counter.computeIfAbsent(node.freq,k->new DLinkedList()).add(node);
        minFreq = 1;
            }
        
    }
    
    class Node{
        int key,val,freq;
        Node next,prev;
        Node(int key,int val,int freq){
            this.key=key;
            this.val=val;
            this.freq=freq;
        }
    }
    
 class DLinkedList{
      Node head,tail;  
        
      DLinkedList(){
          head = new Node(-1,-1,-1);
          tail = new Node(-1,-1,-2);
          head.next=tail;
          tail.prev=head;
      }  
        
        
     void add(Node node){
         map.put(node.key,node);
        node.next=head.next;
        head.next=node;
        node.next.prev=node;
        node.prev=head;
     }
    
     boolean isEmpty(){
         return head.next==tail;
     }
     void pop(){
         if(isEmpty())
             return;
         delete(tail.prev);
     }
     
    void delete(Node node){
        map.remove(node.key);
        node.next.prev=node.prev;
        node.prev.next = node.next;
     }
        
   }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */