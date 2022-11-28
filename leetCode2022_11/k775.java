package leetcode.leetCode2022_11;

import java.util.Arrays;
import java.util.Comparator;

public class k775 {
    public static void main(String[] args) {
        System.out.println(new k775().isIdealPermutation(new int[]{2,0,3,1,4}));
    }
    public boolean isIdealPermutation(int[] nums) {
        if (nums.length == 1)
            return true;

        int len = nums.length;
        int[][] pre_min = new int[][]{{nums[len - 1],len - 1}, {nums[len - 2], len - 2}};
        Arrays.sort(pre_min, Comparator.comparingInt(o -> o[0]));
        for (int i = len - 3; i >= 0; i--){
            if ( nums[i] > pre_min[1][0] )
                return false;
            else {
                pre_min[1][0] = nums[i];
                pre_min[1][1] = i;
            }

            if (nums[i] > pre_min[0][0]) {
                if (i != pre_min[0][1] - 1)
                    return false;
            } else{
                pre_min[1][0] = pre_min[0][0];
                pre_min[1][1] = pre_min[0][1];
                pre_min[0][0] = nums[i];
                pre_min[0][1] = i;
            }
        }
        return true;
    }
}
