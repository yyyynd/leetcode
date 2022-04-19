package leetcode.leetCode2022_04;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 用哈希表记录已经存在范围的两端，需要考虑的是如果新加入的数字
 * 两侧同时存在两个连续子序列
 */
public class k128 {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0)
            return 0;

        HashMap<Integer, Integer> memo = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        int ans = 1;
        for (int n : nums){
            //如果之前考虑这个数了，不再重复考虑
            if (set.contains(n))
                continue;
            set.add(n);
            memo.put(n,n);
            int left = n;
            int right = n;
            if (set.contains(n - 1)){
                left = memo.get(n - 1);
                memo.put(right, left);
                memo.put(left, right);
            }

            if (set.contains(n + 1)){
                right = memo.get(n + 1);
                memo.put(left,right);
                memo.put(right, left);
            }
            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}
