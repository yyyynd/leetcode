package leetcode.leetCode2022_06;

public class k654 {

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

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return nums.length == 0 ? null : dfs(nums, 0, nums.length - 1);
    }

    public TreeNode dfs(int[] nums, int left, int right){
        if (left > right)
            return null;

        if (left == right)
            return new TreeNode(nums[left]);
        int i = left;
        for (int j = left + 1; j <= right; j++){
            if (nums[i] < nums[j]) {
                i = j;
            }
        }
        TreeNode root = new TreeNode(nums[i]);
        root.left = dfs(nums, left, i - 1);
        root.right = dfs(nums, i + 1, right);
        return root;
    }
}
