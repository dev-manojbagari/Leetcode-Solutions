class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words,(a,b)->a.length()-b.length());
        
        int n = words.length;
        int[] L = new int[n];
        Arrays.fill(L,1);
        int maxLen =1;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(words[j].length()+1==words[i].length()&&oneDiff(words[j],words[i])){
                    if(L[j]+1>L[i]){
                        L[i]=1+L[j];
                    }
                }
            }
            maxLen = Math.max(maxLen,L[i]);
        }
        
        return maxLen;
    }
    
    
    boolean oneDiff(String word1,String word2){
        int i=0,j=0;
        while(i<word1.length()&&j<word2.length()){
            if(word1.charAt(i)==word2.charAt(j)){
                i++;
                j++;
            }else{
                j++;
            }
        }
        
        return i==word1.length()&&(j==word2.length()||(j+1==word2.length()));
    }
}