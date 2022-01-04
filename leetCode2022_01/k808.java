package leetCode2022_01;

/**
 * 要找出所有先分完A的方案，与A和B同时分配完的方案，只有这两个可以算作可行方案的概率
 * dp[0][0]的初始化给的是0.5，这就代表了(1+1+1+1)/4/2了，即同时完成的概率/2操作
 * 后续通
 */
public class k808 {
    public double soupServings(int n) {
        n = n / 25 + (n % 25 == 0 ? 0 : 1);
        if (n >= 200)
            return 1;
        //这里i,j分别代表AB已经分配的数量
        double[][] dp = new double[n+1][n+1];
        dp[0][0] = 0.5;//AB要求均为0的时候，怎么选都是符合AB同时分完的要求
        //B为0，A不为0时肯定一直满足要求的结果
        for(int i = 1;i <= n; i++)
            dp[0][i] = 1;
        for (int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                dp[i][j] += dp[Math.max(i-4,0)][j];
                dp[i][j] += dp[Math.max(i-3,0)][j-1];
                dp[i][j] += dp[Math.max(i-2,0)][Math.max(j-2,0)];
                dp[i][j] += dp[i-1][Math.max(j-3,0)];
                dp[i][j] *=0.25;
            }
        }

        return dp[n][n];
    }
}
