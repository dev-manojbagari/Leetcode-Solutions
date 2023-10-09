class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        
        for(String word:words){
            trie.add(word);    
        }
        List<String> list = new ArrayList<>();
        boolean[][] vis = new boolean[board.length][board[0].length];
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                dfs(i,j,board,trie.head,list,vis);                
            }
        }
        
        return list;
    }
    
    void dfs(int i,int j,char[][] board,Trie.Node trieNode,List<String> list,boolean[][] vis){
        
        if(i<0||i>=board.length||j<0||j>=board[0].length||vis[i][j])
            return;
        
        char c = board[i][j];
        
        if(trieNode.next[c-'a']==null)
            return;
        vis[i][j]=true;
        
        trieNode = trieNode.next[c-'a'];
        
        if(trieNode.isWord){
            list.add(trieNode.word);
            trieNode.isWord=false;
        }
        
        dfs(i+1,j,board,trieNode,list,vis);
        dfs(i,j+1,board,trieNode,list,vis);
        dfs(i,j-1,board,trieNode,list,vis);
        dfs(i-1,j,board,trieNode,list,vis);
        
        vis[i][j]=false;
    }
    
    class Trie{
        Node head;
        
        Trie(){
            head = new Node('\0');
        }
        
        class Node{
            char val;
            Node[] next;
            boolean isWord;
            String word;
            Node(char val){
                this.val =val;
                next = new Node[26];
            }
        }
        
        void add(String word){
            Node curr = head;
            for(char c:word.toCharArray()){
                if(curr.next[c-'a']==null){
                    curr.next[c-'a']=new Node(c);
                }
                curr =curr.next[c-'a'];
            }
            curr.isWord=true;
            curr.word=word;
        }
        
    }
}