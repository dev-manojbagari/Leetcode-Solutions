class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        int rows=board.length,cols=board[0].length;
        List<String> list = new ArrayList<>();
        Trie trie = new Trie();
        for(String word:words)
            trie.add(word);
        boolean[][] vis= new boolean[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                dfs(i,j,board,vis,trie.head,list);
            }
        }
        return list;
    }
    
      void dfs(int i,int j,char[][] board,boolean[][] vis,Node curr,List<String> list){
        if(i<0||i>=board.length||j<0||j>=board[0].length||vis[i][j])
            return;
        
          char c = board[i][j];
          curr = curr.next[c-'a'];
          
          if(curr==null){
              return;
          }
          
          if(curr.isWord){
              list.add(curr.word);
              curr.isWord=false;
          }
          
          
        vis[i][j]=true;
        
          dfs(i+1,j,board,vis,curr,list);
          dfs(i,j+1,board,vis,curr,list);
          dfs(i-1,j,board,vis,curr,list);
          dfs(i,j-1,board,vis,curr,list);
        
        vis[i][j]=false;
        
    }
   
    class Node{
            char val;
            Node[] next;
            boolean isWord;
            String word;
            Node(char val){
                this.val = val;
                next = new Node[26];
            }
        }
    class Trie{
        
        
        
        Node head;
        
        Trie(){
            head = new Node('\0');
        }
        
        void add(String word){
            Node curr = head;
            for(char c:word.toCharArray()){
                if(curr.next[c-'a']==null)
                    curr.next[c-'a']=new Node(c);
                curr=curr.next[c-'a'];
            }
            curr.isWord=true;
            curr.word=word;
        }
    }
    
}