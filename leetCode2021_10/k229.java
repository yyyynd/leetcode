package leetCode2021_10;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 注意题目的条件,要求出出现次数 > nums.length/3 这就意味结果最多包含两个数
 */
public class k229 {

    public List<Integer> majorityElement(int[] nums) {
        boolean flag = true;//如果已经加入了答案队列重复元素就不再重复计算了
        int count = 0;
        int preNum = nums[0];
        int target = nums.length / 3;
        Arrays.sort(nums);
        List<Integer> ans = new LinkedList<>();
        for (int n : nums){
            if(n == preNum)
                count++;
            else {
                //出现和之前的不同元素了，重置添加答案状态为true
                flag = true;
                preNum = n;
                count = 1;
            }

            if(flag && count > target) {
                ans.add(n);
                flag = false;
            }
        }

        return ans;
    }
}
