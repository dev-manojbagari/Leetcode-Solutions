class Trie {
    Node head;
    public Trie() {
        head = new Node('\0');
    }
    
    public void insert(String word) {
        Node curr = head;
        for(char c:word.toCharArray()){
            if(curr.next[c-'a']==null)
                curr.next[c-'a']=new Node(c);
            curr=curr.next[c-'a'];
        }
        curr.isWord=true;
    }
    
    public boolean search(String word) {
        Node curr = head;
        for(char c:word.toCharArray()){
            if(curr==null)
                break;
            curr=curr.next[c-'a'];
        }
        return curr!=null&&curr.isWord;
    }
    
    public boolean startsWith(String prefix) {
         Node curr = head;
        for(char c:prefix.toCharArray()){
            if(curr==null)
                break;
            curr=curr.next[c-'a'];
        }
        return curr!=null;
    }
    
    
    class Node{
        char val;
        Node[] next;
        boolean isWord;
        Node(char val){
            this.val=val;
            next = new Node[26];
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */