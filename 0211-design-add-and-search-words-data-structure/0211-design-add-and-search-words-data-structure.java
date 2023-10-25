class WordDictionary {

    Node head;
    public WordDictionary() {
        head = new Node('\0');
    }
    
    public void addWord(String word) {
        Node curr = head;
        for(char c:word.toCharArray()){
            if(curr.next[c-'a']==null)
                curr.next[c-'a']=new Node(c);
            
            curr = curr.next[c-'a'];
        }
        curr.isWord=true;
    }
    
    public boolean search(String word) {
        return search(0,word,head);
    }
    
    private boolean search(int index,String word,Node curr){
        if(index==word.length()){
            return curr.isWord;
        }else if(word.charAt(index)!='.'){
            return curr.next[word.charAt(index)-'a']!=null&&search(index+1,word,curr.next[word.charAt(index)-'a']);
        }else{
            for(char c='a';c<='z';c++){
                if(curr.next[c-'a']!=null&&search(index+1,word,curr.next[c-'a']))
                    return true;
            }
            return false;
        }
    }
    
    
    
    class Node{
        char val;
        Node[] next;
        boolean isWord;
        Node(char val){
            this.val=val;
            next=new Node[26];
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */