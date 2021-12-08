package leetCode2021_05_09;

public class k45 {
    public int jump(int[] nums) {
//        int[] dp = new int[nums.length];
//        Arrays.fill(dp, Integer.MAX_VALUE);
//        dp[0] = 0;
//        for(int i = 0; i < nums.length-1; i++){
//            //该位置可跳步数为0或者该无法跳到该位置则直接跳过该点
//            if(nums[i] == 0 || dp[i] == Integer.MAX_VALUE)
//                continue;
//            for(int j = 1; j <= nums[i]; j++){
//                if(i+j >= nums.length-1) {
//                    dp[nums.length - 1] = Math.min(dp[nums.length - 1], dp[i] + 1);
//                    break;
//                }else {
//                    dp[i+j] = Math.min(dp[i+j],dp[i]+1);
//                }
//            }//for
//        }//for
//
//        return dp[nums.length-1];
        /**
         * 上面是穷举的dp，下面是贪心
         *
         * 为什么这样可以，这里每一次选择最远跳的意义
         * 这个最远位置其实也只是一个我们当前可以选择的起跳点的边界
         * 而设置边界位置的标识其实也是为了表示这个区间
         * 这个区间是在这次计算中所有可以选择的起跳点（也就是上一个位置可以到达的地方）
         *
         * 在这个区间里选择在挑选一个能跳到的最远位置作为下一个区间的右边界
         * 为什么这样做，因为这样是可以包含所有起跳点的，
         *
         * 直觉上我们可能会觉得可能在这些点里选一个不是跳到最远的点，
         * 可能就是作为最优解的组成了，但实际上我们只关心跳到终点就行
         *
         * 实际上每次在区间中找右边界的时候，就是在做尝试“我不跳最大步数到某一点，是否能能得出最优解”
         * 因为这个区间就包含了在该点起跳的可能性，而在区间中的作为下一跳的点，它们所能到达的位置
         * 也只会在它们中某个点所到达的最远位置作为右边界的区间中，
         */
        int count = 0;
        int maxPoint = 0;
        int borderPoint = 0;
        for(int i = 0; i < nums.length-1; i++){
            //这一步相当于在考虑，当前位置可以达到的点中，谁作为下一条起跳点
            maxPoint = Math.max(maxPoint,i+nums[i]);
            if(i == borderPoint){
                borderPoint = maxPoint;
                count++;
            }
        }
        return count;
    }
}
