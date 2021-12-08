package leetCode2021_05_09;

import java.util.Arrays;

/**
 * 这题表面上看像是一个01背包问题，但要注意这里，coins相当于背包容量
 * costs[i]相当于每个物品的所占空间，但每个物品所对应的价值都是一样的都是1
 * 这就导致这个问题和背包问题有着区别了，在背包问题中，我们要求的是利用限量的空间
 * 获取最大的价值，但这里由于价值都为1，那么我们只要从小到大依次取就行了
 *
 * 而背包问题中，我们是要考虑到物品是有对应价值的，有可能占的空间多反而价值低，那么就不像
 * 我们这里只要占的空间小就取了
 */
public class k1833 {

    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int count = 0;
        for (int c : costs){
            if(c > coins)
                break;
            count++;
            coins -= c;
        }

        return count;
    }
}
