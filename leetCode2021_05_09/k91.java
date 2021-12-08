package leetCode2021_05_09;

public class k91 {
    public int numDecodings(String s) {
        char[] charArr = s.toCharArray();
        int length = s.length();
        int[] dp = new int[length+1];
        int zeroCount = 0;
       if(charArr[0] != '0')
           dp[1] = 1;
       else
           return 0;


        dp[0] = 1;
        for (int i = 2; i <= length; i++){
            if(charArr[i-1] == '0')
                zeroCount++;
            else {
                //出现一个非0数了，打断计数
                zeroCount = 0;
                dp[i] += dp[i - 1];
            }
            //如果中间已经有两个位置连续出现0了，这个字符串不可解码
            if (zeroCount == 2)
                return 0;

            //这里判断两个数字组成一个字符码
            //区分1x和2x开头的
            if(i-2 >= 0) {
                if(charArr[i-2] == '1')
                    dp[i] += dp[i-2];
                else if(charArr[i-2] == '2' && charArr[i-1] < '7')
                    dp[i] += dp[i-2];
            }
        }

        return dp[length];
    }
}
