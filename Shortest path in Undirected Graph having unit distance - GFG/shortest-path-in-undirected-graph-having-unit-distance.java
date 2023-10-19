//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m=sc.nextInt();
            int[][] edge = new int[m][2];
            for(int i=0;i<m;i++){
                edge[i][0]=sc.nextInt();
                edge[i][1]=sc.nextInt();
            }
            int src=sc.nextInt();
            Solution obj = new Solution();
            int res[] = obj.shortestPath(edge,n,m,src);
            for(int i=0;i<n;i++){
                System.out.print(res[i]+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<n;i++)
            list.add(new ArrayList<>());
            
        for(int[] edge:edges){
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }    
        int[] dist = new int[n];
        Arrays.fill(dist,-1);
        boolean[] vis= new boolean[n];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{src,0});
        vis[src]=true;
        dist[src]=0;
        
        while(!q.isEmpty()){
            int[] data= q.poll();
            int node= data[0];
            int curDist = data[1];
            for(int x:list.get(node)){
                if(!vis[x]){
                    vis[x]=true;
                    dist[x]=1+curDist;
                    q.offer(new int[]{x,1+curDist});
                }
            }
        }
        
        return dist;            
    }
}