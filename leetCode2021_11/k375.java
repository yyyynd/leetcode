package leetCode2021_11;

import javax.swing.text.MaskFormatter;
import java.util.Arrays;

/**
 * 在[1,n]中选择出一个答案数字，然后得出不管这个数字是多少，都能保证你能赢得游戏的最小金钱数
 * 题解的思路没有每次指定一个具体的答案数字，而是根据猜测过程，理论上最终left >= right的时候就一定得出结果了
 * 所以他这个 Math.max(dfs(l, x - 1), dfs(x + 1, r)) + x其实就相当于考虑了不同的选择起手和答案选择的
 *
 * 那么记忆化cache中存储的就是在[i][j]范围中，不管答案数字是哪一个，这个范围内保证能猜到结果的最小金钱数
 *
 * 题干中这个 " 确保你获胜 的最小现金数",意思应该就是，不管答案数字是多少，你都有一个或多个起手选择
 * （因为起手选择影响你接下来的选择）在这个金钱限制下保证你赢得比赛，保证获胜就意味着要考虑到最糟糕的情况，
 * 最小就意味着要选出一个选择策略，这个策略产生的代价最小（比如这里就是不同的起手）
 *
 * 你要求的就是在这个[left,right]范围内，你如果以x为起手，你最多要花多少钱才能保证胜利，然后比较这所有起手得出一个最佳
 * 策略（也就是最终花钱最少的起手），之后每一次范围缩小都得出一个最优起手，最终形成一个最终的最优策略
 *
 */
public class k375 {
    static int[][] cache = new int[201][201];
    public int getMoneyAmount(int n) {

        return dfs(1,n);
    }

    public int dfs(int left, int right){
        //l > r说明第一次直接取到答案了
        if(left >= right)
            return 0;
        if(cache[left][right] != 0)
            return cache[left][right];

        int ans = Integer.MAX_VALUE;
        for (int i = left; i <= right; i++){
            int cur = Math.max(dfs(left,i-1), dfs(i+1, right)) + i;
            ans = Math.min(ans, cur);
        }

        cache[left][right] = ans;
        return ans;
    }
}
