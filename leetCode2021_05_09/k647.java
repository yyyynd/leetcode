package leetCode2021_05_09;

public class k647 {
    public static void main(String[] args) {
        System.out.println(new k647().countSubstrings("aaa"));
    }
    public int countSubstrings(String s) {
        int str_length = s.length();
        char[] s_ar = s.toCharArray();
        int ans = 0;
        boolean[][] dp = new boolean[str_length][str_length];
        for (int i = str_length-1; i >= 0; i--){
            for (int j = i; j < str_length; j++){
                if(s_ar[i] == s_ar[j]) {
                    if (j - i <= 1) {
                        dp[i][j] = true;
                        ans++;
                    }
                    else if ( dp[i+1][j-1] ) {
                        dp[i][j] = true;
                        ans++;
                    }
                }//if
            }//for
        }//for

        return ans;
    }
}
