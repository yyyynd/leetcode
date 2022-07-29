package leetcode.leetCode2022_07;

public class k845 {
    public static void main(String[] args) {
        System.out.println(new k845().longestMountain(new int[]{9,8,7,6,5,4,3,2,1,0}));
    }
    public int longestMountain(int[] arr) {
        int[] dp = new int[arr.length];
//        int[] dp_r = new int[arr.length];
        int ans = 0;

        for (int i = 1; i < arr.length - 1; i++){
            if (arr[i] > arr[i - 1])
                dp[i] = dp[i - 1] + 1;
        }


        for (int i = arr.length - 2; i >= 1; i--){
            int tmp = dp[i];
            if (arr[i] > arr[i + 1]){
                dp[i] = dp[i + 1] + 1;
                if (tmp != 0)
                    ans = Math.max(ans, tmp + dp[i]);
            }else
                dp[i] = 0;
        }

//        for (int i = arr.length - 2; i >= 0; i--){
//            if (arr[i] > arr[i + 1])
//                dp_r[i] = dp_r[i + 1] + 1;
//        }

//        for (int i = 1; i < arr.length - 1; i++){
//            if (dp_l[i] != 0 && dp_r[i] != 0)
//                ans = Math.max(ans, dp_l[i] + dp_r[i]);
//        }

        return ans == 0 ? 0 : ans + 1;
    }
}
