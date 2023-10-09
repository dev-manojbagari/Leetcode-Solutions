class Solution {
    
    class Trie{
        Node head;
        Trie(){
            head = new Node();
        }
        class Node{
            Node[] next;
            int val;
            Node(){
                next = new Node[2];
            }
        }
        
        void add(int num){
            Node curr= head;
            for(int i=31;i>=0;i--){
                 int x = (num>>i)&1;
                 if(curr.next[x]==null)
                        curr.next[x]=new Node();
                curr = curr.next[x];
            }
        }      
        
        int maxXor(int num){
            Node curr = head;
            int maxXor=0;
            for(int i=31;i>=0;i--){
                 int x = (num>>i)&1;
                 if(curr.next[1-x]!=null){
                     maxXor = maxXor|(1<<i);
                     curr = curr.next[1-x];
                 }else
                    curr=curr.next[x]; 
            }
            return maxXor;
        }
    }
    
//             void insert(int num){
//             Node curr =root;
//             for(int i=31;i>=0;i--){
//                 int bit = (num>>i)&1;
//                 if(curr.child[bit]==null)
//                     curr.child[bit] = new Node();
//                 curr = curr.child[bit];
//             }
//         }
        
//         int maxXor(int num){
//             Node curr =root;
//             int maxXor = 0;
//             for(int i=31;i>=0;i--){
//                 int bit = (num>>i)&1;
//                 if(curr.child[1-bit]!=null){
//                     maxXor = maxXor|(1<<i);
//                     curr=curr.child[1-bit];
//                 }else
//                     curr=curr.child[bit];
//             }
            
//             return maxXor;
//         }
    
    public int findMaximumXOR(int[] nums) {
        
        Trie trie = new Trie();
        for(int num:nums){
            trie.add(num);
        }
        
        int max =0;
        
        for(int num:nums){
            max = Math.max(max,trie.maxXor(num));
        }
        
        return max;
    }
}