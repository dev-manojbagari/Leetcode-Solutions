class Solution {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        Arrays.sort(nums);
        int index=0,n=queries.length; ;
        int[][] temp  = new int[n][3];
        for(int i=0;i<queries.length;i++){
            temp[i][0] = queries[i][0];
            temp[i][1] = queries[i][1];
            temp[i][2] = i;
        }
        Arrays.sort(temp,(a,b)->a[1]-b[1]);
        Trie trie = new Trie();
        int[] res = new int[n];
        for(int i=0;i<n;i++){
            int num = temp[i][0];
            int max= temp[i][1];
            
            while(index<nums.length&&nums[index]<=max){
                trie.add(nums[index++]);
            }
            
            if(trie.isEmpty())
                res[temp[i][2]] = -1;
            else
                res[temp[i][2]] = trie.maxXor(num);
        }
        
        return res;        
        
        
    }
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
        
        boolean isEmpty(){
            return head.next[0]==null&&head.next[1]==null;
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
    
    
  
}