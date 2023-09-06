import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int cumulativeSum = 0;
        Map<Integer, Integer> map = new HashMap<>(); // Store cumulative sums and their frequencies
        map.put(0, 1);

        for (int num : nums) {
            cumulativeSum += num;

            if (map.containsKey(cumulativeSum - k)) {
                count += map.get(cumulativeSum - k);
            }

            map.put(cumulativeSum, map.getOrDefault(cumulativeSum, 0) + 1);
        }

        return count;
    }
}
