package leetCode2021_10;

public class k453 {
    public static void main(String[] args) {
        System.out.println(new k453().minMoves(new int[]{1,1,1000000000}));
    }
    public int minMoves(int[] nums) {
        int min = nums[0];
        int ans = 0;
        for(int n : nums)
            min = Math.min(min, n);
        for (int n : nums)
            ans += n-min;
        return ans;
    }
}
