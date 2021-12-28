package leetCode2021_12;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class k113 {
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
    List<List<Integer>> ans = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(new LinkedList<>(), root, 0, targetSum);
        return ans;
    }

    public void dfs(List<Integer> list, TreeNode root, int sum, int targetSum){
        //空指针，不判断
        if(root == null)
            return;
//        //大于目标值了，结束dfs
//        if(sum + root.val > targetSum)
//            return;
        //达到目标值了，直接添加结果
        if(sum + root.val == targetSum){
            if(root.left == null && root.right == null) {
                List<Integer> curAns = new LinkedList<>();
                curAns.addAll(list);
                curAns.add(root.val);
                ans.add(curAns);
                return;
            }
        }
        //符合目标值但不是子结点，或者未符合目标值，继续计算
        list.add(root.val);
        dfs(list, root.left, sum + root.val, targetSum);
        dfs(list, root.right, sum + root.val, targetSum);
        ((LinkedList)list).removeLast();

    }
}
