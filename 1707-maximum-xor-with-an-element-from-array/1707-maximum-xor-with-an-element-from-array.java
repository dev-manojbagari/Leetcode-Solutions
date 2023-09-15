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
    
    public int[] maximizeXor(int[] nums, int[][] queries) {
        int[] res = new int[queries.length];
        Arrays.sort(nums);
        int index=0;
        int numIndex=0;
        Trie  trie = new Trie();
        int[][] temp = new int[queries.length][3];
        for (int i = 0; i < queries.length; i++) {
            temp[i][0] = queries[i][0];
            temp[i][1] = queries[i][1];
            temp[i][2] = i;
        }

        Arrays.sort(temp, (a, b) -> {
            return a[1] - b[1];
        });
        for(int[] q : temp){
            int i = q[0];
            int j = q[1];
            int max=-1;
            
            while(numIndex<nums.length&&nums[numIndex]<=j){
                trie.insert(nums[numIndex]);
                numIndex++;
            }
            if(numIndex!=0)
                max = trie.maxXor(i);
            
            res[q[2]]=max;
            
        }

        return res;
    }
}
 
