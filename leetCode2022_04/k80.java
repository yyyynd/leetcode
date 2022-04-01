package leetcode.leetCode2022_04;

public class k80 {
    public int removeDuplicates(int[] nums) {
        int insert = 0;
        int travel = 0;
        int pre = -100001;
        int count = 1;
        while (travel < nums.length) {
            if (nums[travel] == pre)
                count++;
            else
                count = 1;

            if (count <= 2){
                nums[insert] = nums[travel];
                insert++;
            }
            pre = nums[travel];
            travel++;
        }
        return insert;
    }
}
