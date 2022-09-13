package leetcode.leetCode2022_09;

public class k795 {
    public static void main(String[] args) {
        new k795().numSubarrayBoundedMax(new int[]{1,2,3,1,1,1}, 3, 3);
    }
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int ans = 0;
        int curLen = 0;
        int lastIndex = 0;
        int startIndex = -1;
        boolean flag = false;
        for (int i = 0; i < nums.length; i++){
            int n = nums[i];
            if (n >= left && n <= right){
                curLen++;
                flag = true;
                lastIndex = i;
                ans += curLen;
            }else if (n < left){
                if (flag)
                    ans += lastIndex - startIndex;
                curLen++;
            }else {
                curLen = 0;
                flag = false;
                startIndex = i;
            }
        }

        return ans;
    }
}
