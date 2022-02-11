package leetcode.leetCode2022_02;

import java.util.Arrays;

public class k1984 {
    public int minimumDifference(int[] nums, int k) {
        int ans = Integer.MAX_VALUE;
        k -= 1;
        Arrays.sort(nums);
        for (int i = 0; i + k < nums.length; i++)
            ans = Math.min(nums[i + k] - nums[i] , ans);

        return ans;
    }
}
