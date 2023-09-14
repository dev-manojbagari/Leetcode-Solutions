class LFUCache {

    Map<Integer,Node> map;
    Map<Integer,DLinkedList> freqMap; 
    int capacity,minFreq=0,size=0;
   
    public LFUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        freqMap = new HashMap<>();
        freqMap.put(0,new DLinkedList());
    }
    
    public int get(int key) {
        if(!map.containsKey(key))
            return -1;
        Node node =  map.get(key);
        update(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            update(node);
            return;
        }
        if(size>=capacity)
        {
            while(freqMap.get(minFreq).isEmpty()){
            minFreq++;
            }
            Node node= freqMap.get(minFreq).pop();
            map.remove(node.key);
            size--;
        }
        
        Node node = new Node(key,value);
        map.put(key,node);
        freqMap.get(0).add(node);
        size++;
        minFreq=0;
    }
    
    private void update(Node node){
        int freq = node.freq;
        freqMap.get(freq).delete(node);
        node.freq++;
        freqMap.computeIfAbsent(node.freq,key->new DLinkedList()).add(node);
        
        if(node.freq==minFreq&&freqMap.get(minFreq).isEmpty())minFreq++;
    }
    
    class Node{
        int key,value,freq=0;
        Node next,prev;
        Node(int key,int value){
            this.key=key;
            this.value=value;
        }
    }
    
    class DLinkedList{
        Node head,tail;
        
       public DLinkedList(){
            head = new Node(-1,-1);
            tail = new Node(-1,-1);
            head.next=tail;
            tail.prev=head;
        }
        
        
        void add(Node node){
            node.next = head.next;
            head.next=node;
            node.next.prev=node;
            node.prev=head;
        }
        
        void delete(Node node){
            node.next.prev=node.prev;
            node.prev.next=node.next;
        }
        
        boolean isEmpty(){
            return head.next==tail;
        }
        
        
        Node pop(){
            if(isEmpty())
                return null;
            Node node = tail.prev;
            delete(tail.prev);
            return node;
        }
        
    }
    
    
    
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */