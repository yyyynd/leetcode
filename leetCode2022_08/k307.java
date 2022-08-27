package leetcode.leetCode2022_08;

import java.util.Arrays;

public class k307 {

    int[] arr;
    int[] sum;

    public k307(int[] nums) {
        this.arr = Arrays.copyOf(nums, nums.length);
        this.sum = new int[nums.length + 1];
        sum[0] = 0;
        sum[1] = nums[0];
        for (int i = 2; i <= nums.length; i++)
            sum[i] = nums[i - 1] + sum[i - 1];
    }

    public void update(int index, int val) {
        int tmp = val - arr[index];
        arr[index] = val;
        for (int i = index + 1; i <= arr.length; i++)
            sum[i] += tmp;
    }

    public int sumRange(int left, int right) {
        return sum[right + 1] - sum[left];
    }
}
