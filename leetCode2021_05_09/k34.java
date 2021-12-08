package leetCode2021_05_09;

import java.util.Arrays;

public class k34 {

    public static void main(String[] args) {
        int[] t = {5,7,7,8,8,10};
        System.out.println(Arrays.toString(new k34().searchRange(t, 8)));
    }
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1,-1};

        int l = 0, r = nums.length-1;
        int oneIndex = -1;
        while (l <= r){
            int mid = l + r >> 1;
            if(nums[mid] < target)
                l = mid+1;
            else if(nums[mid] > target)
                r = mid-1;
            else{
                oneIndex = mid;
                break;
            }
        }//while

        if(oneIndex == -1)
            return result;

        result[0] = result[1] = oneIndex;
        l = oneIndex - 1;
        r = oneIndex + 1;
        while (l >= 0 || r <= nums.length-1){
            if(l >= 0 && nums[l] == target) {
                result[0] = l;
                l = l - 1;
            }else
                l = -1;

            if(r <= nums.length-1 && nums[r] == target) {
                result[1] = r;
                r = r + 1;
            }else
                r = nums.length;
        }

        return result;
    }
}
