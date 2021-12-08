package leetCode2021_05_09;

public class k1894 {
    public static void main(String[] args) {
        System.out.println(new k1894().chalkReplacer(new int[]{22,25,39,3,45,45,12,17,32,9},
        835));
        System.out.println();
    }
    public int chalkReplacer(int[] chalk, int k) {
        int studentNum = chalk.length;
        long[] dp = new long[studentNum+1];
        for(int i = 0; i < studentNum; i++) {
            dp[i+1] = dp[i] + chalk[i];
            if(dp[i+1] > k)
                return i;
        }

        k = (int)(k % dp[studentNum]);
        //二分查找找不能完整走完一轮中粉笔不够的学生
        int l = 1, r = studentNum;
        while (l < r){
            int mid = l + (r - l)/2;
            if(dp[mid] >= k)
                r = mid;
            else
                l = mid+1;
        }
        //有可能二分找出一个正好耗尽的
        return dp[l] == k ? l : l-1;
    }
}
