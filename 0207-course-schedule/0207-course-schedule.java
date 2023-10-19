class Solution {
    public boolean canFinish(int n, int[][] prereq) {
       int[] inDegree = new int[n];
       List<List<Integer>> adj = new ArrayList<>();
       
        for(int i=0;i<n;i++)
           adj.add(new ArrayList<>());
        
        for(int i=0;i<prereq.length;i++){
            adj.get(prereq[i][1]).add(prereq[i][0]);
            inDegree[prereq[i][0]]++;
        }
        

       Queue<Integer> q = new LinkedList<>();
       boolean[]  vis = new boolean[n];
       for(int i=0;i<n;i++){
           if(inDegree[i]==0){
               q.offer(i);
           }
       }
     List<Integer> list = new ArrayList<>();
      while(!q.isEmpty()){
            int node = q.poll();
            list.add(node);
            for(int x:adj.get(node)){
                inDegree[x]--;
                if(inDegree[x]==0)
                    q.offer(x);
            }
      }       
    
        
        
        return list.size()==n;
    }
}