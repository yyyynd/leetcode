package leetcode.leetCode2022_02;

public class k209 {
    public static void main(String[] args) {
        System.out.println(new k209().minSubArrayLen(11, new int[]{1,2,3,4,5}));
    }
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = -1;
        int len = Integer.MAX_VALUE;
        int curSum = 0;

        while (right <= nums.length- 2 || curSum >= target){
            if(curSum < target) {
                right++;
                curSum += nums[right];
            }else{
                len = Math.min(right - left + 1, len);
                curSum -= nums[left];
                left++;
            }
        }

        return len == Integer.MAX_VALUE ? 0 : len;
    }
}
