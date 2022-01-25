package leetcode.leetCode2022_01;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class k107 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
 }


    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        if(root == null)
            return res;

        queue.add(root);
        while (!queue.isEmpty()){
            List<Integer> curList = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++){
                TreeNode parent = queue.poll();
                curList.add(parent.val);
                if(parent.left != null)
                    queue.add(parent.left);
                if(parent.right != null)
                    queue.add(parent.right);
            }
            res.addFirst(curList);
        }
        return res;
    }
}
