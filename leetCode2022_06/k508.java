package leetcode.leetCode2022_06;

import java.util.*;

public class k508 {

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

    HashMap<Integer, Integer> count = new HashMap<>();

    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null)
            return new int[0];

        dfs(root);
        int max = 0;
        int num = 0;
        LinkedList<Integer> list = new LinkedList<>();
        Set<Map.Entry<Integer, Integer>> set = count.entrySet();
        for (Map.Entry<Integer, Integer> entry : set){
            if (entry.getValue() > max){
                num = 1;
                max = entry.getValue();
                list.addFirst(entry.getKey());
            }else if (entry.getValue() == max){
                num++;
                list.addFirst(entry.getKey());
            }
        }
        int[] ans = new int[num];
        for (int i = 0; i < num; i++){
            ans[i] = list.get(i);
        }

        return ans;
    }

    public int dfs(TreeNode root){
        if (root == null)
            return 0;

        int sum = root.val;
        sum += dfs(root.left);
        sum += dfs(root.right);

        count.put(sum, count.getOrDefault(sum, 0) + 1);
        return sum;
    }
}
