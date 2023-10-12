class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] cmap = new int[26];
        
        for(char task:tasks){
            cmap[task-'A']++;
        }
        
        int maxFreq=0,groupSize=0;

        for(int count:cmap){
            if(maxFreq<count){
                maxFreq = count;
                groupSize=0;
            }
            if(maxFreq==count){
                groupSize++;
            }
        }
        
        return Math.max(tasks.length,(n+1)*(maxFreq-1)+groupSize);
    }
}