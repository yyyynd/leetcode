package leetcode.leetCode2022_01;

import java.util.*;

/**
 * 之前做错的方法其实没有做到每次取出的都是最小对，安顺序选并不能一定选出答
 */
public class k373 {
    public static void main(String[] args) {
        System.out.println(new k373().kSmallestPairs(new int[]{1,2},new int[]{3},3));
    }
    boolean flag = true;
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int n = nums1.length, m = nums2.length;
        if (n > m && !(flag = false))
            return kSmallestPairs(nums2, nums1, k);
        List<List<Integer>> ans = new ArrayList<>();

        PriorityQueue<int[]> q = new PriorityQueue<>((a, b)->(nums1[a[0]]+nums2[a[1]])-(nums1[b[0]]+nums2[b[1]]));
        for (int i = 0; i < Math.min(n, k); i++)
            q.add(new int[]{i, 0});

        while (ans.size() < k && !q.isEmpty()) {
            int[] poll = q.poll();
            int a = poll[0], b = poll[1];
            ans.add(new ArrayList<>(){{
                add(flag ? nums1[a] : nums2[b]);
                add(flag ? nums2[b] : nums1[a]);
            }});
            if (b + 1 < m)
                q.add(new int[]{a, b + 1});
        }
        return ans;
    }
}
