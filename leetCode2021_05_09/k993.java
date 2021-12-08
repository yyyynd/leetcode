package leetCode2021_05_09;

public class k993 {
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

    int xdep = 0;
    int ydep = 0;
    TreeNode xparent = null;
    TreeNode yparent = null;

    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(x,y,root.left,root,1);
        dfs(x,y,root.right,root,1);

        if(xdep==0 || ydep ==0)//不存在节点时
            return false;
        if(xdep == ydep && xparent != yparent)
            return true;
        else
            return false;
    }

    private void dfs(int x,int y,TreeNode root,TreeNode parent,int dep){
        if(root == null)
            return;

        if(x == root.val){
            xparent = parent;
            xdep = dep;
        }
        if(y == root.val){
            yparent = parent;
            ydep = dep;
        }
        //如果两个点都找到了，结束递归遍历
        if(xdep != 0 && ydep != 0)
            return;

        dfs(x,y,root.left,root,dep+1);
        dfs(x,y,root.right,root,dep+1);
    }
}
