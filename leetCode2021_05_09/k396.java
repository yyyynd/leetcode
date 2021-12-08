package leetCode2021_05_09;

public class k396 {

    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        //数组A的和，同时求出F(0)的值作为初始值
        int sumA = 0;
        int prevSumF = 0;
        for (int i = 0; i < n; i++) {
            sumA += nums[i];
            prevSumF += i * nums[i];
        }

        int ans = prevSumF;
        for (int i = 1; i < n; i++) {
            int sumF = prevSumF + sumA - n * nums[n - i];
            ans = Math.max(sumF, ans);
            prevSumF = sumF;
        }

        return ans;
    }
}
