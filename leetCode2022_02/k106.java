package leetcode.leetCode2022_02;

import java.util.HashMap;

public class k106 {

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

    int index;
    HashMap<Integer, Integer> map;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.index = postorder.length - 1;
        this.map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);

        return build(inorder, postorder, 0, postorder.length - 1);
    }

    public TreeNode build(int[] inorder, int[] postorder, int left, int right){
        if(left > right)
            return null;

        TreeNode root = new TreeNode(postorder[index]);
        int mid = map.get(postorder[index--]);
        root.right = build(inorder, postorder, mid + 1, right);
        root.left = build(inorder, postorder, left, mid - 1);

        return root;
    }
}
