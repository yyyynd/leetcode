package leetCode2021_05_09;

public class k671 {
    int minimum = 0;
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

    public int findSecondMinimumValue(TreeNode root) {
        if(root == null)
            return -1;
        this.minimum = root.val;

        return dfs(root);
    }

    public int dfs(TreeNode root){
        int leftMinimum;
        int rightMinimum;

        if(root == null)
            return -1;

        if(root.val > this.minimum)
            return root.val;

        leftMinimum = dfs(root.left);
        rightMinimum = dfs(root.right);

        if(leftMinimum != -1 && rightMinimum != -1)
            return Math.min(leftMinimum,rightMinimum);

        return Math.max(leftMinimum,rightMinimum);

    }
}
