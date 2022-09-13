package leetcode.leetCode2022_09;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * 很简单的利用Hash和DFS来解决问题
 * 但要注意的是你要保证每个根节点生成的key字符串是唯一的，但我们都知道只有先序 + 中序或者后序 +中序
 * 才能保证树的唯一性，因此在这里生成key的时候，给根节点后加入“——”来和左右子树的字符串进行分割，达到
 * 保证不会出现歧义的效果（否则直接相连很可能是会出现歧义的
 *
 * 这个能保证唯一的原理就是，假设只有先序的时候，我们无法构建出唯一子树就是因为不知道节点到底属于哪个子树
 * 但现在我们为每个节点和子树的序列进行分割，这就可以很轻松地判断哪个子序列是属于哪个子树的了
 *
 * 这里我们的生成的字符串就相当于这个先序序列
 */
public class k652 {
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

    List<TreeNode> ans;
    HashMap<String, Integer> memo;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        ans = new LinkedList<>();
        memo = new HashMap<>();
        dfs(root);
        return ans;
    }

    public String dfs(TreeNode root){
        if (root == null)
            return " ";

        String sub = root.val + "_" + dfs(root.left) + dfs(root.right);
        if (memo.containsKey(sub)){
            if (memo.get(sub) == 1 ){
                ans.add(root);
                memo.put(sub, 2);
            }
        }else {
            memo.put(sub, 1);
        }

        return sub;
    }
}
