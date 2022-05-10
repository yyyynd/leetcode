package leetcode.leetCode2022_05;

public class k623 {
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

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1){
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        dfs(root, 1, depth, val);
        return root;
    }

    public void dfs(TreeNode root, int curDepth, int depth, int val){
        if (root == null )
            return;

        if (curDepth == depth - 1){
            TreeNode newLeft = new TreeNode(val);
            newLeft.left = root.left;
            root.left = newLeft;

            TreeNode newRight = new TreeNode(val);
            newRight.right = root.right;
            root.right = newRight;
        }else {
            dfs(root.left, curDepth + 1, depth ,val);
            dfs(root.right, curDepth + 1, depth, val);
        }
    }
}
