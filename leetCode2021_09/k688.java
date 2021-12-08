package leetCode2021_09;

import java.util.HashMap;

/**
 * 这题做错的原因就是记忆化出错了，应该是位置坐标+剩余步数
 * 然后好像计算概率的部分也出现了错误
 * 同时直接统计路线数量也不太合理，这里的数量很容易非常大
 * 所以为了能正确地计算出结果应该把计算概率融入到dfs中（/8)
 */
public class k688 {
    //存储在某位置剩余k步数对应的不出界情况
    HashMap<Integer,long[]> dp;
    //所有情况数量总和
    long sum = 0;
    int N ;
    // x2,y2,x1,y1
    int[][] moves = new int[8][4];

    public static void main(String[] args) {
        System.out.println(new k688().knightProbability(3,2,0,0));
    }
    public double knightProbability(int n, int k, int row, int column) {
        dp = new HashMap<>();
        N = n-1;
        int flag = 2;
        for(int i = 0; i < 8; i+= 2){
            if(i < 4) {
                moves[i][0] = flag;
                moves[i][1] = 0;
                moves[i+1][0] = flag;
                moves[i+1][1] = 0;

            }else{
                moves[i][0] = 0;
                moves[i][1] = flag;
                moves[i+1][0] = 0;
                moves[i+1][1] = flag;
            }
            flag = -flag;
        }

        flag = 1;
        for (int i = 0; i < 8; i++){
            if(i < 4)
                moves[i][3] = flag;
            else
                moves[i][2] = flag;
            flag = -flag;
        }
        long[] ans = dfs(row,column,k);
        return (double) ans[0]/Math.pow(8,k);
    }

    public long[] dfs(int x, int y,int spareStep){
        if(dp.containsKey(spareStep))
            return dp.get(spareStep);

        //当前步数能落在界限内的数量
        long[] res = new long[2];
        if(spareStep == 0) {
            res[0] = 1;
            return res;
        }

        for(int i = 0; i < 8; i++){
            //先判断第一次2步长的跳是否会越界，再判断下一次1步长是否会越界
            if(x + moves[i][0] < 0 || x + moves[i][0] > N ||
                    y + moves[i][1] < 0 || y + moves[i][1] > N)
                res[1]++;
            else if( x + moves[i][2] < 0 || x + moves[i][2] > N ||
                    y + moves[i][3] < 0 || y + moves[i][3] > N)
                res[1]++;

            else {
                long[] nextStepRes = dfs(x + moves[i][0] + moves[i][2],
                        y + moves[i][1] + moves[i][3], spareStep - 1);
                res[0] += nextStepRes[0];
                res[1] += nextStepRes[1];
            }
        }
        dp.put(spareStep,res);
        return res;
    }
}
