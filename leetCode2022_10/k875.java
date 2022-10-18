package leetcode.leetCode2022_10;

import java.util.Arrays;

public class k875 {
    public static void main(String[] args) {
        System.out.println(new k875().minEatingSpeed(new int[]{30,11,23,4,20},
        6));
    }
    public int minEatingSpeed(int[] piles, int h) {
        if (piles.length == 1)
            return (int) Math.ceil(1.0*piles[0] / h);

        h -= piles.length;
        int limit;
        int l = 0;
        int r = 0;
        if (h >= piles.length || h == 0) {
            limit = 0;
            h += piles.length;
            for (int n : piles)
                r = Math.max(r, n);
        } else {
            Arrays.sort(piles);
            limit = piles.length - h;
            l = piles[limit - 1];
            r = piles[piles.length - 1];
            h *= 2;
        }

        while (l < r) {
            int mid = l + r >> 1;
            if (check(piles, mid, h, limit))
                r = mid;
            else l = mid + 1;
        }
        return r;
    }
    boolean check(int[] p, int k, int h, int l) {
        int ans = 0;
        for (int i = l; i < p.length; i++)
            ans += Math.ceil(p[i] * 1.0 / k);
        return ans <= h;
    }
}
