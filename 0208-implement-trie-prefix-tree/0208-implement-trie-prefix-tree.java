class Trie {
    Node head;
    public Trie() {
        head = new Node('\0');
    }
    
    public void insert(String word) {
        Node curr = head;
            for(char c:word.toCharArray()){
                if(curr.child[c-'a']==null)
                    curr.child[c-'a']=new Node(c);
                    
                curr= curr.child[c-'a'];
            
        }
            curr.isWord=true;
        
        
    }
    
    public boolean search(String word) {
        Node curr = head;
            for(char c:word.toCharArray()){
                curr= curr.child[c-'a'];
                if(curr==null)
                    break;

            }
            
            return curr!=null&&curr.isWord;
    }
    
    public boolean startsWith(String prefix) {
        Node curr = head;
            for(char c:prefix.toCharArray()){
                curr= curr.child[c-'a'];
                if(curr==null)
                    break;

            }
            
            
        
       return curr!=null;
    }
    
    class Node{
        char val;
        Node[] child=new Node[26];
        boolean isWord;
        Node(char val){
            this.val=val;
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