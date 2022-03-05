package leetcode.leetCode2022_03;

public class k713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int cur = 1;
        int ans = 0;
        int left = 0;
        int right = 0;
        if(k == 0)
            return 0;

        while (right <= nums.length - 1){
            if(cur * nums[right] < k) {
                ans += right - left + 1;
                cur *= nums[right++];
            } else{
                if(cur != 1)
                    cur /= nums[left];
                left++;
            }
            if(left > right)
                right++;
        }

        return ans;
    }
}
