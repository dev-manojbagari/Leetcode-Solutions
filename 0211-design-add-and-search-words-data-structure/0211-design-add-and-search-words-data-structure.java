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
            curr=curr.next[c-'a'];
        }
        curr.isWord=true;
    }
    
    public boolean search(String word) {
        if(word.length()==0)
            return false;
        Node curr = head; 
        return search(word.toCharArray(),0,curr);           
    }
    
    boolean search(char word[],int index,Node curr){
        if(index==word.length)
            return curr.isWord;
        else if(word[index]!='.'){
            return curr.next[word[index]-'a']!=null&&search(word,index+1,curr.next[word[index]-'a']);
        }else{
            for(int i=0;i<26;i++){
                if( curr.next[i]!=null&&search(word,index+1,curr.next[i]))
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