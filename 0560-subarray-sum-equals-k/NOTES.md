class Solution {
​
public int subarraySum(int[] nums, int k) {
Map<Integer, Integer> map = new HashMap<>();
int n = nums.length;
int commulativeSum = 0;
map.put(0, 1);
int count = 0;
for (int i = 0; i < n; i++) {
commulativeSum += nums[i];
if (map.containsKey(commulativeSum - k))
count += map.get(commulativeSum - k);
map.put(commulativeSum, map.getOrDefault(commulativeSum, 0) + 1);
}
​
return count;
}
}
​