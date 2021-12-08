package leetCode2021_10;

import java.util.Arrays;

public class k414 {
    public int thirdMax(int[] nums) {
//        int firstMax = Integer.MIN_VALUE;
//        int secondMax = Integer.MIN_VALUE;
//        int thirdMax = Integer.MIN_VALUE;
        Arrays.sort(nums);
        int count = 0;
        int preNum = 0;
        for(int i = nums.length - 1; i >= 0; i--){
            if(nums[i] != preNum){
                count++;
                preNum = nums[i];
            }

            if(count == 3)
                return nums[i];
        }

        return nums[nums.length-1];
    }
}
