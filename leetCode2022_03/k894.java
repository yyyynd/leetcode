package leetcode.leetCode2022_03;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 肯定是希望靠回溯来把树构建出来
 * 没想通如何保证节点剩余可创建数量的控制
 *
 * 看了一个思路，每次传入的数量参数，代表的就是当前子树可以创建的
 * 节点数量，每次+2 -2是保证了能构造出满二叉树，l和 r其实分别代表的是
 * 左右子树的节点数量控制
 */
public class k894 {
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

    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> res = new LinkedList<>();
        if (n % 2 == 0)
            return res;
        HashMap<Integer, List<TreeNode>> memo = new HashMap<>();
        TreeNode root = new TreeNode(0);
        memo.put(1, List.of(root));
        return dfs(memo, n);
    }

    public List<TreeNode> dfs(HashMap<Integer, List<TreeNode>> memo, int n){
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        List<TreeNode> ans = new LinkedList<>();
        //这里其实已经算了一次去掉两个节点了
        //代表着最起码根节点是有两个叶子结点的情况
        int l = 1, r = n - l - 1;

        List<TreeNode> res = new LinkedList<>();
        while (r > 0){
            List<TreeNode> left = dfs(memo, l);
            List<TreeNode> right = dfs(memo, r);
            for (TreeNode lc : left){
                for (TreeNode rc : right){
                    TreeNode root = new TreeNode(0);
                    root.left = lc;
                    root.right = rc;
                    res.add(root);
                }
            }
            l += 2;
            r -= 2;
        }
        memo.put(n, res);
        return res;
    }

}
