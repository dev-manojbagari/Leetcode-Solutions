class Solution {
​
public int reversePairs(int[] nums) {
return mergeSort(nums, 0, nums.length - 1);
}
​
int mergeSort(int[] nums, int left, int right) {
if (left >= right) return 0;
​
int mid = left + (right - left) / 2;
int count = 0;
count += mergeSort(nums, left, mid);
count += mergeSort(nums, mid + 1, right);
​
int i = left, j = mid + 1;
​
while (i <= mid) {
while (j <= right && nums[i] / 2.0 > nums[j]) j++;
​
count += j - (mid + 1);
i++;
}
sortedMerge(nums, left, mid, right);
return count;
}
​