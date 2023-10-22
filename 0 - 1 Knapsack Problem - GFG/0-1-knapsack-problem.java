//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading number of elements and weight
            int n = Integer.parseInt(read.readLine());
            int w = Integer.parseInt(read.readLine());
            
            int val[] = new int[n];
            int wt[] = new int[n];
            
            String st[] = read.readLine().trim().split("\\s+");
            
            //inserting the values
            for(int i = 0; i < n; i++)
              val[i] = Integer.parseInt(st[i]);
             
            String s[] = read.readLine().trim().split("\\s+"); 
            
            //inserting the weigths
            for(int i = 0; i < n; i++)
              wt[i] = Integer.parseInt(s[i]);
              
            //calling method knapSack() of class Knapsack
            System.out.println(new Solution().knapSack(w, wt, val, n));
        }
    }
}




// } Driver Code Ends


class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
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
                    ,val[curIndex-1]+dp[curWeight-wt[curIndex-1]][curIndex-1]);
                }else{
                    dp[curWeight][curIndex] = dp[curWeight][curIndex-1];
                }              
          }
      }
        
        return dp[W][n];
    }
}


