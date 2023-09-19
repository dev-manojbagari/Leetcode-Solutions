class Solution {
      public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        subsets(0, nums, set, new ArrayList<>());
        return new ArrayList<>(set);
    }

    private void subsets(int index, int[] nums, Set<List<Integer>> set, List<Integer> tempList) {
        if (index == nums.length) {
            set.add(new ArrayList<>(tempList));
            return;
        }

        subsets(index + 1, nums, set, tempList);

        tempList.add(nums[index]);
        subsets(index + 1, nums, set, tempList);
        tempList.remove(tempList.size() - 1);
    }
}
