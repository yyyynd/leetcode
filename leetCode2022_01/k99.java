package leetCode2022_01;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 利用中序遍历组成升序的方式找到第一个降序的和第二处产生降序的结点
 */
public class k99 {
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

    public void recoverTree(TreeNode root) {
        TreeNode err1 = null, err2 = null;
        TreeNode preNode = new TreeNode(Integer.MIN_VALUE);
        TreeNode cur = root;
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        while (cur != null || !stack.isEmpty()){
            //当前节点左孩子一直压入栈
            while (cur != null) {
                stack.addLast(cur);
                cur = cur.left;
            }
            if(!stack.isEmpty()){
                TreeNode visitNode = stack.pollLast();
                if(visitNode.val < preNode.val){
                    if(err1 == null){
                        err1 = preNode;
                        err2 = visitNode;
                    }else {
                        err2 = visitNode;
                        break;
                    }
                }//if
                preNode = visitNode;
                cur = visitNode.right;
            }//if
        }//while

        int tmp = err1.val;
        err1.val = err2.val;
        err2.val = tmp;
    }



}
