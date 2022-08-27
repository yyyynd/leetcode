package leetcode.leetCode2022_08;

public class k189 {
    public static void main(String[] args) {
        new k189().rotate(new int[]{-1,-100,3,99}, 2);
    }
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k % len;
        int cur;
        int index;
        int i = 0;
        int start = 0;
        while (i < len){
            index = (start + k) % len;
            cur = nums[start];
            while (i++ < len){
                int tmp = nums[index];
                nums[index] = cur;
                cur = tmp;
                if (index == start)
                    break;
                index = (index + k) % len;
            }
            start++;
        }
    }
}
