package leetCode2021_12;

public class k1995 {
    public int countQuadruplets(int[] nums) {
        int n = nums.length;
        int[][][] f = new int[n + 1][110][4];
        f[0][0][0] = 1;
        for (int i = 1; i <= n; i++) {
            int t = nums[i - 1];
            for (int j = 0; j < 110; j++) {
                for (int k = 0; k < 4; k++) {
                    f[i][j][k] += f[i - 1][j][k];
                    if (j - t >= 0 && k - 1 >= 0)
                        f[i][j][k] += f[i - 1][j - t][k - 1];
                }//for
            }//for
        }//for
        int ans = 0;
        for (int i = 3; i < n; i++)
            ans += f[i][nums[i]][3];
        return ans;
    }
}
