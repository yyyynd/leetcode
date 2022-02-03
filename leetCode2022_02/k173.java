package leetcode.leetCode2022_02;

import java.util.LinkedList;
import java.util.List;

public class k173 {

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

    LinkedList<Integer> list;
    public k173(TreeNode root) {
        list = new LinkedList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode travel = root;
        while (travel != null || !stack.isEmpty()){
            if(travel == null) {
                travel = stack.pollLast();
                list.add(travel.val);
                travel = travel.right;
            }
            while (travel != null){
                stack.add(travel);
                travel = travel.left;
            }
        }

    }

    public int next() {
        return list.poll();
    }

    public boolean hasNext() {
        return !list.isEmpty();
    }
}
