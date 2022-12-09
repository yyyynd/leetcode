package leetcode.leetCode2022_11;

public class k1043 {
    public static void main(String[] args) {
        new k1043().maxSumAfterPartitioning(new int[]{1,15,7,9,2,5,10}, 3);
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[arr.length];
        int max = arr[0];
        dp[0] = max;
        for (int i = 1; i < k && i < arr.length; i++) {
            max = Math.max(max, arr[i - 1]);
            dp[i] = max * (i + 1);
        }

        for (int i = k; i < arr.length; i++){
            max = arr[i];
            for (int j = 0; j < k; j++){
                max = Math.max(max, arr[i - j]);
                dp[i] = Math.max(dp[i], max*(j + 1) + dp[i - j - 1]);
            }
        }
        return dp[arr.length - 1];
    }

}
