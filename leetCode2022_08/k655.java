package leetcode.leetCode2022_08;

import java.util.LinkedList;
import java.util.List;

public class k655 {
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

    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> ans = new LinkedList<>();
        if (root == null)
            return ans;
        int height = dfs(root) - 1;
        int colNum = (int) Math.pow(2, height + 1) - 1;
        LinkedList<TreeNode> list = new LinkedList<>();
        LinkedList<Integer> indexList = new LinkedList<>();
        list.add(root);
        indexList.add((colNum - 1) / 2);
        //init first row
        LinkedList<String> curRow = new LinkedList<>();
        for (int i = 0; i < colNum; i++){
            if (i == (colNum - 1) / 2)
                curRow.add(String.valueOf(root.val));
            else
                curRow.add("");
        }
        ans.add(curRow);
        for (int i = 1; i <= height; i++){
            curRow = new LinkedList<>();
            int listSize = list.size();
            int count = 0;
            while (listSize != 0){
                TreeNode tmp = list.poll();
                int tmpIndex = indexList.poll();
                if (tmp.left != null){
                    count = tmpIndex - (int) Math.pow(2, height - i);
                    add(curRow, tmp.left.val, count);
                    list.add(tmp.left);
                    indexList.add(count);
                }

                if (tmp.right != null){
                    count = tmpIndex + (int) Math.pow(2, height - i);
                    add(curRow, tmp.right.val, count);
                    list.add(tmp.right);
                    indexList.add(count);
                }

                listSize--;
            }
            count++;
            while (count++ < colNum)
                curRow.add("");
            ans.add(curRow);
        }

        return ans;
    }

    public void add(List<String> curRow, int val, int index){
        int curSize = curRow.size() - 1;
        while (curSize + 1< index) {
            curRow.add("");
            curSize++;
        }
        curRow.add(String.valueOf(val));
    }

    //find tree height
    public int dfs(TreeNode root){
        if (root == null)
            return 0;

        int left = dfs(root.left);
        int right = dfs(root.right);
        return Math.max(left, right) + 1;
    }

}

