package leetcode.leetCode2022_08;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class k18 {


    List<List<Integer>> ans = new LinkedList<>();

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        dfs(nums, target, new LinkedList<>(), 0, 0);
        return ans;
    }

    public void dfs(int[] nums, int target, LinkedList<Integer> combine, int index, long sum){
        if (combine.size() == 4){
            if (sum == target)
                ans.add(new LinkedList<>(combine));
            return;
        }

        int pre = Integer.MIN_VALUE;
        for (int i = index; i < nums.length; i++){
            if (pre != nums[i]){
                if (nums[i] > 0 && sum + nums[i] > target)
                    return;
                pre = nums[i];
                combine.add(nums[i]);
                dfs(nums, target, combine, i + 1, sum + nums[i]);
                combine.removeLast();
            }
        }
    }

}
