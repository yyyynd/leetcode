package leetcode.leetCode2022_04;

import javax.sound.midi.Track;
import java.util.LinkedList;

public class k101 {

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

    public boolean isSymmetric(TreeNode root) {
        return dfs(root.left, root.right);
    }

    public boolean dfs(TreeNode left, TreeNode right){
        if (left == null && right == null)
            return true;
        else if (left == null || right == null)
            return false;
        else if (left.val != right.val)
            return false;

        return dfs(left.left, right.right) && dfs(left.right, right.left);
    }
}
