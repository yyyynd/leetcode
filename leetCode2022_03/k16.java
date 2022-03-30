package leetcode.leetCode2022_03;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 基本不可避免的需要枚举了，当不是要求连续或者有序的情况下基本必须枚举
 * 这里的思路就是每次固定一个点，然后固定搜索范围为其右侧（因为之前的遍历
 * 肯定枚举过左侧的点和当前点的组合了），并且使用双指针，左右两侧移动
 * 大了就减小，小了就增大
 *
 * 而且一旦设计的枚举的情况，就应该考虑剪枝的情况
 */
public class k16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        HashSet<Integer> memo = new HashSet<>();
        int res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i <= nums.length - 3; i++){
            int left = i + 1;
            int right = nums.length - 1;
            if (memo.contains(nums[i]))
                continue;
            memo.add(nums[i]);
            while ( left < right ){
                int sum = nums[i] + nums[left] + nums[right];
                res = Math.abs(target - res) < Math.abs(target - sum) ? res : sum;
                if( sum == target )
                    return sum;

                if ( sum > target )
                    right--;
                else
                    left++;
            }//while
        }//for

        return res;
    }
}
