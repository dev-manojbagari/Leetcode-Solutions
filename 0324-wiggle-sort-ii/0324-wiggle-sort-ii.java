class Solution {

    public void wiggleSort(int[] nums) {
        int n = nums.length;
        int median = findKthLargest(nums, (n + 1) / 2);

        int left = 0, i = 0, right = n - 1;
        while (i <= right) {
            int virtualIdx = virtualIndex(i, n);
            if (nums[virtualIdx] > median) {
                swap(nums, virtualIndex(left++, n), virtualIdx);
                i++;
            } else if (nums[virtualIdx] < median) {
                swap(nums, virtualIndex(right--, n), virtualIdx);
            } else {
                i++;
            }
        }
    }

    private int virtualIndex(int i, int n) {
        // Check if n is even
        boolean isEven = n % 2 == 0;

        // If n is even, add 1 to it to make it odd
        if (isEven) {
            n = n + 1;
        }

        // Calculate the virtual index
        return (2 * i + 1) % n;
    }

    int findKthLargest(int[] nums, int k) {
        int left = 0, right = nums.length - 1;
        int ans = -1;
        while (left <= right) {
            int index = quickSelect(nums, left, right);

            if (index == k - 1) {
                ans = nums[index];
                break;
            } else if (index < k - 1) {
                left = index + 1;
            } else {
                right = index - 1;
            }
        }

        return ans;
    }

    int quickSelect(int[] nums, int start, int end) {
        int pivot = nums[end];
        for (int curr = start; curr < end; curr++) {
            if (nums[curr] > pivot) swap(nums, curr, start++);
        }
        swap(nums, start, end);
        return start;
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
