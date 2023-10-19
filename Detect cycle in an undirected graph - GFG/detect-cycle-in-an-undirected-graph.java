//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        for(int i=0;i<V;i++){
            if(vis[i]==false){
                if(isCycle(i,adj,vis)){
                    return true;
                }
            }   
        }
        return false;
    }
    
    boolean isCycle(int curNode,ArrayList<ArrayList<Integer>> adj,boolean[] vis){
            Queue<int[]> q = new LinkedList<>();
            q.offer(new int[]{curNode,-1});
            vis[curNode]=true;
            
            // while(!q.isEmpty()){
            //       int[] data = q.poll();
                  
            //       for(int nbr:adj.get(data[0])){
            //           if(vis[nbr]==false){
            //               vis[nbr]=true;
            //               q.offer(new int[]{nbr,curNode});
            //           }else if(nbr!=data[1]){
            //               return true;
            //           }
            //       }
            // }
            // return false;
              while(!q.isEmpty()){
            int data[] = q.poll();
            int node= data[0];
            int parent = data[1];
            
            for(int x:adj.get(node)){
                if(vis[x]==false){
                    vis[x]=true;
                    q.add(new int[]{x,node});
                }else if(x!=parent)
                    return true;
            }
        }
        return false;
    }
}