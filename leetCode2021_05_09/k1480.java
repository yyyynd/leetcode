package leetCode2021_05_09;

public class k1480 {
    public int[] runningSum(int[] nums) {

        for (int i = 1; i < nums.length; i++)
            nums[i] += nums[i-1];

        return nums;
    }
}
