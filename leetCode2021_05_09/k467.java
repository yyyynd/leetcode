package leetCode2021_05_09;

import java.util.Arrays;

public class k467 {
    public static void main(String[] args) {

    }
    public int findSubstringInWraproundString(String p) {
        if(p.length() == 0)
            return 0;
        int[] dp = new int[26];
        int len = 1;
        dp[p.charAt(0) - 'a'] = 1;
        for (int i = 1; i < p.length(); i++){
            char pre = p.charAt(i-1);
            char cur = p.charAt(i);
            if(cur - pre == 1 || pre == 'z' && cur == 'a')
                len++;
            else
                len = 1;
            dp[cur-'a'] = Math.max(dp[cur-'a'],len);
        }
        return Arrays.stream(dp).sum();
    }
}
