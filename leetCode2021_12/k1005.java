package leetCode2021_12;

import java.util.Arrays;

public class k1005 {

    public static void main(String[] args) {
        System.out.println(new k1005().largestSumAfterKNegations(new int[]{-4,-2,-3},
        4));
    }

    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0;
        int ans = 0;
        for (; i < nums.length && nums[i] < 0 && i < k; i++)
            ans += -nums[i];

        //要再次判断多余的转换操作对哪个数进行操作
        if( i < k ){
            if( i == nums.length) {
                i--;
                k--;
            }
            if( i == 0)
                ans += (k - i) % 2 == 0 ? nums[i] : -nums[i];
            else {
                if ((k - i) % 2 == 0)
                    ans += Math.max(nums[i], 0);
                else {
                    if (nums[i] > 0 && nums[i] <= -nums[i - 1])
                        ans += -nums[i];
                    else if (nums[i] > 0 && nums[i] > -nums[i - 1]) {
                        ans += 2 * nums[i - 1];
                        ans += nums[i];
                    } else
                        ans += 2 * nums[i];
                }
            }
            i++;
        }

        for (; i < nums.length; i++)
            ans += nums[i];

        return ans;

    }
}
