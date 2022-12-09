package leetcode.leetCode2022_12;

/**
 * 本质利用贪心算法，让总和大的数组中最大的元素减少，让总和
 * 小的数组中的最小的元素增加，这样能保证最快速的接近两边相等
 *
 * 因为每次都是贪心地希望每个元素都对差值产生最大的抵消效果
 * 所以其实只要差值小于0也能代表我们当前完成了差值抵消了，因为
 * 实际上不可能全部元素都是调整到最大影响情况
 */

public class k1775 {
    public int minOperations(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int ans = 0;
        //假设两边一个增到最大，一个减到最小，如果增的那个还是比减的小证明不可能
        if (len1 * 6 < len2 || len2 * 6 < len1)
            return -1;
        int sum1 = 0, sum2 = 0;
        for (int n : nums1)
            sum1 += n;
        for (int n : nums2)
            sum2 += n;

        int diff = sum1 - sum2;
        //这种写法虽然会重复计算一次，但可以简化代码
        if (diff < 0)
            return minOperations(nums2, nums1); //把累计值大的作为nums1
        //统计的其实就是对差值影响的元素的个数，比如能产生减少5差值的元素个数就是存放在map[5]
        int[] map = new int[6];
        //对于总和大的数组，每个元素进行减少，减1得出其对于差值的影响，以6为例，减到1
        //就是-5
        for (int n : nums1)
            map[n - 1] += 1;
        //对于总和小的数组，以1为例，肯定增得大好，直接增到6，所以其对于差值的影响
        //就是-5，
        for (int n : nums2)
            map[6 - n] += 1;

        //让总和大的数组中最大的先往下减和总和小的数组中最小的值往上增
        //这里为什么判断的是diff > 0，是因为如果map[i]提供的数量大于我们抵消差值需要的i的数量
        //其实部分元素就不需要调整到目标值，即产生i的差值抵消了，但我们依然是全部按照抵消i来计算
        //这就势必会产生导致差值被减到小于0
        for (int i = 5; i >= 1 && diff > 0; i--) {
            //最少需要的个数 +(i- 1)为了向上取整
            int cnt = Math.min(map[i], (diff + i - 1) / i);
            ans += cnt;
            diff -= cnt * i; //减去能够减少的最大值，若小于等等于0，代表已经使得两个数组相等
        }
        return ans;
    }
}
