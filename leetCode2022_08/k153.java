package leetcode.leetCode2022_08;

public class k153 {
    public static void main(String[] args) {
        System.out.println(new k153().findMin(new int[]{3,4,5,6,1,2}));
    }
    public int findMin(int[] nums) {
        //长度为1或者未发生旋转的情况下
        if (nums.length == 1 || nums[nums.length - 1] > nums[0])
            return nums[0];

        int left = 0;
        int right = nums.length - 1;

        while (left < right - 1){
            int mid = left + (right - left) /2;
            if (nums[mid] < nums[left])
                right = mid;
            else if (nums[mid] > nums[left])
                left = mid;
        }

        return nums[right];
    }
}
