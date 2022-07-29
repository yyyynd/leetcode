package leetcode.leetCode2022_07;

public class k404 {

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

    int ans = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null)
            return ans;

        dfs_r(root.right);
        dfs_l(root.left);
        return ans;
    }

    public void dfs_l(TreeNode root){
        if (root == null)
            return;

        if (root.right == null && root.left == null)
            ans += root.val;
        else{
            dfs_l(root.left);
            dfs_r(root.right);
        }
    }

    public void dfs_r(TreeNode root){
        if (root == null)
            return;
        dfs_l(root.left);
        dfs_r(root.right);
    }
}
