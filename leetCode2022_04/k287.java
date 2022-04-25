package leetcode.leetCode2022_04;

/**
 * 还有种就是利用抽屉原理的二分查找法，因为数字有只出现一次的效果
 * 如果我们取数组中间位置的点，因为存在重复，那么一定有一边比其大的数字
 */
public class k287 {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        slow = nums[slow];
        fast = nums[nums[fast]];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        int pre1 = 0;
        int pre2 = slow;
        while(pre1 != pre2){
            pre1 = nums[pre1];
            pre2 = nums[pre2];
        }
        return pre1;
    }
}
