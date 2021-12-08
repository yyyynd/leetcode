package leetCode2021_09;

public class k639 {
    public static void main(String[] args) {
        System.out.println(new k639().numDecodings("7*9*3*6*3*0*5*4*9*7*3*7*1*8*3*2*0*0*6*"));
    }
    public int numDecodings(String s) {
        final int mod =  (int)(1e9 + 7);
        char[] str = s.toCharArray();
        long[]dp = new long[str.length + 1];
        if(str[0] == '0')
            return 0;
        dp[0] = 1;
        dp[1] = str[0] == '*' ? 9 : 1 ;
        //先该位单独考虑，再考虑和前一位字符组合组成新串
        for (int i = 2; i < str.length + 1; i++){
            if(str[i-1] >= '1' && str[i-1] <= '6'){
                dp[i] = dp[i-1];
                if(str[i-2] == '*')
                    dp[i] = dp[i] + dp[i-2] * 2;
                else if(str[i-2] == '1' || str[i-2] == '2')
                    dp[i] = dp[i] + dp[i-2];
            }else if(str[i-1] == '*'){
                dp[i] = dp[i-1] * 9 ;
                if(str[i-2] == '*')
                    dp[i] = dp[i] + dp[i-2] * 15;
                else if(str[i-2] == '1')
                    dp[i] = dp[i] + dp[i-2] * 9;
                else if(str[i-2] == '2')
                    dp[i] = dp[i] + dp[i-2] * 6;
            }else if(str[i-1] >= '7' && str[i-1] <= '9'){
                dp[i] = dp[i-1];
                if(str[i-2] == '*' || str[i-2] == '1')
                    dp[i] = dp[i] + dp[i-2];
            }else {
                if(str[i-2] == '*')
                    dp[i] = dp[i-2] * 2 ;
                else if(str[i-2] == '1' || str[i-2] == '2')
                    dp[i] = dp[i-2];
            }
            dp[i]  %= mod;
        }

        return (int)dp[str.length];
    }
}
