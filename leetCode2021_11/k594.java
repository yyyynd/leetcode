package leetCode2021_11;

import java.util.*;

public class k594 {
    public static void main(String[] args) {
        System.out.println(new k594().findLHS(new int[]{1,3,2,2,5,2,3,7}));
    }
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int preNum = 0;
        int preCount = 0;
        int curNum = 0;
        int curCount = 0;
        int ans = 0;

        int i = 0;
        preNum = nums[0];
        for (; i < nums.length; i++) {
            if(nums[i] != preNum)
                break;
            preCount++;
        }

        if( i == nums.length)
            return ans;

        curNum = nums[i];
        for (; i < nums.length; i++) {
            if(nums[i] != curNum)
                break;
            curCount++;
        }

        for (; i < nums.length; i++){
            if(nums[i-1] != nums[i]){
                if(preNum + 1 == curNum)
                    ans = Math.max(ans, preCount + curCount);
                preNum = curNum;
                preCount = curCount;
                curNum = nums[i];
                curCount = 0;
            }
            curCount++;
        }

        if(preNum + 1 == curNum)
            ans = Math.max(ans, preCount + curCount);
        return ans;
    }
}
