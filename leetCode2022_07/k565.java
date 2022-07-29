package leetcode.leetCode2022_07;

import java.util.HashMap;

public class k565 {

    public int arrayNesting(int[] nums) {
        int ans = 0;
//        for (int i = 0; i < nums.length; i++)
//            nums[i] += 1;

        for (int i = 0; i < nums.length; i++){
            if (nums[i] == -1)
                continue;
            int len = 0;
            int next = i;
            while (nums[next] > -1){
                int tmp = nums[next];
                nums[next] = -1;
                next = tmp;
                len++;
            }

            ans = Math.max(ans, len);
        }

        return ans;
    }


}
