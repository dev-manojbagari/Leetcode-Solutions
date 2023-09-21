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
    public int[] maximizeXor(int[] nums, int[][] q) {
       
        int[][] temp = new int[q.length][3];
        
        for(int i=0;i<q.length;i++){
            temp[i][0]=q[i][0];
            temp[i][1]=q[i][1];
            temp[i][2]=i;
        }
        
        Arrays.sort(temp,(a,b)->a[1]-b[1]);
        Trie trie = new Trie();
        int j=0;
        Arrays.sort(nums);
        int[] res = new int[q.length];
       
        for(int i=0;i<temp.length;i++){
            
            int limit = temp[i][1];
            int oldJ = j;
            int max=0;
            while(j<nums.length&&nums[j]<=limit)
                trie.add(nums[j++]);
            if(j>0){
                res[temp[i][2]]=trie.maxXor(temp[i][0]);
            }else{
                res[temp[i][2]]=-1;
            }
        }   
        
        return res;
    }
}