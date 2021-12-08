package leetCode2021_05_09;

import java.util.Arrays;

public class k1877 {

    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int max = 0;
        int l = 0;
        int r = nums.length-1;
        while ( l < r){
            max = Math.max(max,nums[l]+nums[r]);
            l++;
            r--;
        }

        return max;
    }
}
