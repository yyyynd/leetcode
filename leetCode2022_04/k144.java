package leetcode.leetCode2022_04;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class k144 {
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

    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new LinkedList<>();
        if(root == null)
            return res;

        TreeNode travel = root;
        while (travel != null || !stack.isEmpty()){
            if (travel == null){
                travel = stack.pop().right;
                continue;
            }

            res.add(travel.val);
            stack.push(travel);
            travel = travel.left;
        }

        return res;
    }
}
