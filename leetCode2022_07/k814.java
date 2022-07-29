package leetcode.leetCode2022_07;

public class k814 {
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

    public TreeNode pruneTree(TreeNode root) {
        if (dfs(root) && root.val == 0)
            return null;
        return root;
    }

    public boolean dfs(TreeNode root){
        if (root == null)
            return true;

        if (dfs(root.left))
            root.left = null;
        if (dfs(root.right))
            root.right = null;

        return root.val == 0 && root.left == null && root.right == null;
    }
}
