package leetCode2021_11;

public class k268 {

    public int missingNumber(int[] nums) {
        int top = nums.length;
        int curSum = 0;
        for(int n : nums)
            curSum += n;
        int sum = (1 + top) * top / 2;
        return sum - curSum;
    }
}
