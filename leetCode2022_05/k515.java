package leetcode.leetCode2022_05;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class k515 {

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(1, 2);
        System.out.println(a.size());
    }

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

    public List<Integer> largestValues(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        dfs(root, 1, ans);
        return ans;
//        List<Integer> ans = new LinkedList<>();
//        LinkedList<TreeNode> travel = new LinkedList<>();
//        int preCount = 0;
//        int curCount = 0;
//
//        if (root == null)
//            return ans;
//
//        travel.add(root);
//        preCount = 1;
//        TreeNode cur = null;
//        int max = Integer.MIN_VALUE;
//        while (!travel.isEmpty()){
//            if (preCount == 0){
//                preCount = curCount;
//                curCount = 0;
//                ans.add(max);
//                max = Integer.MIN_VALUE;
//                continue;
//            }
//
//            cur = travel.pollFirst();
//            preCount--;
//            max = Math.max(max, cur.val);
//
//            if (cur.left != null){
//                travel.add(cur.left);
//                curCount++;
//            }
//
//            if (cur.right != null){
//                travel.add(cur.right);
//                curCount++;
//            }
//
//        }
//        ans.add(max);
//        return ans;
    }


    public void dfs(TreeNode root, int curDepth, ArrayList<Integer> ans){
        if (root == null)
            return;

        if (curDepth > ans.size())
            ans.add(root.val);
        else if (root.val > ans.get(curDepth - 1))
            ans.set(curDepth - 1, root.val);

        dfs(root.left, curDepth + 1, ans);
        dfs(root.right, curDepth + 1, ans);
    }
}
