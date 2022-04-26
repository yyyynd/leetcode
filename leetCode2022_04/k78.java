package leetcode.leetCode2022_04;

import java.util.LinkedList;
import java.util.List;

public class k78 {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        //空集也算
        res.add(new LinkedList<>());
        dfs(nums, 0, new LinkedList<>());
        return res;
    }

    public void dfs(int[] nums, int index, LinkedList<Integer> comb){
        if (index == nums.length){
            res.add(new LinkedList<>(comb));
            return;
        }

        for (int i = index; i < nums.length; i++){
            comb.add(nums[i]);
            res.add(new LinkedList<>(comb));
            dfs(nums, i + 1, comb);
            comb.removeLast();
        }
    }
}
