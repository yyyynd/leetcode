package leetcode.leetCode2022_04;

public class k26 {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0)
            return 0;

        int left = 0;
        int right = 0;
        int pre = nums[left];
        while (right < nums.length){
            if (nums[right] == pre)
                right++;
            else {
                nums[left] = pre;
                left++;
                pre = nums[right];
            }
        }
        nums[left++] = pre;
        return left;
    }
}
