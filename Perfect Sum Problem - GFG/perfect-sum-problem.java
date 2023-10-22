//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int sum = sc.nextInt();
                    int arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                    arr[i] = sc.nextInt();
                    
                    Solution ob = new Solution();
                    System.out.println(ob.perfectSum(arr,n,sum));
                }
        }
}    
// } Driver Code Ends


class Solution{

	public int perfectSum(int arr[],int n, int sum) 
	{ 
	       int[][] dp = new int[sum+1][n+1];
        int mod=(int)(1e9+7);
        for(int i=0;i<=n;i++)
            dp[0][i]=1;
        
        for(int curSum=0;curSum<=sum;curSum++){
            for(int index=1;index<=n;index++){
                if(curSum-arr[index-1]>=0)
                    dp[curSum][index]=(dp[curSum][index-1]+dp[curSum-arr[index-1]][index-1])%mod;
                else
                    dp[curSum][index]=dp[curSum][index-1];
            }
        }
        
        return dp[sum][n];
	} 
}