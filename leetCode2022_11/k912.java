package leetcode.leetCode2022_11;

public class k912 {
    public static void main(String[] args) {
        System.out.println(new k912().sortArray(new int[]{5,2,3,1}));
    }
    public int[] sortArray(int[] nums) {
        quickSort(0, nums.length - 1, nums);
        return nums;
    }

    public void quickSort(int left, int right, int[] nums){
        if (left >= right)
            return;

        int mid = nums[right];
        int l = left;
        int r = right;
        while (l < r){
            while (l < r && nums[l] <= mid)
                l += 1;
            nums[r] = nums[l];
            while (l < r && nums[r] >= mid)
                r -= 1;
            nums[l] = nums[r];
        }

        nums[l] = mid;
        quickSort(left, l - 1, nums);
        quickSort(l + 1, right, nums);
    }
}
