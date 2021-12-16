package leetCode2021_12;

import java.util.ArrayList;
import java.util.List;

/**
 * 一开始考虑的是用二叉搜索树性质，判断左右和根的数值
 * 但这有个问题就是，当前判断点的数值可能和一个距离相隔很远（结构上隔了很多层）的结点
 * 冲突，在开始的版本中根本解决不了这个问题，即使多考虑了一个parentRoot也不行
 *
 * 下面的解法是利用二叉搜索树中序遍历升序的性质
 */
public class k98 {
    final int LEFT_CHILD_TREE = 0;
    final int RIGHT_CHILD_TREE = 1;
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
    List<Integer> res = new ArrayList<>();
    public boolean isValidBST(TreeNode root) {
        if(root==null)
            return true;
        inOrder(root);
        for(int i=1;i<res.size();i++){
            if(res.get(i)<=res.get(i-1)){
                return false;
            }
        }
        return true;
    }

    private void inOrder(TreeNode root){
        if(root!=null){
            inOrder(root.left);
            res.add(root.val);
            inOrder(root.right);
        }
    }
//    public boolean isValidBST(TreeNode root) {
//
//        if(root.left != null){
//            if(root.left.val >= root.val || !dfs(root, root.left, LEFT_CHILD_TREE))
//                return false;
//        }
//
//        if(root.right != null){
//            if(root.right.val <= root.val || !dfs(root, root.right, RIGHT_CHILD_TREE))
//                return false;
//        }
//
//        return true;
//    }
//
//    public boolean dfs(TreeNode parentNode, TreeNode root, int type){
//
//        if(root.left != null) {
//            if (root.left.val < root.val && type == LEFT_CHILD_TREE) {
//                if (!dfs(root, root.left, LEFT_CHILD_TREE))
//                    return false;
//            }else if(root.left.val < root.val && type == RIGHT_CHILD_TREE) {
//                if (root.left.val <= parentNode.val)
//                    return false;
//                else if(!dfs(root, root.left, RIGHT_CHILD_TREE))
//                    return false;
//            }else
//                return false;
//        }
//
//        if(root.right != null) {
//            if (root.right.val > root.val && type == RIGHT_CHILD_TREE) {
//                if (!dfs(root, root.right, RIGHT_CHILD_TREE))
//                    return false;
//            }else if(root.right.val > root.val && type == LEFT_CHILD_TREE) {
//                if (root.right.val >= parentNode.val)
//                    return false;
//                else if(!dfs(root, root.right, LEFT_CHILD_TREE))
//                    return false;
//            }else
//                return false;
//        }
//
//        return true;
//
//    }
}
