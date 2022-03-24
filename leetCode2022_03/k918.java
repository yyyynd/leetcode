package leetcode.leetCode2022_03;

/**
 * 最后的判断，因为max本身就代表整个数组中的最大子数组，如果这个最大
 * 子数组都是负的，那么就代表整个数组都是负数组成的了，min即为整个数组的
 * 和了，total - min = 0，显然不是正确结果
 */

public class k918 {
    public static void main(String[] args) {
        System.out.println(new k918().maxSubarraySumCircular(new int[]{-2,-3,-2}));
    }
    public int maxSubarraySumCircular(int[] nums) {
        int curMax = 0;
        int curMin = 0;
        int total = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            curMax += num;
            curMin += num;
            total += num;
            max = Math.max(curMax, max);
            min = Math.min(curMin, min);
            if (curMax < 0)
                curMax = 0;
            if (curMin > 0)
                curMin = 0;
        }

        return max > 0 ? Math.max(max, total - min) : max;
    }
}
