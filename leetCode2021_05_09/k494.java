package leetCode2021_05_09;

public class k494 {
    int count = 0;
    int row = 0;
    public int findTargetSumWays(int[] nums, int target) {
         row = nums.length;
         int s = 0;
         for (int i :nums)
             s += Math.abs(i);
        int[][] f = new int[row + 1][2 * s + 1];
        /**
         * 这里的f[0][s]其实就逻辑上的0个数达到值为0的个数
         * 因为这是目标值范围[-s.s]所以偏移s位相当于目标值为0
         * 第一轮只可能是通过第一个数本身达到目标值
         *
         * 也可以理解为0个数到达0就是有一种方式
         */
        f[0][s] = 1;
        for (int i = 1; i <= row; i++) {
            int x = nums[i-1];
            for (int j = -s; j <= s; j++) {
                //这里要判断加减达到目标值是否还在范围之内
                //j-x是希望通过+x到达j值
                if ((j - x) + s >= 0)
                    f[i][j+s] += f[i-1][(j-x) + s];
                //j+x是希望通过-x值达到j值
                if ((j + x) + s <= 2 * s)
                    f[i][j+s] += f[i-1][(j+x) + s];
            }
        }


         return count;
    }

//    private void fun(int sum,int index,int target,int[] nums){
//        if(index == row) {
//            if(sum == target)
//                count++;
//            return;
//        }
//
//        fun(sum+nums[index],index+1,target,nums);
//        fun(sum-nums[index],index+1,target,nums);
//    }
}
