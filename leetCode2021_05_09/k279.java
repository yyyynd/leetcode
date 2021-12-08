package leetCode2021_05_09;

public class k279  {

    public int numSquares(int n) {
        int[] dp = new int[n + 1]; // 默认初始化值都为0
        for (int i = 1; i <= n; i++) {
            dp[i] = i; // 最坏的情况就是每次+1
            for (int j = 1; i - j * j >= 0; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1); // 动态转移方程
            }
        }
        return dp[n];

//        int maxSqrtNum = (int)Math.sqrt(n);
//        int[][] dp = new int[maxSqrtNum+1][n+1];
//        int min = 0;
//
//        //可取0个数，那么直接每一位都放入假设全用1的值(当然也可能就只能全取1
//        //反正作为最大情况
//        for(int i = 0;i <= n; i++)
//            dp[0][i] = n;
//        for(int i = 1; i <= maxSqrtNum; i++){
//            for(int j = 1; j <= n; j++){
//                dp[i][j] = dp[i-1][j];
//                if(i*i <= j)
//                    dp[i][j] = Math.min(dp[i-1][j],dp[i][j-i*i]+1);
//            }
//        }
//
//        return dp[maxSqrtNum][n];
    }
}
