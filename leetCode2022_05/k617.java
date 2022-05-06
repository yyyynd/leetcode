package leetcode.leetCode2022_05;

public class k617 {
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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null)
            return root2;
        else if (root2 == null)
            return root1;

        root1.val += root2.val;
        dfs(root1, root2);
        return root1;
    }

    public void dfs(TreeNode root1, TreeNode root2){
        if (root1.left == null && root2.left != null)
            root1.left = root2.left;
        else if (root1.left != null && root2.left != null) {
            root1.left.val += root2.left.val;
            dfs(root1.left, root2.left);
        }

        if (root1.right == null && root2.right != null)
            root1.right = root2.right;
        else if (root1.right != null && root2.right != null){
            root1.right.val += root2.right.val;
            dfs(root1.right, root2.right);
        }
    }
}

