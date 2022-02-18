package leetcode.leetCode2022_02;

public class k450 {
    class TreeNode {
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

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;

        TreeNode tmp = root;
        TreeNode preTmp = null;
        while (tmp != null && tmp.val != key){
            preTmp = tmp;
            if (tmp.val > key)
                tmp = tmp.left;
            else
                tmp = tmp.right;
        }

        //节点不存在
        if(tmp == null)
            return root;

        //四种情况，L空R非空，L非空R空，LR非空，LR空
        if(tmp.left == null && tmp.right != null)
            fun(tmp, tmp.right);
        else if(tmp.left != null && tmp.right == null)
            fun(tmp, tmp.left);
        else if(tmp.left != null){
            TreeNode travel = tmp.right;
            while (travel.left != null)
                travel = travel.left;
            travel.left = tmp.left;
            fun(tmp, tmp.right);
        }else{
            //防止删的是根节点
            if (preTmp == null)
                return null;
            //判断删的左右
            if (preTmp.val > tmp.val)
                preTmp.left = null;
            else
                preTmp.right = null;
        }

        return root;
    }


    public void fun(TreeNode root, TreeNode tmp){
        root.val = tmp.val;
        root.left = tmp.left;
        root.right = tmp.right;
    }

}
