package leetcode.leetCode2022_02;

public class k540 {
    int limit;

    public static void main(String[] args) {
        System.out.println(new k540().singleNonDuplicate(new int[]{3,3,7,7,10,11,11}));
    }
    public int singleNonDuplicate(int[] nums) {
        this.limit = nums.length - 1;
        return find(0, limit, nums);
    }

    public int find(int left, int right,int[] nums){
        if(left == right)
            return nums[left];

        int mid = left +  (right - left) / 2;
        //注意范围问题

        if( mid == 0 || nums[mid - 1] == nums[mid]) {
            if(mid - 1 != 0 && (mid - left) % 2 == 0)
                return find(0, mid - 2, nums);
            else
                return find( mid + 1, right, nums);
        }
        else{
            if( mid + 1 != limit && ( right - mid) % 2 == 0)
                return find(mid + 2, right, nums);
            else
                return find(left, mid - 1, nums);
        }
    }
}
