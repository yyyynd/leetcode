package leetCode2021_11;

import java.util.LinkedList;

public class k700 {
    public static void main(String[] args) {
        LinkedList<TreeNode> test = new LinkedList<>();
        test.add(null);
        System.out.println(test.size());
    }

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

    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode travel = root;
        while (travel != null){
            if(travel.val > val)
                travel = travel.left;
            else if(travel.val < val)
                travel = travel.right;
            else
                return travel;
        }

        return null;
    }
}
