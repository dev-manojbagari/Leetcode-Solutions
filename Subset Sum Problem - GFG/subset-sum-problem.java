//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if(ob.isSubsetSum(N, arr, sum))
            System.out.println(1);
            else
            System.out.println(0);

            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{


    static Boolean isSubsetSum(int n, int arr[], int sum){
        boolean[][] dp = new boolean[sum+1][n+1];
        
        for(int i=0;i<=n;i++)
            dp[0][i]=true;
        
        for(int curSum=0;curSum<=sum;curSum++){
            for(int index=1;index<=n;index++){
                if(curSum-arr[index-1]>=0)
                    dp[curSum][index]=dp[curSum][index-1]||dp[curSum-arr[index-1]][index-1];
                else
                    dp[curSum][index]=dp[curSum][index-1];
            }
        }
        
        return dp[sum][n];
        
    }
}