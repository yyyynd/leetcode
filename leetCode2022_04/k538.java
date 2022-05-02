package leetcode.leetCode2022_04;

public class k538 {
    class TreeNode {
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
    int curSum = 0;
    public TreeNode convertBST(TreeNode root) {
        dfs(root);
        return root;
    }

    public void dfs(TreeNode root){
        if (root == null)
            return;

        dfs(root.right);
        curSum += root.val;
        root.val = curSum;
        dfs(root.left);
    }

}
