package leetCode2021_10;

/**
 * 二叉搜索树，注意左子树的结点一定比右子树小
 */
public class k230 {
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

    int target;
    int ans;
    int count;
    public int kthSmallest(TreeNode root, int k) {
        target = k;
        dfs(root);
        return ans;
    }

    public void dfs(TreeNode root){
        if(root.left != null)
            dfs(root.left);
        count++;
        if(count >= target) {
            if(count == target)
                ans = root.val;
            return;
        }

        if(root.right != null)
            dfs(root.right);
    }
}
