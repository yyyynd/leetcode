package leetCode2021_05_09;

public class k300 {

    public int lengthOfLIS(int[] nums) {
        /**
         * 这题这个单纯没有优化的dp的方法，很容易想到每次计算前i个元素计算最大组合
         * 但这就有个问题，因为你并不知道dp[i-1]它到底是以哪个元素为结尾的，新加入的
         * 点能否加入这个集合也不得而知，而且如果结果其实是从中间某个点开始的，这个算法
         * 也是无法处理的
         *
         * 而这里的dp[i]是指必须包含第i个点组成最大长度了，所以需要使用res暂存结果
         */

//        int length = nums.length;
//        //这里dp[i]并不能算是前i个元素组成的最长组合长度，而应该采纳第i个点时能形成的最长组合的长度
//        int[] dp = new int[length];
//        int res = 0;
//        //这样填充是默认每个元素自身就构成长度为1的递增
//        Arrays.fill(dp,1);
//        for(int i = 0; i < length; i++){
//            for (int j = 0; j < i; j++){
//                //每次比较是否可以接上j点
//                //这也意味着，如果dp[i]中的存储的长度一定是包含着i点的（要么接续，要么自身为子串
//                //所以dp[length]并不能作为结果，只是其计算的如果包含最后一个点形成的最长子串
//                if(nums[i] > nums[j])
//                    dp[i] = Math.max(dp[j]+1,dp[i]);
//            }//for
//            res = Math.max(dp[i],res);
//        }//for
//
//        return res;

        /**
         * 这题是dp+二分查找，但为何的数组不再是前i个元素组成最大的长度了
         * 维护的数组存储的可以看作当前可能结果的数组（也不完全是），这里二分查找找的是当前元素的插入位置
         * 因为用的是二分查重找插入位置，这个插入位置一定是在小于该元素的后一个点位，
         * 且如果现在新加入考虑的元素，如果这个点不符合前面的升序组合，一定是插在前面
         * 所以这些暂存点的作用，可以看作是给后续点留存的各种组合的最后结尾点
         *
         * 也就是说如果你新考虑的点加入的一定是组合的最后点后面
         * 这里res增加也是在插入位置为res+1（j为res，因为循环结束是i>j
         */
        int[] tails = new int[nums.length];
        int res = 0;
        for(int num : nums) {
            int i = 0, j = res;
            while(i < j) {
                int m = (i + j) / 2;
                if(tails[m] < num) i = m + 1;
                else j = m;
            }
            tails[i] = num;
            if(res == j) res++;
        }
        return res;
    }
}
