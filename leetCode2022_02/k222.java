package leetcode.leetCode2022_02;

public class k222 {

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

    //深度遍历找最后一个
    int lastLayerCount = 0;

    public int countNodes(TreeNode root) {
        int ans = 0;
        int depth = 0;
        TreeNode travel = root;

        if (root == null)
            return 0;

        while (travel != null){
            depth++;
            travel = travel.left;
        }

        dfs(root, depth, 1);
        return (int) Math.pow(2, depth - 1) - 1 + lastLayerCount;
    }

    public boolean dfs(TreeNode root, int depth, int curDepth){
        if(root == null)
            return false;

        if(curDepth == depth){
            lastLayerCount++;
            return true;
        }

        if (!dfs(root.left, depth, curDepth + 1))
            return false;

        return dfs(root.right, depth, curDepth + 1);
    }
}
