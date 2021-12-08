package leetCode2021_05_09;

public class k704 {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        while (l < r){
            int mid = l + (r - l)/2;
            if(nums[mid] >= target)
                r = mid;
            else
                l = mid+1;
        }

        return nums[l] == target ? l : -1;
    }
}
