import java.util.*;

class Solution {
    class Node implements Comparable<Node> {
        int id;
        long time;
        
        public Node(int id, long time) {
            this.id = id;
            this.time = time;
        }
        
        @Override
        public int compareTo(Node other) {
            return Long.compare(this.time, other.time);
        }
        
         @Override
         public boolean equals(Object o) { 
             if (this == o)
                return true;
             if (!(o instanceof Node))
                return false;
             Node node = (Node) o;
             return id == node.id && time == node.time; 
         }

         @Override
         public int hashCode() { 
             return Objects.hash(id, time); 
         }
    }

    public int countPaths(int n, int[][] roads) {
       List<List<int[]>> adj = new ArrayList<>();
       
       for(int i=0;i<n;i++)
           adj.add(new ArrayList<>());
       
       for(int i=0;i<roads.length;i++){
           int src = roads[i][0];
           int dst = roads[i][1];
           int time = roads[i][2];
           
           adj.get(src).add(new int[]{dst,time});
           adj.get(dst).add(new int[]{src,time});
       }
       
       long[] time = new long[n];
       Arrays.fill(time,Long.MAX_VALUE);
       
       PriorityQueue<Node> pq = new PriorityQueue<>();
       
       pq.offer(new Node(0, 0));                  
       time[0]=0;

      // Number of ways to reach each city
      long[] ways=new long[n];  
      ways[0]=1; // One way to reach city 0

      while(!pq.isEmpty()){
          Node data=pq.poll();
          if(data.time >time[data.id]) continue; // Ignore outdated node

          for(int[] x:adj.get(data.id)){
              if(data.time+x[1]<time[x[0]]){
                  pq.remove(new Node(x[0],time[x[0]])); // Remove old node from pq.
                  ways[x[0]]=ways[data.id]; // Reset number of ways.
                  time[x[0]]=data.time+x[1]; // Update shortest path cost.
                  pq.offer(new Node(x[0],time[x[0]])); // Add updated node to pq.
              } else if(data.time+x[1]==time[x[0]]){  
                   ways[x[0]]=(ways[data.id]+ways[x[0]])%(int)(1e9+7);  // Add additional paths.    
              }
          }
      }               
      return (int)(ways[n-1]%(int)(1e9+7));                   
   }
}
