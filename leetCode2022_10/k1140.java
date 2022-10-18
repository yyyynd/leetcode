package leetcode.leetCode2022_10;

/**
 * 这题可以DP，也可以记忆化搜索，估计DP应该是更快些
 * 记忆化搜索的化，即剪枝，一般就是通过HashMap，或者像这里由于有两个指标
 * 即剩余多少石子堆和可选的最大范围两个，所以用一个二维数组也可以轻松做到
 *
 * 所以总结一下一般来说的记忆化就是通过Map或者数组来实现的（其实这么说DP也就相当于一个记忆化
 */

public class k1140 {

    int[][] memo;
    public int stoneGameII(int[] piles) {
        memo = new int[piles.length + 1][100];
        int[] sum = new int[piles.length + 1];
        for (int i = 0; i < piles.length; i++)
            sum[i + 1] = sum[i] + piles[i];

        return dfs(sum, 1, 1);
    }

    public int dfs(int[] sum, int index, int M){
        if (index >= sum.length)
            return 0;
        if (memo[index][M] != 0)
            return memo[index][M];
        int cur = 0;
        for (int i = index; i < index + 2 * M && i < sum.length; i++){
            int tmp = dfs(sum, i + 1, Math.max(i - index + 1, M));
            cur = Math.max(cur, sum[sum.length - 1] - tmp - sum[index - 1]);
        }

        memo[index][M] = cur;
        return cur;
    }
}
