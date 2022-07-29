package leetcode.leetCode2022_07;

public class k915 {
    public int partitionDisjoint(int[] nums) {
        int left_max = nums[0];
        int right_max = 0;
        int left_len = 1;
        for (int i = 1; i < nums.length; i++){
            if (left_max > nums[i]){
                left_len = i + 1;
                left_max = Math.max(right_max, left_max);
                right_max = 0;
            }else {
                right_max = Math.max(right_max, nums[i]);
            }
        }

        return left_len;
    }
}
