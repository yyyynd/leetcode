package leetcode.leetCode2022_06;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class k442 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new LinkedList<>();
        for (int n : nums){
            n = Math.abs(n) - 1;
            if (nums[n ] < 0)
                ans.add(n + 1);
            else
                nums[n ] = -nums[n];
        }

        return ans;
    }
}
