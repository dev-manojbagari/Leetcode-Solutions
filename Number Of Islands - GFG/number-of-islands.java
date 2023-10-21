//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


// } Driver Code Ends
//User function Template for Java

class Solution {
        class DSU{
        int[] parent;
        int[] size;
        
        DSU(int n){
            parent = new int[n];
            size = new int[n];

            for(int i=0;i<n;i++)
            {
                parent[i]=i;
                size[i]=1;
            }
        }
        
        int findUP(int x){
            if(parent[x]==x)
                return x;
            int up = findUP(parent[x]);
            parent[x]=up;
            return up;
        }
        
        void unionBySize(int a,int b){
            int upA = findUP(a);
            int upB = findUP(b);
            if(upA==upB)
                return;
            if(size[upA]>=size[upB]){
                size[upA]+=size[upB];
                parent[upB]=upA;
            }else{
                size[upB]+=size[upA];
                parent[upA]=upB;
            }
            
        }
    }
    public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
        int m=rows,n=cols;
        DSU dsu = new DSU(m*n);
        int[][] mat = new int[m][n];
        int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
        List<Integer> list = new ArrayList<>();
        int islands=0;
        for(int k=0;k<operators.length;k++){
            int i = operators[k][0];
            int j = operators[k][1];
            if(mat[i][j]==1){
                list.add(islands);
                continue;
            }
            islands++;
            mat[i][j]=1;
            for(int[] dir:dirs){
                int x  = i+dir[0];
                int y  =  j+dir[1];
                
                if(x<0||x>=mat.length||y<0||y>=mat[0].length||mat[x][y]==0)
                    continue;
                
                if(dsu.findUP(x*n+y)!=dsu.findUP(i*n+j)){
                    dsu.unionBySize(x*n+y,i*n+j);
                    islands--;
                    
                }
            }
            
            list.add(islands);
        }
        
        return list;
        
    }
    
}

//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int  k= sc.nextInt();
            int[][] a = new int[k][2];
            for(int i=0;i<k;i++){
            
                a[i][0] = sc.nextInt();
                a[i][1] = sc.nextInt();
            }
            
            Solution obj = new Solution();
            List<Integer> ans = obj.numOfIslands(n,m,a);
           
            for(int i:ans){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends