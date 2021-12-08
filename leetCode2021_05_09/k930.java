package leetCode2021_05_09;

import java.util.HashMap;
import java.util.Map;

/**
 * 这种求连续子数组，且只要其中的元素总和值的题
 * 就应该使用前缀和，通过前缀和的相减得出子集
 *
 * 前缀和本身就是带有连续性质的
 *
 * 因为是通过两个前缀和相减得出子范围了，所以逻辑上相当于找一对配对的前缀和
 */
public class k930 {

    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++)
            sum[i] = sum[i - 1] + nums[i - 1];
        //键就是前缀和，值是能组成该前缀和值的数量
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int r = sum[i + 1], l = r - goal;
            ans += map.getOrDefault(l, 0);
            //这里的效果相当于遍历前缀和数组，依次从小到大放入map，所以肯定不会产生重复计算
            map.put(r, map.getOrDefault(r, 0) + 1);
        }
        return ans;
    }

}
