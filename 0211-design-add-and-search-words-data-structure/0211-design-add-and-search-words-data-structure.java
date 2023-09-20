class WordDictionary {
    Node head;
    public WordDictionary() {
        head = new Node('\0');
    }
    
    public void addWord(String word) {
        Node curr = head;
        for(char c:word.toCharArray()){
            if(curr.child[c-'a']==null)
                curr.child[c-'a']=new Node(c);
            curr = curr.child[c-'a'];
        }
        curr.isWord=true;
        
    }
    
    public boolean search(String word) {
        Node curr =head;
        return search(curr,0,word);
    }
    
    private boolean search(Node curr,int index,String word){
        if(index==word.length())
            return curr!=null&&curr.isWord;
        if(word.charAt(index)!='.')
            return curr!=null&&search(curr.child[word.charAt(index)-'a'],index+1,word);
        else{
            for(int i=0;i<26;i++)
                if(curr!=null&&search(curr.child[i],index+1,word))
                    return true;
            return false;
        }
    }
    
    
    class Node{
        char val;
        Node[] child;
        boolean isWord=false;
        Node(char val){
            this.val= val;
            child = new Node[27];
        }
    }
    
    
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */