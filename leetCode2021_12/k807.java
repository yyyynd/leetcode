package leetCode2021_12;

/**
 * 首先找出每一列和行的最大值，即为天际线
 * 然后根据每一个建筑在增加高度的时候考虑到其所在的行列，根据这个位置对应的边际线值进行比较
 * 判断最多可以增加多少的高度
 */
public class k807 {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] rowMax = new int[grid.length];
        int[] colMax = new int[grid[0].length];
        int ans = 0;

        for (int i = 0; i < grid.length; i++){
            for (int n : grid[i])
                rowMax[i] = Math.max(rowMax[i], n);
        }

        for (int i = 0; i < grid[0].length; i++){
            for (int j = 0; j < grid.length; j++){
                colMax[i] = Math.max(colMax[i], grid[j][i]);
            }
        }

        for(int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                ans += Math.min(rowMax[i], colMax[j]) - grid[i][j];
            }
        }

        return ans;
    }
}
