package leetCode2021_12;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class k103 {

    class TreeNode {
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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        LinkedList<List<Integer>> ans = new LinkedList<>();
        List<TreeNode> preLayer = new LinkedList<>();
        int dir = -1;// 1代表从左到右, -1代表从右向左

        if(root == null)
            return ans;

        preLayer.add(root);

        while (!preLayer.isEmpty()){
            LinkedList<TreeNode> curLayer = new LinkedList<>();
            Iterator<TreeNode> iterator = preLayer.listIterator();
            LinkedList<Integer> subAns = new LinkedList<>();
            while (iterator.hasNext()){
                TreeNode travel = iterator.next();
                if(travel == null)
                    continue;
                subAns.add(travel.val);
                if(dir == 1) {
                    curLayer.addFirst(travel.right);
                    curLayer.addFirst(travel.left);
                } else{
                    curLayer.addFirst(travel.left);
                    curLayer.addFirst(travel.right);
                }
            }//while
            preLayer = curLayer;
            ans.add(subAns);
            dir = -dir;
        }
        ans.pollLast();
        return ans;
    }
}
