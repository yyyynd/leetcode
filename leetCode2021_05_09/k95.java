package leetCode2021_05_09;

import java.util.LinkedList;
import java.util.List;


/**
 * 这题算是一个排列问题，难点就是二叉树性质所带来的问题
 * 其实就是用了递归，递归在有的题中确实会产生很多重复计算（尤其是计算值的问题
 * 但如果是在像是单纯的排列问题中使用一般是没什么问题的
 */
public class k95 {
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

    public List<TreeNode> generateTrees(int n) {
        return createTree(1,n);
    }

    //递归建立左右子树
    private List<TreeNode>  createTree(int start,int end){
        List<TreeNode> ans = new LinkedList<>();
        if(start > end){
            ans.add(null);
            return ans;
        }
        if(start == end){
            TreeNode root  = new TreeNode(start,null,null);
            ans.add(root);
            return ans;
        }
        for(int i = start; i <= end; i++){
            List<TreeNode> left = createTree(start,i-1);
            List<TreeNode> right = createTree(i+1,end);
            for (TreeNode l : left){
                for (TreeNode r : right){
                    TreeNode root = new TreeNode(i,l,r);
                    ans.add(root);
                }
            }
        }//for(int i

        return ans;
    }
}
