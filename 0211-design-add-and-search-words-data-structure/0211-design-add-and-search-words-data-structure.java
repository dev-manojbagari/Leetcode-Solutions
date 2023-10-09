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
        return search(word,0,curr);           
    }
    
    boolean search(String word,int index,Node curr){
        if(index==word.length())
            return curr.isWord;
        else if(word.charAt(index)!='.'){
            char c = word.charAt(index);
            return curr.next[c-'a']!=null
                &&search(word,index+1,curr.next[word.charAt(index)-'a']);
        }else{
            for(int c=0;c<26;c++){
                if(curr.next[c]!=null&&search(word,index+1,curr.next[c]))
                    return true;
            }
          return false;  
        }
    
    }
//       public boolean search(String word) {
//         return isMatch(word.toCharArray(),0,head);    
//     }
    
//     boolean isMatch(char[] ca , int index,Node node){
//         if(index==ca.length) return node.isWord;
//         if(ca[index]!='.')
//             return node.child[ca[index]-'a']!=null&&isMatch(ca,index+1,node.child[ca[index]-'a']);
//         else
//         {
//             for(int i=0;i<26;i++){
//                 if(node.child[i]!=null&&isMatch(ca,index+1,node.child[i]))
//                     return true;
//             }
//         }
        
//         return false;
//     }
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