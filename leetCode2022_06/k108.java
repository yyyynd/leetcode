package leetcode.leetCode2022_06;

public class k108 {

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

    public TreeNode sortedArrayToBST(int[] nums) {
        return nums.length == 0 ? new TreeNode() : dfs(nums, 0, nums.length - 1);
    }

    public TreeNode dfs(int[] nums, int left, int right){
        if (left == right)
            return new TreeNode(nums[left]);

        int mid = left + (right - left)/2;
        TreeNode root = new TreeNode(nums[mid]);
        if (mid > left)
            root.left = dfs(nums, left, mid - 1);

        if (mid < right)
            root.right = dfs(nums, mid + 1, right);

        return root;

    }
}
