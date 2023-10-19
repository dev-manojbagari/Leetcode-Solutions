//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java
class Solution {

	public int[] shortestPath(int N,int M, int[][] edges) {
		List<List<int[]>> list = new ArrayList<>();
		for(int i=0;i<N;i++)
		    list.add(new ArrayList<>());
		    
		for(int[] edge:edges){
		    list.get(edge[0]).add(new int[]{edge[1],edge[2]});
		}
		boolean[] vis = new boolean[N];
		int[] dist = new int[N];
		Arrays.fill(dist,Integer.MAX_VALUE);
		PriorityQueue<int[]> pq =  new PriorityQueue<>((a,b)->a[1]-b[1]);
		pq.offer(new int[]{0,0});
		vis[0]=true;
		dist[0]=0;
		
		while(!pq.isEmpty()){
        	int[] data = pq.poll();
        	int node = data[0];
        	int curDistance = data[1];
        	
        	for(int[] x:list.get(node)){
        	    if(curDistance+x[1]<dist[x[0]]){
        	        dist[x[0]]=curDistance+x[1];
        	        pq.offer(new int[]{x[0],dist[x[0]]});
        	    }
        	    
        	}
		    
		}
		
		for(int i=0;i<N;i++)
		    if(dist[i]==Integer.MAX_VALUE)
		        dist[i]=-1;
		
		return dist;
	}
}