package leetcode.leetCode2022_09;

public class k283 {
    public void moveZeroes(int[] nums) {
        int insert = 0;
        for (int travel = 0; travel < nums.length; travel++)
            if (nums[travel] != 0)
                nums[insert++] = nums[travel];

        for (; insert < nums.length; insert++)
            nums[insert] = 0;

    }
}
