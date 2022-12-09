package leetcode.leetCode2022_12;

/**
 * 二进制只有01，非二进制必然是0到n-1表示
 * 这里要求的是只用3的幂相加表示，且每个幂数只能用一次
 * 则意味着如果用三进制表示该数，只能存在01位
 *
 * 然后还要记住的就是，就像二进制右移其实就是除2一样，对于其它进制
 * 也是类似的，如这三进制右移其实就是除3
 */
public class k1780 {
    public boolean checkPowersOfThree(int n) {
        while (n > 0) {
            if (n % 3 == 2) {
                return false;
            }
            n /= 3;
        }
        return true;
    }
}
