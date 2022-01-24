package leetcode.leetCode2022_01;

public class k129 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.left = left;
            this.right = right;
        }
    }

    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int num){
        num = num * 10 + root.val;
        int res = 0;
        if(root.left != null)
            res += dfs(root.left, num);
        if(root.right != null)
            res += dfs(root.right, num);

        return res == 0 ? num : res;
    }
}
