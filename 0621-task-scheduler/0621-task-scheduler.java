class Solution {
    public int leastInterval(char[] tasks, int n) {
        if(n==0)return tasks.length;
        int[] cmap = new int[26];
        
        for(char task:tasks){
            cmap[task-'A']++;
        }
        
        int maxFreq=0,groupSize=0;

        for(int count:cmap){
            if(maxFreq<count){
                maxFreq = count;
                groupSize=1;
            }else if(maxFreq==count){
                groupSize++;
            }
        }
        return Math.max(tasks.length,(n+1)*(maxFreq-1)+groupSize);
    }
}