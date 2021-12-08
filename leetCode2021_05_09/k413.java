package leetCode2021_05_09;


public class k413 {
    public static void main(String[] args) {
        int[] t = {1,2,3,8,9,10};
        System.out.println(new k413().numberOfArithmeticSlices(t));
    }

    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length < 3)
            return 0;

        int count = 0;
        int curLen = 2;
        int curD_value = nums[1] - nums[0];


        for(int i = 2; i <= nums.length-1; i++){
            if(curD_value == nums[i] - nums[i-1]){
                curLen++;
            }else {
                if(curLen >= 3)
                    count += (1+curLen-2)*(curLen-2)/2;
                //该元素无法和之前的元素集组成等差，因此判断
                //它和之前组成等差的最后一个数组重新判断是否能组成新等差的前2元素
                //也就是说每次都会以两个元素为起点开始计算
                curLen = 2;
                curD_value = nums[i] - nums[i-1];
            }
        }

        if(curLen >= 3)
            count += (1+curLen-2)*(curLen-2)/2;

        return count;


//        int[][] dp = new int[nums.length][nums.length];
//        int count = 0;
//        dp[nums.length - 1][nums.length - 1] = 1;
//        //每次相当于取一个新的元素加入各个已经判断过的子串中判断是否能组成新的等差数列
//        for (int i = nums.length - 2; i >= 0; i--) {
//            for (int j = nums.length - 1; j >= i; j--) {
//                //如果子数组只有1or2个元素就只直接计算长度了
//                if (j - i + 1 <= 2) {
//                    dp[i][j] = dp[i + 1][j] + 1;
//                    continue;
//                }
//
//                if (nums[i] - nums[i + 1] == nums[i + 1] - nums[i + 2]) {
//                    dp[i][j] = dp[i + 1][j] + 1;
//                    if(dp[i][j] >= 3)
//                        count++;
//                } else
//                    dp[i][i] = 1;
//
//
//            }
//        }//for
//
//        return count;
    }
}
