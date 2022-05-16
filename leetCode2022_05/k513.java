package leetcode.leetCode2022_05;

public class k513 {

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

    int depth = 0;
    int ans = 0;

    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 0, 0);
        return ans;
    }

    public void dfs(TreeNode root, int curDepth, int pre){
        if (root == null){
            if(curDepth > depth) {
                depth = curDepth;
                ans = pre;
            }
            return;
        }

        dfs(root.left, curDepth + 1, root.val);
        dfs(root.right, curDepth + 1, root.val);
    }
}
