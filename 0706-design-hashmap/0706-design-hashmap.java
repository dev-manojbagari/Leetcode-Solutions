class MyHashMap {
    int[] nodes;
    public MyHashMap() {
        nodes = new int[1000001];
        Arrays.fill(nodes,-1);
    }
    
    public void put(int key, int value) {
        nodes[key]=value;
    }
    
    public int get(int key) {
        return nodes[key];
    }
    
    public void remove(int key) {
        nodes[key]=-1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */