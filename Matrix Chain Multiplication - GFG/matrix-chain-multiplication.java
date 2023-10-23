//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.matrixMultiplication(N, arr));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int matrixMultiplication(int n, int arr[])
    {
        return mcm(1,n-1,arr,new Integer[n][n]);
    }
    
    static int  mcm(int left,int right,int[] arr,Integer[][] dp){
        if(left>=right)
            return 0;
        
        if(dp[left][right]!=null)
            return dp[left][right];
        
        int min = Integer.MAX_VALUE;
        
        for(int i=left;i<right;i++){
            int temp = arr[left-1]*arr[i]*arr[right]+mcm(left,i,arr,dp)+mcm(i+1,right,arr,dp);
            min = Math.min(min,temp);
        }

        return dp[left][right]=min;
    }
}