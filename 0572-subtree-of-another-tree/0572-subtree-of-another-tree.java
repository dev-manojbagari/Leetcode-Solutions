class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null&&subRoot==null)
            return true;
        if(root==null||subRoot==null)
            return false;

        return (root.val == subRoot.val && isIdentical(root, subRoot)) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    boolean isIdentical(TreeNode a, TreeNode b) {
        if(a==null&&b==null)
            return true;

        if(a==null||b==null)
            return false;

        if(a.val!=b.val)
            return false;

        return isIdentical(a.left,b.left) && isIdentical(a.right,b.right);
    }
}
