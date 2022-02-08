package leetcode.leetCode2022_02;

public class k1748 {
    public int sumOfUnique(int[] nums) {
        int[] memo = new int[101];
        int ans = 0;
        for (int n : nums)
            memo[n]++;
        for (int i = 1; i <= 100; i++){
            if(memo[i] == 1)
                ans += i;
        }

        return ans;
    }
}
