package leetcode.leetCode2022_07;

import java.util.LinkedList;

public class k919 {

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

    class CBTInserter {

        LinkedList<TreeNode> list = new LinkedList<>();
        TreeNode root = null;

        public CBTInserter(TreeNode root) {
            this.root = root;
            TreeNode t = null;
            boolean flag = false;
            list.add(root);

            while (!flag){
                int size = list.size();
                for (int i = 0; i < size; i++){
                    t = list.peekFirst();
                    if (t.left == null) {
                        flag = true;
                        break;
                    }else if (t.right == null){
                        flag = true;
                        list.add(t.left);
                        break;
                    }
                    list.add(t.left);
                    list.add(t.right);
                    list.removeFirst();
                }
            }
        }

        public int insert(int val) {
            TreeNode t = list.peekFirst();
            if (t.left == null){
                t.left = new TreeNode(val);
                list.add(t.left);
            }else {
                t.right = new TreeNode(val);
                list.add(t.right);
                list.removeFirst();
            }
            return t.val;
        }

        public TreeNode get_root() {
            return this.root;
        }

    }
}
