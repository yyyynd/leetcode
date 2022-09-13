package leetcode.leetCode2022_09;

import java.util.HashSet;

/**
 * 一种解法是利用前缀树来实现
 * 这里简单来说就是一位一位推断是否可以为1，利用异或性质
 * 即 a ^ b = c 有 a ^ c = b，那么假设我们如果知道存在一合法值 c
 * 那么通过 a ^ c 必能获得一个数组中的元素 b
 *
 * 这里其实还可以继续减少耗时，就是通过移位进行低位计算前缀来减少
 * 计算的耗时？
 */
public class k421 {
    public int findMaximumXOR(int[] nums) {
        int res = 0;
        HashSet<Integer> prefix = new HashSet<>();
        for (int i = 30; i >= 0; i--){
            //要判断新的一位，增一位1
            res <<= 1;
            //假设当前位可以被置为1
            int tmp = res | 1;
            prefix.clear();
            for (int n : nums){
                int curNumPrefix = n >> i;
                if (prefix.contains(curNumPrefix ^ tmp)){
                    res = tmp;
                    break;
                }
                prefix.add(curNumPrefix);
            }
        }

        return res;
    }
}
