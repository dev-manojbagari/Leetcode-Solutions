class LRUCache {
    Node head,tail;
    Map<Integer,Node> map;
    int capacity;
    
    public LRUCache(int capacity) {
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next=tail;
        tail.prev=head;
        map = new HashMap<>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            delete(node);
            add(node);
            return node.val;
        }else
            return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            delete(node);
        }else if(map.size()==capacity){
            delete(tail.prev);
        }
        
        add(new Node(key,value));
    }
    
    void add(Node node){
        map.put(node.key,node);
        node.next=head.next;
        head.next=node;
        node.next.prev=node;
        node.prev=head;
    }
    
    void delete(Node node){
        map.remove(node.key);
        node.next.prev=node.prev;
        node.prev.next = node.next;
    }
    
    
    class Node{
        int key,val;
        Node next,prev;
        Node(int key,int val){
            this.key=key;
            this.val=val;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */