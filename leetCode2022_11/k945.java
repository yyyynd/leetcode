package leetcode.leetCode2022_11;

import java.util.Arrays;

public class k945 {
    public static void main(String[] args) {
        System.out.println(new k945().minIncrementForUnique(new int[]{3,2,1,2,1,7}));
    }
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 1; i < nums.length; i++){
            if (nums[i] <= nums[i - 1]){
                int add = nums[i - 1] - nums[i] + 1;
                ans += add;
                nums[i] += add;
            }
        }
        return ans;
    }
}
