package leetcode.leetCode2022_10;

import java.util.HashMap;

/**
 * 这题其实也类似于找指定数个节点的最近公共父节点，但之前那题是一个二叉搜索树
 * 这里是单纯就是一个二叉树，且找的是深度最大的几个节点
 *
 * 但其实解决的思路也是很类似的，既然找最大公共父节点，就意味着该节点的左右子树
 * 的深度一定是要一样的，那么我们只要每次比较左右子树的深度就可以判断其是否包含
 * 全部的最大深度节点且其是否为公共父节点了
 *
 * 如果两边深度相同则证明就是该根节点，但如果左右深度不同，则证明公共父节点在左右子树中
 * 深度更大的那一个里面
 */
public class k865 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    HashMap<Integer, Integer> memo = new HashMap<>();
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        if (leftDepth == rightDepth)
            return root;

        if (leftDepth > rightDepth){
            return subtreeWithAllDeepest(root.left);
        }else {
            return subtreeWithAllDeepest(root.right);
        }
    }

    public int getDepth(TreeNode root){
        if(root == null)
            return 0;
        if (memo.containsKey(root.val))
            return memo.get(root.val);

        int dp = getDepth(root.left);
        dp = Math.max(dp, getDepth(root.right));
        memo.put(root.val, dp + 1);
        return dp + 1;
    }
}
