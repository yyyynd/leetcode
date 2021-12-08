package leetCode2021_05_09;


public class k673 {
    int[][] dp;

    public static void main(String[] args) {
        int[][] dp = new int[2][];
        System.out.println(new k673().findNumberOfLIS(new int[]{2,1}));
    }
    public int findNumberOfLIS(int[] nums) {
        dp = new int[nums.length][];
        int[][] dp = new int[nums.length][2];
        //利用双循环和dp
        for (int i = 1; i < nums.length; i++){
            for (int j = 0; j < i; j++){
                if(nums[i] > nums[j]) {
                    int newLen = dp[j][0] + 1;
                    if(newLen > dp[i][0]){
                        dp[i][0] = newLen;
                        dp[i][1] = dp[j][1];
                    }else if(newLen == dp[i][0]){
                        dp[i][1] += dp[j][1];
                    }
                }
            }//for
        }//for

        int ans = 0;
        return  ans;


//        for(int i = 0; i < nums.length; i++){
//            int[] tmp = dfs(nums,i);
//            if(tmp[0] > ans[0])
//                ans = tmp;
//            else if(tmp[0] == ans[0])
//                ans[1] += tmp[1];
//        }
    }

    public int[] dfs(int[] nums,int preIndex){
        if(dp[preIndex] != null)
            return dp[preIndex];

        //这个res代表的是上一个已选点
        int[] res = new int[2];
        res[0] = 1;
        res[1] = 1;

        for (int i = preIndex+1; i < nums.length; i++){
            if(nums[i] > nums[preIndex]){
                int[] tmp = dfs(nums,i);
                if(tmp[0] + 1 > res[0]){
                    res[0] = tmp[0] + 1;
                    res[1] = tmp[1];
                }else if(tmp[0]+1 == res[0])
                    res[1] += tmp[1];
            }
        }//for

        dp[preIndex] = res;
        return res;
    }
}
