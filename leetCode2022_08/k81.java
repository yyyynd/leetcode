package leetcode.leetCode2022_08;

/**
 * 这个和那个非重复条件的类似题的重点就是，整个数组如果产生旋转了
 * 那么一定是有一半数组的完全有序的，而另一半一定是无序的，那么就
 * 可以利用这个特性直接判断target是否在这个有序的组里，如果不在
 * 那么这个半区可以直接不考虑，那么继续在另一半区里找，而且注意
 * 不论怎么细分，一个区域里永远有一个半区就是有序的
 */
public class k81 {
    public static void main(String[] args) {
        System.out.println(new k81().search(new int[]{1,0,1,1,1}, 0));
    }
    public boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            }
            //处理类似[1,1,1,1,1,1,1,1,0,1,1]这种情况出现mid == left 时
            if(nums[mid]==nums[left]){
                left++;
                continue;
            }
            //前半部分有序,注意此处用小于等于
            if (nums[left] <= nums[mid]) {
                //target在前半部分
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target <= nums[right] && target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }
}
