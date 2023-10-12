class Solution {
    public int leastInterval(char[] tasks, int n) {
       if(n==0)return tasks.length;
        int[] counter = new int[26];
        int max = 0;
        int maxCount = 0;
        for(char task : tasks) {
            counter[task - 'A']++;
            if(max == counter[task - 'A']) {
                maxCount++;
            }
            else if(max < counter[task - 'A']) {
                max = counter[task - 'A'];
                maxCount = 1;
            }
        }
        
//         int partCount = max - 1;
//         int partLength = n - (maxCount - 1);
//         if(partLength==0)
//             return tasks.length;
        
//         int emptySlots = partCount * partLength;
//         int availableTasks = tasks.length - max * maxCount;
//         int idles = emptySlots - availableTasks;
         int partCount = max - 1;
        int partLength = n - (maxCount - 1);
        if(partLength==0)
            return tasks.length;
        int emptySlots = partCount * partLength;
        int availableTasks = tasks.length - max * maxCount;
        int idles = Math.max(0,emptySlots - availableTasks);
        return tasks.length + idles;
    }
}