//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[])throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(s[i]);

            Solution ob = new Solution();
            out.println(ob.cutRod(arr, n));
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution{
    public int cutRod(int price[], int n) {
        return cutRod(1,n,n,price,new Integer[n+1][n+1]);
    }
    
    int cutRod(int cut,int curLen,int len,int[] price,Integer[][] cache){
        
        if(curLen==0||cut==len+1){
            return 0;
        }
        
        if(cache[cut][curLen]!=null)
            return cache[cut][curLen];
        
        if(cut<=curLen){
            int cutHere = price[cut-1]+cutRod(cut,curLen-cut,len,price,cache);
            int notCutHere = cutRod(cut+1,curLen,len,price,cache);
            
            return cache[cut][curLen]=Math.max(cutHere,notCutHere);
        }else
            return cache[cut][curLen]=cutRod(cut+1,curLen,len,price,cache);
    }
    
    // int notCutHere = cutRod(cut+1,curLen,len,price);
    //     int cutHere = 0;
    //     if(cut<=curLen)
    //         cutHere = price[cut-1]+cutRod(cut,curLen-cut,len,price);
            
    //     return Math.max(notCutHere,cutHere);
    
}