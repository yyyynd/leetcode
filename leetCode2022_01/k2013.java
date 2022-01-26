package leetcode.leetCode2022_01;

public class k2013 {

    int[][] memo = new int[5000][5000];
    int[][] dir = {{1,1},{1,-1},{-1,-1},{-1,1}};
    public k2013() {

    }

    public void add(int[] point) {
        memo[point[0]][point[1]]++;
    }

    public int count(int[] point) {
        int x = point[0];
        int y = point[1];
        int res = 0;
        //要从四个方向来搜索是否存在三个点和当前点构成正方形
        for(int i = 0; i < 4; i++){
            for(int j = 1; ;j++){
                if(x + dir[i][0] * j > 5000 || x + dir[i][0] * j < 0 ||
                        y + dir[i][1] * j > 5000 || y + dir[i][1] * j < 0)
                    break;
                res += memo[x + dir[i][0] * j][y] * memo[x][y + dir[i][1] * j]
                        *memo[x + dir[i][0] * j][y + dir[i][1] * j];
            }
        }

        return res;
    }
}
