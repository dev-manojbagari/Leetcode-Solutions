//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Driver
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- >0)
        {
            String str = read.readLine();
            System.out.println(new Reverse().reverseWord(str));
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Reverse
{
    // Complete the function
    // str: input string
    public static String reverseWord(String str)
    {
        int i=0,j=str.length()-1;
        char[] ca = str.toCharArray();
        while(i<j){
            swap(ca,i,j);
            i++;
            j--;
        }
        
        return new String(ca);
    }
    
   static void swap(char[] ca,int i,int j){
        char t= ca[i];
        ca[i]=ca[j];
        ca[j]=t;
    }
}