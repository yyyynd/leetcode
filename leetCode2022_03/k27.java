package leetcode.leetCode2022_03;

public class k27 {
    public int removeElement(int[] nums, int val) {
        int travel = 0;
        int save = 0;
        while ( travel < nums.length ){
            if (nums[travel] != val){
                nums[save] = nums[travel];
                save++;
            }
            travel++;
        }

        return save + 1;
    }
}
