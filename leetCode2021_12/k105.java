package leetCode2021_12;

public class k105 {
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

    int preorderIndex = 0;//记录前序遍历访问次数
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int mid = 0;
        while (preorder[0] != inorder[mid])
            mid++;
        preorderIndex++;
        TreeNode root = new TreeNode(preorder[0]);

        root.left = build(preorder, inorder, 0, mid - 1);
        root.right = build(preorder, inorder, mid + 1, inorder.length - 1);

        return root;
    }

    public TreeNode build(int[] preorder, int[] inorder, int left, int right){
        if(left > right)
            return null;
        TreeNode root = new TreeNode(preorder[preorderIndex]);
        int mid = left;
        while (preorder[preorderIndex] != inorder[mid])
            mid++;
        preorderIndex++;

        root.left = build(preorder, inorder, left, mid - 1);
        root.right = build(preorder, inorder, mid + 1, right);

        return root;
    }
}
