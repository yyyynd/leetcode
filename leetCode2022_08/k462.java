package leetcode.leetCode2022_08;

import java.util.Arrays;

public class k462 {

    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int mid = nums[nums.length / 2];
        int res = 0;
        for (int n : nums){
            res += Math.abs(n - mid);
        }

        return res;
    }
}
