import java.util.HashMap;

public class Solution {

    int result = 0;

    public int pathSum(TreeNode root, int sum) {
        HashMap<Long, Integer> cache = new HashMap<>();
        cache.put(0l, 1);
        dfs(root, sum, 0, cache);
        return result;
    }

    private void dfs(TreeNode node, int target, long currPathSum, HashMap<Long, Integer> cache) {  // Use long instead of int
        if (node == null) {
            return;
        }

        currPathSum = Math.addExact(currPathSum, node.val);  // Use Math.addExact() to handle integer overflow
        long oldPathSum = currPathSum - target;

        result += cache.getOrDefault(oldPathSum, 0);
        cache.put(currPathSum, cache.getOrDefault(currPathSum, 0) + 1);

        dfs(node.left, target, currPathSum, cache);
        dfs(node.right, target, currPathSum, cache);

        // When moving to a different branch, the currPathSum is no longer available, hence remove one.
        if (cache.get(currPathSum) == 1) {
            cache.remove(currPathSum);
        } else {
            cache.put(currPathSum, cache.get(currPathSum) - 1);
        }
    }
}
