package leetcode.leetCode2022_06;

public class k112 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, targetSum, 0);
    }

    public boolean dfs(TreeNode root, int targetSum, int curSum){
        if (root == null)
            return false;

        if (curSum + root.val == targetSum && root.left == null && root.right == null)
            return true;

        if (dfs(root.left, targetSum, curSum + root.val))
            return true;
        if (dfs(root.right, targetSum, curSum + root.val))
            return true;

        return false;
    }

}
