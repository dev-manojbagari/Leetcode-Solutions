//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
    public static void main(String args[]) throws IOException{
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int N=sc.nextInt();
            int [][]points=new int[N][3];
            for(int i=0;i<N;i++){
                for(int j=0;j<3;j++){
                    points[i][j]=sc.nextInt();
                }
            }
            Solution obj=new Solution();
            int res=obj.maximumPoints(points,N);
            System.out.println(res);
            
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public int maximumPoints(int points[][],int n){
        if(n==1)
            return Math.max(points[0][0],Math.max(points[0][1],points[0][2]));
        
        int[][] dp = new int[n][3];
        for(int i=0;i<3;i++)
            dp[0][i] = points[0][i];
        
        for(int i=1;i<n;i++){
            dp[i][0]=points[i][0]+Math.max(dp[i-1][1],dp[i-1][2]);
            dp[i][1]=points[i][1]+Math.max(dp[i-1][0],dp[i-1][2]);
            dp[i][2]=points[i][2]+Math.max(dp[i-1][0],dp[i-1][1]);
        }
        
        return Math.max(dp[n-1][0],Math.max(dp[n-1][1],dp[n-1][2]));
    }
}