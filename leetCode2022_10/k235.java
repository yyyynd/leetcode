package leetcode.leetCode2022_10;

/**
 * 找最近公共根节点，其实就是判断两个节点出现在哪一颗子树上
 * 如果两个分别在左右子树上，那么当前根节点就是最近的了
 * 否则就判断是继续搜索左树还是右树
 *
 * 需要注意的是其中一个节点就是最近公共根节点本身，因此在计算的时候要求>0，
 * 即<=0都意味着找到了根节点
 */
public class k235 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        TreeNode r = new TreeNode(0);
        r.left = new TreeNode(-1000000000);
        r.right = new TreeNode(1000000000);
        System.out.println(new k235().lowestCommonAncestor(r, r.left, r.right).val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while ((long)(root.val - p.val) * (root.val - q.val) > 0)
            //选择左右子树搜索
            root = p.val < root.val ? root.left : root.right;
        return root;
    }
}
