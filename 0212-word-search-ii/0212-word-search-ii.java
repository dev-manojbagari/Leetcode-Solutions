class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        int rows = board.length;
        int cols = board[0].length;
        boolean vis[][] = new boolean[rows][cols];
        List<String> list = new ArrayList<>();
        
        Trie trie = new Trie();
        for(String word:words)
            trie.insert(word);

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                dfs(i,j,board,vis,list,trie.getRoot());
            }
        }
        
        return list;
    }
    
    
    void dfs(int i,int j,char[][] board,boolean[][] vis,List<String> list,Trie.TrieNode node){
            
        if(i<0||i>=board.length||j<0||j>=board[0].length||vis[i][j])
            return;
        char c = board[i][j];
        if(c=='#'||node.next[c-'a']==null)
            return;
        node = node.next[c-'a'];
        
        if(node.isWord){
            list.add(node.word);
            node.isWord=false;
        }
        
        board[i][j]='#';
        dfs(i+1,j,board,vis,list,node);
        dfs(i,j+1,board,vis,list,node);
        dfs(i-1,j,board,vis,list,node); 
        dfs(i,j-1,board,vis,list,node);
        
        board[i][j]=c;
        
    }
    
    public class Trie{
        public TrieNode root=new TrieNode('\0');
        
        public class TrieNode{
            char val;
            TrieNode next[] = new TrieNode[26];
            String word;    
            boolean isWord;
            TrieNode(char val){
                this.val = val;
            }
        }

        void insert(String word){
            TrieNode curr= root;
            for(char c:word.toCharArray()){
                if(curr.next[c-'a']==null)
                    curr.next[c-'a']=new TrieNode(c);
                curr = curr.next[c-'a'];
            }
            curr.word = word;
            curr.isWord = true;
        }
        
        TrieNode getRoot(){
            return root;
        }
        
    }
    
}