package leetCode2021_05_09;

import java.util.PriorityQueue;

/**
 * 要明确一点，后面的丑数都是由前面的丑数乘以质因子所得出的
 * 所以如果任何可以得出的丑数都可以被质因子相乘表示出来
 *
 * val代表着当前丑数值，i代表的是当前丑数是哪个质因子乘出的，idx代表的是该质因子进行第几次计算了
 * 这里解释下i和idx，因为任何丑数肯定可以被质因子相乘丑数表示出来，所以i代表了当前这个数是通过哪个质因子相乘得出的
 * idx表示质因子是第几次使用，是为了通过idx选择出可以选的（还未被该质因子进行过相乘）丑数，来进行计算得出新的丑数
 * idx永远对应的是还使用过的最小丑数
 *
 * 为什么在选出当前堆中最小丑数时计算新的丑数，其实这并不意味着这算出就是堆中最小的，只是相当于选取该质因子计算丑数的队列计算到下一个元素了
 * 实际上质因子所在的队列，应该是一直只保存一个元素的，每取出一个加入到答案数组中就应该计算下一个新的
 */

public class k313 {

    public static void main(String[] args) {
        int[] t = {2,7,13,19};
        System.out.println(new k313().nthSuperUglyNumber(12,t));
    }

    public int nthSuperUglyNumber(int n, int[] primes) {
        int m = primes.length;
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->a[0]-b[0]);
        for (int i = 0; i < m; i++) {
            q.add(new int[]{primes[i], i, 0});
        }
        int[] ans = new int[n];
        ans[0] = 1;
        for (int j = 1; j < n; ) {
            int[] poll = q.poll();
            int val = poll[0], i = poll[1], idx = poll[2];
            if (val != ans[j - 1]) ans[j++] = val;
            q.add(new int[]{ans[idx + 1] * primes[i], i, idx + 1});
        }
        return ans[n - 1];
    }
}
