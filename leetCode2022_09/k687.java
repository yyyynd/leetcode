package leetcode.leetCode2022_09;

public class k687 {
    public static void main(String[] args) {
        TreeNode test = new TreeNode(1);
        test.right = new TreeNode(1, new TreeNode(1, new TreeNode(1), new TreeNode(1)),
                new TreeNode(1, new TreeNode(1), null));
        new k687().longestUnivaluePath(test);
    }

    public static class TreeNode {
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

    public int longestUnivaluePath(TreeNode root) {
        if (root == null)
            return 0;
        dfs(root, -1001);
        return ans - 1;
    }

    public int dfs(TreeNode root, int parentVal){
        if (root == null)
            return 0;

        int left = dfs(root.left, root.val);
        int right = dfs(root.right, root.val);
        ans = Math.max(ans, left + right + 1);

        if (root.val != parentVal)
            return 0;

        return Math.max(left, right) + 1;
    }
}
