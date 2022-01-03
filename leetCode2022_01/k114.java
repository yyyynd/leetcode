package leetCode2022_01;

public class k114 {
    public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {
         }
         TreeNode(int val) {
             this.val = val;
         }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }

    TreeNode travel;
    public void flatten(TreeNode root) {
        if(root == null)
            return;
        this.travel = root;
        dfs(root);
    }

    public void dfs(TreeNode root){
         TreeNode right = root.right;
         //首先将左子树移至父节点的右子树指针位置上
         if(root.left != null){
             this.travel = root.left;
             root.right = root.left;
             root.left = null;
             dfs(root.right);
         }

         if(right != null){
            this.travel.right = right;
            this.travel = right;
            dfs(right);
         }
    }

}
