package leetcode.leetCode2022_08;

import java.util.LinkedList;
import java.util.List;

public class k662 {

   static public class TreeNode {
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

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2), null);
        new k662().widthOfBinaryTree(root);
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;

        LinkedList<TreeNode> list = new LinkedList<>();
        LinkedList<Integer> indexList = new LinkedList<>();
        int ans = 0;
        list.add(root);
        indexList.add(1);
        while (!list.isEmpty()){
            int i = 0;
            int size = list.size();
            ans = Math.max(ans, indexList.getLast() - indexList.getFirst() + 1);
            while (i++ < size){
                TreeNode cur = list.poll();
                int curIndex = indexList.poll();
                if (cur.left != null ){
                    list.add(cur.left);
                    indexList.add(curIndex * 2);
                }
                if (cur.right != null){
                    list.add(cur.right);
                    indexList.add(curIndex * 2 + 1);
                }
            }
        }

        return ans;
    }
}
