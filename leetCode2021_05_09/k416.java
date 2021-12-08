package leetCode2021_05_09;

/**
 * 一开始想只用一维数组来dp，遇到的问题就是 每当我取下一个元素 进行下述计算时
 * for(j = 1; j <= target; j++) dp[j] = dp[j-nums[i]]
 * 这个写法是会产生一个元素被重复采用的bug，举例：在判断容量5的情况，如果当前元素大小为1，dp[1]很明显可以
 * dp[2]在这个循环中也会被判断可以，但dp[2]的可以是拿了两个当前这个1元素，这样不论任何情况其实都能true
 *
 * 而如果改成for(j = target; j >= nums[i]; j--)，这问题就得到解决了
 * 因为现在是从后开始判断了，还是以容量5，元素1为例子，那么这个时候dp[3]是false,那么自然dp[4]不行，单独一个1肯定塞不满
 * 直到dp[1]才会得到true，能填满容量1
 *
 * 这时候再取元素2，也是直到dp[3]才会true。而如果是第一种正序写法，dp[3],dp[5]...dp[1+2n]全会是true，因为根据状态转移方程
 * 就是会产生这种结果，实际上就是因为在本轮循环，反而在考虑已经采纳当前判断的元素的组合情况下，是否能再次采纳当前判断的元素
 */

public class k416 {

    public static void main(String[] args) {
        int[] t = {14,9,8,4,3,2};
        System.out.println(new k416().canPartition(t));
    }

    public boolean canPartition(int[] nums) {
        int len = nums.length;
        // 题目已经说非空数组，可以不做非空判断
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // 特判：如果是奇数，就不符合要求
        if ((sum & 1) == 1) {
            return false;
        }

        int target = sum / 2;
        // 创建二维状态数组，行：物品索引，列：容量（包括 0）

        boolean[] dp = new boolean[target+1];
        dp[0] = true;

        for (int i : nums){
            for (int j = target; j >= i; j--){
                //这一步防止本来true变false....
                dp[j] = dp[j-i] || dp[j];
                if(dp[target])
                    return true;
            }
        }

        return false;
    }
}
