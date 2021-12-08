package leetCode2021_05_09;

public class k1049 {

    public static void main(String[] args) {
        int[] stones = {2,7,4,1,8,1};
        System.out.println(new k1049().lastStoneWeightII(stones));
    }
    /**
     *这道题的目的就是不断进行两两相撞后得出的石头要是最小的
     * 理一下思路就是我们希望最后得出两个大小相差最小的石头进行碰撞
     * 那么这里碰撞后产生的石头是可放回的，但产生的新石头也是由基础石头产生的
     * 那么实际上最后留的两个石头也不过是许多基础石头产生
     *
     * 这样两个最后留下的石头式子展开实际上就是一堆基础石头相减相加
     * 整合一下就可以发现一组的符号全为正，一组的符号全为负
     * 所以这个问题和k494一样都是个正负号加减问题
     * 那么久需要对公式进行一定的整理，整理出一个只需要求出一半（正or负集合）的公式就可以了
     * 当然这里比较简单，要求出最小的差距，只要一半的集合总值是最接近总值的一半就行了
     */
    public int lastStoneWeightII(int[] stones) {
        int row = stones.length;
        int sum = 0;
        for (int s : stones)
            sum += s;
        int target = sum/2;
        int[][] dp = new int[row+1][target+1];

        for(int i = 1;i <= row; i++){
            for(int t = 1;t <= target; t++){
                //这一步是假设如果当前目标值没法放下该石头
                dp[i][t] = dp[i-1][t];
                if(t-stones[i-1] >= 0)
                    dp[i][t] = Math.max(dp[i-1][t-stones[i-1]]+stones[i-1] ,dp[i][t]);
            }//for
        }//for

        return Math.abs(sum - dp[row][target]*2);
    }
}
