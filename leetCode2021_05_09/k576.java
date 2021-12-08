package leetCode2021_05_09;

/**
 * 设数组前看下题目条件，如果数字不是很大的话可以考虑直接设数组，因为反正即使浪费也浪费不了多少
 * 如果想节约空间就利用位运算实现位置和步数信息的存储，将其放入集合中
 *
 * 这里其实说白了就是每走一步，都执行四个方向的计算（这就做到了考虑回头情况或者一些奇奇怪怪的路径绕圈啥的）
 */

public class k576 {
    int MOD = (int)1e9+7;
    int m, n, max;
    int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    int[][][] cache;
    public int findPaths(int _m, int _n, int _max, int r, int c) {
        m = _m; n = _n; max = _max;
        cache = new int[m][n][max + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k <= max; k++) {
                    cache[i][j][k] = -1;
                }
            }
        }
        return dfs(r, c, max);
    }

    int dfs(int x, int y, int k) {
        if (x < 0 || x >= m || y < 0 || y >= n)
            return 1;
        if (k == 0)
            return 0;
        if (cache[x][y][k] != -1)
            return cache[x][y][k];
        int ans = 0;
        for (int[] d : dirs) {
            int nx = x + d[0], ny = y + d[1];
            ans += dfs(nx, ny, k - 1);
            ans %= MOD;
        }
        cache[x][y][k] = ans;
        return ans;
    }
}
