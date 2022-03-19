package leetcode.leetCode2022_03;

/**
 * 下标算是从0开始，而且是从左往右开始算，即最左边为0
 * 偶数 0 2 4 6 8
 * 质数 2 3 5 7
 *
 * 暴力解法其实就是执行了5*4*5*4...不断循环，因此这里的
 * 5*4可以简化，直接变成一次*20，
 */
public class k1922 {
    public static void main(String[] args) {
        System.out.println(new k1922().countGoodNumbers(50));
    }
    public int countGoodNumbers(long n) {
        long tmp = 5;
        int m = (int)(1e9 + 7);
        int[] pre = new int[]{5, 4};
        for (int i = 1; i < n; i++){
            tmp = (tmp * pre[ i % 2])% m;
        }
        return (int)tmp;
    }
//
}
