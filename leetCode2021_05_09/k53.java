package leetCode2021_05_09;

public class k53 {

    public int maxSubArray(int[] nums) {
        int cur = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++){
            if(cur < 0)
                cur = nums[i];
            else
                cur += nums[i];

            result = Math.max(result,cur);
        }
        return result;
    }
}
