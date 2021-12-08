package leetCode2021_05_09;

import java.util.Arrays;

public class k1744{
    public static void main(String[] args) {
        int[] c = {7,4,5,3,8};
        int[][] q ={{0,2,2},{4,2,4},{2,13,1000000000}};

        System.out.println(Arrays.toString(new k1744().canEat(c, q)));
    }
    /**
     * 想要在第N天（以0天起）吃到第i类糖果
     * 注意有一个每天最多吃k颗的和至少吃一颗的限制
     * 那么假设每天都吃k颗吃到i类之前所有糖果的天数 < 期望的天数
     * 每天都只吃1颗的吃到i类之前所有糖果的天数 > 期望的天数
     * 则在所期望的天一定能吃到i类
     *
     * 但也有可能吃到i类那天也在吃i之前的种类（也就是哪怕每天都吃最大限制还是不能在期望的D之前吃完前置种类
     */
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        //糖果种类数量
        int candieKinds = candiesCount.length;
        //问题数量
        int queriesNum = queries.length;
        //答案数组
        boolean[] answer = new boolean[queriesNum];
        //吃到第i种糖果所需要吃掉糖果的总数量
        long[] candieAccumulativeNum = new long[candieKinds];

        for(int i = 1; i < candieKinds; i++)
            candieAccumulativeNum[i] = candiesCount[i-1] + candieAccumulativeNum[i-1];

        for(int i = 0;i < queriesNum; i++){
            int favoriteTypei = queries[i][0];
            int favoriteDayi = queries[i][1];
            int dailyCapi = queries[i][2];



            if ((float)candieAccumulativeNum[favoriteTypei]/dailyCapi < favoriteDayi+1
            && candieAccumulativeNum[favoriteTypei] + candiesCount[favoriteTypei] >= favoriteDayi+1)
                answer[i] = true;
            else
                answer[i] = false;
        }

        return answer;
    }
}
