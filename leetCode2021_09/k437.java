package leetCode2021_09;

import java.util.HashSet;

/**
 * 明显的一个求区间元素和满足要求的题，那么这种连续区间的用前缀和来减少计算量
 * 是很容易想到的思路，本质上就是一个利用前缀和相减得出区间，只不过这里知道
 * 目标区间值所以可以直接利用（前缀和 - 目标值）得出的值判断是否存在可以减去的
 * 区间
 *
 * 前缀和的题也要注意题目要求的结果是什么，这是求符合条件的区间"数量"问题，
 * 如果是数量问题，且区间值是固定的，那么意味着我们只需要通过（当前总和-目标值）
 * 得出我们所需要减去的区间值（前缀和得出某一区间的思路）,如果这个区间值存在记录
 * 就意味着存在符合条件的区间，
 *
 * 但这里还涉及到回溯问题，那么就要每次回溯要删除遍历过的层次的记录
 */
public class k437 {
    public static void main(String[] args) {
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    int ans = 0;
    int target;
    HashSet<Integer> dp;
    public int pathSum(TreeNode root, int targetSum) {
        target = targetSum;
        dp = new HashSet<>();
        dp.add(0);
        dfs(root,0);
        return ans;
    }

    public void dfs(TreeNode root, int curSum){
        if(root == null)
            return;
        dp.add(curSum + root.val);
        if(dp.contains(curSum - target))
            ans++;
        dfs(root.left, curSum);
        dfs(root.right, curSum);
        dp.remove(curSum + root.val);
    }
}
