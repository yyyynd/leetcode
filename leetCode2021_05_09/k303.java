package leetCode2021_05_09;

public class k303 {

    public static void main(String[] args) {
        k303 a = new k303(new int[]{1, 1, 1, 1, 1, 1});
    }

    int[] dp;
    int length;
    public k303(int[] nums) {

        this.length = nums.length;
        this.dp = new int[(int)((double)nums.length*(nums.length+1)/2)];

        for(int i = 0; i < nums.length; i++){
//            int k = ((2*nums.length-i+1)*i)/2+i-i;
            int k = computeK(i,i);
            dp[k] = nums[i];
        }

        for(int i = nums.length-2; i >= 0; i--){
            for (int j = i+1 ;j < nums.length; j++){
//                int k = ((2*nums.length-i+1)*i)/2+j-i;
//                int p_k = ((2*nums.length-(i+1)+1)*(i+1))/2+j-(i+1);
                int k = computeK(i,j);
                int p_k = computeK(i+1,j);
                dp[k] = dp[p_k]+nums[i];
            }
        }
    }

    public int sumRange(int left, int right) {
        return dp[computeK(left,right)];
    }

    public int computeK(int i,int j){
        return ((2*this.length-i+1)*i)/2+j-i;
    }
}
