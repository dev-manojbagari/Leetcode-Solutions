
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list;

        distanceK(root, target, k, list);

        return list;
    }

    private int distanceK(TreeNode root, TreeNode target, int k, List<Integer> list) {
        if (root == null)
            return -1;

        if (root == target) {
            distanceKDown(root, list, k);
            return 0;
        }

        int dl = distanceK(root.left, target, k, list);

        if (dl != -1) {
            if (dl + 1 == k) {
                list.add(root.val);
            } else if (dl + 1 < k) {
                distanceKDown(root.right,list,k-dl-2);
            }
            return dl + 1;
        }
            int dr = distanceK(root.right, target, k, list);
            if (dr != -1) {
                if (dr + 1 == k) {
                    list.add(root.val);
                    // return dr + 1;
                } else {
                    distanceKDown(root.left,list,k-dr-2);
                }
            return dr + 1;
            }
        
        return -1;
        
    }

    private void distanceKDown(TreeNode node, List<Integer> list, int level) {
        if (node == null )
            return;

        if (level == 0) {
            list.add(node.val);
        
        }

        distanceKDown(node.left, list, level - 1);
        distanceKDown(node.right, list, level - 1);
    }
}


// With these modifications, the solution should provide the expected `[7, 4, 1]` output for the mentioned test case.