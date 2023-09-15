class Solution {
    class Trie{
        Node root;
        public Trie(){
            root = new Node();
        }
        
        void insert(int num){
            Node curr =root;
            for(int i=31;i>=0;i--){
                int bit = (num>>i)&1;
                if(curr.child[bit]==null)
                    curr.child[bit] = new Node();
                curr = curr.child[bit];
            }
        }
        
        int maxXor(int num){
            Node curr =root;
            int maxXor = 0;
            for(int i=31;i>=0;i--){
                int bit = (num>>i)&1;
                if(curr.child[1-bit]!=null){
                    maxXor = maxXor|(1<<i);
                    curr=curr.child[1-bit];
                }else
                    curr=curr.child[bit];
            }
            
            return maxXor;
        }
        
        class Node{
            Node[] child;
            Node(){
                child = new Node[2];
            }
        }
    }
    
    public int findMaximumXOR(int[] nums) {
        Trie trie = new Trie();
        
        for(int num:nums)
            trie.insert(num);
    
        int max = 0;        
        
        for(int num:nums){
            max = Math.max(max,trie.maxXor(num));            
        }
        
        return max;   
    }
}