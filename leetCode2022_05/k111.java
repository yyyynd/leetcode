package leetcode.leetCode2022_05;

public class k111 {
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

    public int minDepth(TreeNode root) {

        dfs(root, 1);
        return ans;
    }

    public void dfs(TreeNode root, int cur){
        if (cur == ans || root == null)
            return;

        if (root.left != null || root.right != null) {
            dfs(root.left, cur + 1);
            dfs(root.right, cur + 1);
        } else
            ans = cur;
    }
}
