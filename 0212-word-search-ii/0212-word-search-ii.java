class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        int rows= board.length,cols=board[0].length;
        boolean[][] vis = new boolean[rows][cols];
        Trie trie = new Trie();
        for(String word:words){
            trie.add(word);
        }
        
        List<String> list = new ArrayList<>();
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                    dfs(i,j,board,0,vis,trie.head,list);
            }
        }
        
        return list;
    }
    
    void dfs(int i,int j,char[][] board,int curIndex,boolean[][] vis,Trie.Node trieNode,List<String> list){
        
        if(i<0||i>=board.length||j<0||j>=board[0].length||vis[i][j])
            return;
        
        vis[i][j]=true;
        
        char c = board[i][j];
        
        if(trieNode.next[c-'a']==null){
            vis[i][j]=false;
            return;
        }
        
        trieNode = trieNode.next[c-'a'];
        if(trieNode.isWord){
            list.add(trieNode.word);
            trieNode.isWord=false;
        }
        
           dfs(i+1,j,board,curIndex+1,vis,trieNode,list);
           dfs(i,j+1,board,curIndex+1,vis,trieNode,list);
           dfs(i-1,j,board,curIndex+1,vis,trieNode,list);
           dfs(i,j-1,board,curIndex+1,vis,trieNode,list);
            

        vis[i][j]=false;
    }
    
    
    class Trie{
        class Node{
            Node[] next;
            char val;
            boolean isWord;
            String word;
            Node(char val){
                this.val = val;
                next = new Node[26];
            }
        }
        Node head;
        
        Trie(){
            head = new Node('\0');
        }
        
        void add(String str){
            Node curr = head;
            
            for(char c:str.toCharArray()){
                if(curr.next[c-'a']==null){
                    curr.next[c-'a']=new Node(c);
                }
                curr = curr.next[c-'a'];
            }
            curr.isWord=true;
            curr.word = str;
        }
    }
}