package leetCode2021_05_09;

public class k1035 {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[][] linesDp = new int[m+1][n+1];
        for(int i = 1;i <= m;i++){
            int num1 = nums1[i-1];
            for (int j = 1; j <= n; j++){
                int num2 = nums2[j-1];
                if(num1 == num2)
                    linesDp[i][j] = linesDp[i-1][j-1] + 1;
                else
                    linesDp[i][j] = Math.max(linesDp[i - 1][j], linesDp[i][j - 1]);
            }
        }
        return linesDp[m][n];
    }
}
