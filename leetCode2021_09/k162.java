package leetCode2021_09;
/**
 * 这道题的重点就是有一个条件，nums[i] != nums[i + 1]严格保证相邻数字不相同
 * 这会推出一个重要的推论就是
 * 如果 nums[0] > nums[1]nums[0]>nums[1]，那么最左边元素 nums[0]nums[0] 就是峰值（结合左边界为负无穷）；
 * 如果 nums[0] < nums[1]nums[0]<nums[1]，由于已经存在明确的 nums[0]nums[0] 和 nums[1]nums[1] 大小关系，我们将 nums[0]nums[0]
 * 看做边界， nums[1]nums[1] 看做新的最左侧元素，继续往右进行分析：
 * 如果在到达数组最右侧前，出现 nums[i] > nums[i + 1]nums[i]>nums[i+1]，说明存在峰值位置 ii（当我们考虑到 nums[i]nums[i]，
 * 必然满足 nums[i]nums[i] 大于前一元素的前提条件，当然前一元素可能是原始左边界）；
 * 到达数组最右侧，还没出现 nums[i] > nums[i + 1]nums[i]>nums[i+1]，说明数组严格递增。此时结合右边界可以看做负无穷，
 * 可判定 nums[n - 1]nums[n−1] 为峰值。

 */
public class k162 {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] > nums[mid + 1]) r = mid;
            else l = mid + 1;
        }
        return r;
    }
}
