class Solution {
    
    class Trie{
        Node head;
        Trie(){
            head = new Node();
        }
        
        void add(int val){
            Node curr = head;
            for(int i=31;i>=0;i--){
                int bit = (val>>i)&1;
                if(curr.next[bit]==null)
                    curr.next[bit]=new Node();
                curr = curr.next[bit];
            }
        }

        int maxXor(int candidate){
            Node curr = head;
            int max=0;
            for(int i=31;i>=0;i--){
                int digit = (candidate>>i)&1;
                if(curr.next[1-digit]!=null){
                    max = max|(1<<i);
                    curr=curr.next[1-digit];
                }else{
                    curr=curr.next[digit];
                }
            }
            
            return max;
        }
        
        
        class Node{
            Node[] next;
            Node(){
                next = new Node[2];
            }
        }
    }
    
    
    public int findMaximumXOR(int[] nums) {

        Trie trie = new Trie();
        for(int num:nums)
            trie.add(num);
        
        int max=0;
        for(int num:nums)
            max = Math.max(max, trie.maxXor(num));
        
        return max;
    }
}