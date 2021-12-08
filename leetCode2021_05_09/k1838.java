package leetCode2021_05_09;

import java.util.*;

public class k1838 {

    public static void main(String[] args) {
        int[] t = {1,4,8,13};
        System.out.println(new k1838().maxFrequency(t,5));
    }

    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int[] sums = new int[nums.length+1];

        for (int i = 1; i <= nums.length; i++)
            sums[i] = sums[i-1]+nums[i-1];

        int preNum = 0;
        int max = 0;

        for(int i = nums.length-1; i >= 0;i--){
            int curNum = nums[i];
            //和上次为基准的元素重复的元素肯定不需要第二次判断了
            if(curNum == preNum)
                continue;
            int r = i+1;
            int l = i;
            int len = 1;

            while (l >= 0){
                int sum = sums[r] - sums[l];
                if(sum+k >= len*curNum){
                    len++;
                    l--;
                }else
                    break;
            }//while
            //退出循环前len是多增加一次的
            max = Math.max(max,--len);
            preNum = curNum;
        }

        return max;
    }
}
