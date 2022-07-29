package leetcode.leetCode2022_07;

import leetcode.leetCode2022_03.k148;

import java.util.LinkedList;
import java.util.List;

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

    public boolean isCousins(TreeNode root, int x, int y) {
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        int index1;
        int index2;
        TreeNode travel = null;
        while (!list.isEmpty()){
            int len = list.size();
            index1 = -1;
            index2 = -1;
            for (int i = 0; i < len; i++){
                travel = list.poll();
                if (travel == null)
                    continue;
                if (travel.val == x)
                    index1 = i;
                else if (travel.val == y)
                    index2 = i;
                list.add(travel.left);
                list.add(travel.right);
            }
            if (index1 != -1 && index2 != -1){
                return index1 / 2 == index2 / 2;
            }else if (index1 != -1 || index2 != -1)
                return false;
        }

        return false;
    }
}
