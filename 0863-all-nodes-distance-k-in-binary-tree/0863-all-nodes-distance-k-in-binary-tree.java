
class Solution {
     public List<Integer> distanceK(TreeNode root, TreeNode target, int distance) {
	List<Integer> list = new ArrayList<>();

	if (root == null)
	    return list;

	distanceK(root, list, target, distance);

	return list;
    }

    private int distanceK(TreeNode root, List<Integer> list, TreeNode target, int distance) {

	if (root == null)
	    return -1;

	if (root == target) {
	    distanceKDown(root, list, distance);
	    return 0;
	}

	int l = distanceK(root.left, list, target, distance);

	if (l != -1) {
	    if (l + 1 == distance) {
		list.add(root.val);
	    } else if (l + 1 < distance) {
		distanceKDown(root.right, list, distance - l - 2);
	    }
	    return l + 1;
	}

	int r = distanceK(root.right, list, target, distance);

	if (r != -1) {
	    if (r + 1 == distance) {
		list.add(root.val);
	    } else if (r + 1 < distance) {
		distanceKDown(root.left, list, distance - r - 2);
	    }
	    return r + 1;
	}

	return -1;
    }

    private void distanceKDown(TreeNode root, List<Integer> list, int distance) {

	if (root == null)
	    return;

	if (distance == 0)
	    list.add(root.val);

	distanceKDown(root.left, list, distance - 1);
	distanceKDown(root.right, list, distance - 1);

    }
}


// With these modifications, the solution should provide the expected `[7, 4, 1]` output for the mentioned test case.