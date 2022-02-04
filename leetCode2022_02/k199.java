package leetcode.leetCode2022_02;

import java.util.LinkedList;
import java.util.List;

public class k199 {

    class TreeNode {
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

    int curDepth = 0;
    int resDepth = 0;

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        dfs(res, root);
        return res;
    }

    public void dfs(List<Integer> res, TreeNode root){
        if(root == null)
            return;

        curDepth++;
        if(curDepth > resDepth){
            res.add(root.val);
            resDepth++;
        }
        dfs(res, root.right);
        dfs(res, root.left);
        curDepth--;
    }

}
