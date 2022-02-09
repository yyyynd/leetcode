package leetcode.leetCode2022_02;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class k236 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        LinkedList<TreeNode> p_path = new LinkedList<>();
        LinkedList<TreeNode> q_path = new LinkedList<>();
        dfs(root, p, p_path);
        dfs(root, q, q_path);

        TreeNode preNode = null;
        Iterator<TreeNode> pPathIterator = p_path.iterator();
        Iterator<TreeNode> qPathIterator = q_path.iterator();
        while (pPathIterator.hasNext() && qPathIterator.hasNext()){
            TreeNode a = pPathIterator.next();
            TreeNode b = qPathIterator.next();
            if(a.val != b.val)
                break;
            preNode = a;
        }

        return preNode;
    }

    public boolean dfs(TreeNode root, TreeNode target, LinkedList<TreeNode> list){
        if (root == null)
            return false;

        if(root.val == target.val){
            list.addFirst(root);
            return true;
        }

        if(dfs(root.left, target, list) || dfs(root.right, target, list)){
            list.addFirst(root);
            return true;
        }

        return false;
    }
}
