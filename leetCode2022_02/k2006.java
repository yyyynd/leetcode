package leetcode.leetCode2022_02;

public class k2006 {
    public int countKDifference(int[] nums, int k) {
        int[] memo = new int[101];
        int ans = 0;
        for (int n : nums)
            memo[n]++;

        for (int i = 1; i < 101 && i + k <= 100; i++){
            ans += memo[i]*memo[i + k];
        }

        return ans;
    }
}
