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
        return match(word.toCharArray(), 0, head);
    }

    private boolean match(char[] chs, int k, Node node) {
        if (k == chs.length) return node.isWord; 
        if (chs[k] != '.') { 
            return node.child[chs[k] - 'a'] != null && match(chs, k + 1, node.child[chs[k] - 'a']);
        } else { 
            for (int i = 0; i < node.child.length; i++) { 
                if (node.child[i] != null && match(chs, k + 1, node.child[i])) { 
                    return true;
                }
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