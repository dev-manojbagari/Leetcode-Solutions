class WordDictionary {
    Node head;
    public WordDictionary() {
        head = new Node('\0');
    }
    
    public void addWord(String word) {
        Node curr = head;
        for(char c:word.toCharArray()){
            if(curr.child[c-'a']==null)
                  curr.child[c-'a'] = new Node(c);
                
            curr = curr.child[c-'a'];
        }
        curr.isWord=true;
    }

    
    
    public boolean search(String word) {
        return isMatch(word.toCharArray(),0,head);    
    }

    
    boolean isMatch(char[] ca , int index,Node node){
        if(index==ca.length) return node.isWord;
        if(ca[index]!='.')
            return node.child[ca[index]-'a']!=null&&isMatch(ca,index+1,node.child[ca[index]-'a']);
        else
        {
            for(int i=0;i<26;i++){
                if(node.child[i]!=null&&isMatch(ca,index+1,node.child[i]))
                    return true;
            }
        }
        
        return false;
    }
    
    
    
    private class Node{
        Node child[] = new Node[26];
        char val;
        boolean isWord=false;
        Node(char val){
            this.val=val;
        }
    }
    
    
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */