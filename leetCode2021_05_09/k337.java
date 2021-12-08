package leetCode2021_05_09;

import java.util.HashMap;

public class k337 {

    HashMap<TreeNode,Integer> map;

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

    public int rob(TreeNode root) {
        this.map = new HashMap<>();
        return fun(root);
    }

    public int fun(TreeNode root){
        if(root == null)
            return 0;
        if(map.containsKey(root))
            return map.get(root);

        int l_leftMax = 0;
        int l_rightMax = 0;
        int r_leftMax = 0;
        int r_rightMax = 0;
        int leftMax = fun(root.left);
        int rightMAX = fun(root.right);

        if(root.left != null){
            l_leftMax = fun(root.left.left);
            l_rightMax = fun(root.left.right);
        }
        if(root.right != null){
            r_leftMax = fun(root.right.left);
            r_rightMax = fun(root.right.right);
        }

        int max = Math.max(root.val+l_leftMax+l_rightMax+r_leftMax+r_rightMax,
                leftMax+rightMAX);
        map.put(root,max);
        return max;
    }
}
