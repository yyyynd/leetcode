package leetcode.leetCode2022_07;

public class k1325 {

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

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (dfsDelete(root, target))
            root = null;

        return root;
    }

    public boolean dfsDelete(TreeNode root, int target){
        if (root == null)
            return false;

        if (dfsDelete(root.left, target))
            root.left = null;

        if (dfsDelete(root.right, target))
            root.right = null;

        return root.left == null && root.right == null && root.val == target;
    }
}
