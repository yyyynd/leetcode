package leetCode2021_05_09;

import java.util.*;

/**
 * 本质上还是一种组合问题，而且是那种不需要求出具体的组合结果的，只要符合要求计数就行的题
 * 这里朴素的想法就行依次遍历，但很明显这是会超时的
 *
 * 这里两道题的解法都是利用HashMap记录重复元素来实现减少重复计算
 *
 * 这里判断数是否为2的幂也很值得学习，因为通常我们想到的都枚举数相加得出一个数，判断它是不是2的幂
 * 但这里反其道行之,因为我们的目标就是求出一对能组成2的幂的数，那么我们不如枚举所有2的幂（这里有最大限制）
 * 通过2的幂 - curNum（当前遍历点的数）得出组成该2的幂的组合数，然后去map中寻找是否存在该数，并通过该数的数量
 * 和curNum在map中的数量相乘得出组合数量(这样顶多遍历22次，如果数据很大的时候枚举远远不止22次）
 *
 * 这个思路非常适合那些在一堆元素中求组合，该组合的和满足某一条件这样的题目，就非常适合这样的思路来求（利用哈希表实现快速查询
 * ，不过还有更高效的方式）
 *
 * 以上两个个思路就做到了极大减少了时间复杂度
 */
public class k1711 {
    public int countPairs(int[] ds) {
        final int MOD = (int)1e9+7;
        int maxVal = 1 << 22;
        int maxSum = maxVal * 2;
        int pairs = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int n = ds.length;
        for (int i = 0; i < n; i++) {
            int val = ds[i];
            for (int sum = 1; sum <= maxSum; sum <<= 1) {
                int count = map.getOrDefault(sum - val, 0);
                pairs = (pairs + count) % MOD;
            }
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        return pairs;
    }

    int mod = (int)1e9+7;
    int max = 1 << 22;
    //这里比上一个块的地方在于，重复数只计算一次了
    //而上面重复数还是会依次遍历到的
    public int countPairs_2(int[] ds) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int d : ds) {
            map.put(d, map.getOrDefault(d, 0) + 1);
        }
        long ans = 0;
        for (int x : map.keySet()) {
            for (int i = 1; i < max; i <<= 1) {
                //这里的t其实就是能和x组成2的幂的数
                int t = i - x;
                if (map.containsKey(t)) {
                    //配对数，为自己本身，
                    if (t == x)
                        ans += (long) (map.get(x) - 1) * map.get(x);
                    else
                        ans += (long) map.get(x) * map.get(t);
                }
            }
        }
        //这是为了去除重复结果
        ans >>= 1;
        return (int)(ans % mod);
    }
}
