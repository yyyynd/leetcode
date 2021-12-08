package leetCode2021_09;

public class k600 {
    public static void main(String[] args) {
        System.out.println(new k600().findIntegers(5));
    }
    public int findIntegers(int n) {
        int[][] dp;
        int bits = 1;
        int ans = 0;

        if(n == 1)
            return 2;

        while (n >> bits != 0)
            bits++;

        int preBit = 1;
        int i;
        dp = new int[bits][2];
        dp[0][0] = 1;
        dp[0][1] = 1;

        for (i = 1; i < bits-1; i++){
            dp[i][0] += dp[i-1][0] + dp[i-1][1];
            dp[i][1] = dp[i-1][0];
        }

        ans = dp[bits-2][1] + dp[bits-2][0];

        for (i = bits-1; i >= 1; i--){
            int curBit = (n >> i-1) & 1;
            if(curBit == 1) {
                ans += dp[i - 1][0];
                if(preBit == 1)
                    break;
            }
            preBit = curBit;
        }
        //如果迭代完了，说明并没有因为中间出现连续导致循环结束
        if(i == 0)
            return ans + 1;

        return ans;
    }
}
