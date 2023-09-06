import java.util.Arrays;

public class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] frequencies = new int[26];
        
        for (char task : tasks) {
            frequencies[task - 'A']++;
        }
        
        Arrays.sort(frequencies);
        
        int maxFrequency = frequencies[25];
        int idleTime = (maxFrequency - 1) * n;
        
        for (int i = 24; i >= 0 && frequencies[i] > 0; i--) {
            idleTime -= Math.min(maxFrequency - 1, frequencies[i]);
        }
        
        idleTime = Math.max(0, idleTime);
        
        return tasks.length + idleTime;
    }
}
