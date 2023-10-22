//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String line1[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(line1[0]);
            int W = Integer.parseInt(line1[1]);
            String line2[] = in.readLine().trim().split("\\s+");
            int val[] = new int[N];
            for(int i = 0;i < N;i++)
                val[i] = Integer.parseInt(line2[i]);
            String line3[] = in.readLine().trim().split("\\s+");
            int wt[] = new int[N];
            for(int i = 0;i < N;i++)
                wt[i] = Integer.parseInt(line3[i]);
                
            Solution ob = new Solution();
            System.out.println(ob.knapSack(N, W, val, wt));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int knapSack(int n, int W, int val[], int wt[])
    {
       int[][] dp  = new int[W+1][n+1];
      
      for(int i=0;i<=W;i++)
        dp[i][0]=0;
        
      for(int i=0;i<=n;i++)
        dp[0][i]=0;
        
        
      for(int curWeight =1;curWeight<=W;curWeight++){
          for(int curIndex=1;curIndex<=n;curIndex++){
                if(curWeight-wt[curIndex-1]>=0){
                    dp[curWeight][curIndex]=Math.max(dp[curWeight][curIndex-1]
                    ,val[curIndex-1]+dp[curWeight-wt[curIndex-1]][curIndex]);
                }else{
                    dp[curWeight][curIndex] = dp[curWeight][curIndex-1];
                }              
          }
      }
        
        return dp[W][n];
    }
}