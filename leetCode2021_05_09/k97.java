package leetCode2021_05_09;

public class k97 {
    public boolean isInterleave(String s1, String s2, String s3) {

        int length_s1 = s1.length();
        int length_s2 = s2.length();
        boolean[][] dp = new boolean[length_s1+1][length_s2+1];

        if(s3.length() != length_s1+length_s2)
            return false;

        dp[0][0] = true;
        //这里处理只一直取某一个字符串的情况
        for (int i = 1; i <= length_s1 && s1.charAt(i-1) == s3.charAt(i-1); i++)
            dp[i][0] = true;
        for (int j = 1; j <= length_s2 && s2.charAt(j-1) == s3.charAt(j-1); j++)
            dp[0][j] = true;

        /**
         * 这里和k63很像，一样判断走到(i,j)位置时可以从左和上位置走到该位置
         */
        for(int i = 1; i< length_s1+1; i++){
            for (int j = 1; j < length_s2+1; j++){
                dp[i][j] = (dp[i-1][j] && s3.charAt(i+j-1) == s1.charAt(i-1))
                        || (dp[i][j-1] && s3.charAt(i+j-1) == s2.charAt(j-1));
            }
        }
        return dp[length_s1][length_s2];
    }
}
