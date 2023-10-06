//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        // code here
        int[] cmap = new int[256];
        int distinct=0;
        int start=0,end=0,maxLen=-1;
        
        for(;end<s.length();end++){
            char c = s.charAt(end);
            cmap[c]++;
            if(cmap[c]==1)
              distinct++;

            while(distinct>k){
                c = s.charAt(start++);
                cmap[c]--;
                if(cmap[c]==0)
                    distinct--;
            }
            if(distinct==k)
                maxLen = Math.max(maxLen,end-start+1);
        }
            return maxLen;
    }
}