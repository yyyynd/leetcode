package leetcode.leetCode2022_02;

import java.util.HashMap;
import java.util.Map;

/**
 * 滑块+二分的思路就是维持一个k大小的树，然后每次查找最接近目标值的元素
 * 因为这里虽然我们是一个固定范围内寻值，但是因为本身的数据是无序的，因此需要进行排序，选择红黑树是每次插入
 * 更加稳定（不像AVL树要旋转平衡次数比较多），也能满足较为快速地查找需要
 *
 * 桶排序的思路就是，因为我们需要找[ n - t, n + t ]范围值的数，假设我们把所有的数通过除以k得到一个数
 * 当作其桶下标，这样我们找[ n - t, n + t ]只需要查看当前数的桶or邻近桶即可判断是否复合条件了
 *
 * 如用排序的思路，问题就是排序会丢失下标，因此也有种解法是开额外数组同时记录原下标和值然后遍历即可
 */
public class k220 {
    long size;
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;

        Map<Long, Long> map = new HashMap<>();
        size = t + 1L;
        for (int i = 0; i < n; i++) {
            long u = nums[i];
            long idx = getIdx(u);
            // 目标桶已存在（桶不为空），说明前面已有 [u - t, u + t] 范围的数字
            if (map.containsKey(idx))
                return true;
            // 检查相邻的桶
            long l = idx - 1, r = idx + 1;
            if (map.containsKey(l) && u - map.get(l) <= t)
                return true;
            if (map.containsKey(r) && map.get(r) - u <= t)
                return true;
            // 建立目标桶
            map.put(idx, u);
            // 移除下标范围不在 [max(0, i - k), i) 内的桶
            if (i >= k)
                map.remove(getIdx(nums[i - k]));
        }

        return false;
    }

    long getIdx(long u) {
        return u >= 0 ? u / size : ((u + 1) / size) - 1;
    }


}
