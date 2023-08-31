class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie= new Trie();
        
        for(String word:words){
            trie.add(word);
        }
        
        
        List<String> list = new ArrayList<>();
        boolean[][] vis = new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                  dfs(i,j,board,vis,trie.head,"",list);  
            }
        }
        
        return list;
    }
    
    void dfs(int i,int j,char[][] board,boolean[][] vis,TrieNode trieNode,String str,List<String> list){
        
        if(i<0||i>=board.length||j<0||j>=board[0].length||vis[i][j])
            return ;
        
        char c = board[i][j];
        if(trieNode.next[c-'a']==null)
            return;
        
        vis[i][j]=true;
        
        trieNode = trieNode.next[c-'a'];
        
        if(trieNode.isWord){
            list.add(trieNode.word);
            trieNode.isWord=false;
        }
        
        dfs(i+1,j,board,vis,trieNode,str,list);
        dfs(i,j+1,board,vis,trieNode,str,list);
        dfs(i-1,j,board,vis,trieNode,str,list);
        dfs(i,j-1,board,vis,trieNode,str,list);
 
        vis[i][j]=false;
        
    }
    
    class TrieNode{
        char val;
        TrieNode[] next = new TrieNode[26];
        boolean isWord=false;
        String word = null;
        TrieNode(char val){
            this.val = val;
        }
    }
    
    class Trie{

        TrieNode head=new TrieNode('\0');
        
        boolean startsWith(String str){
            TrieNode curr = head;
            
            for(char c:str.toCharArray()){
                curr = curr.next[c-'a'];
                if(curr==null)
                    break;
            }
            
            return curr!=null;
        }
        
        
        void add(String word){
            TrieNode curr = head;
            for(char c:word.toCharArray()){
                if(curr.next[c-'a']==null)
                    curr.next[c-'a']=new TrieNode(c);
                curr = curr.next[c-'a'];                
            }
            
            curr.isWord=true;
            curr.word=word;
        }
    }
}