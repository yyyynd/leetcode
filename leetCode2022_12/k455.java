package leetcode.leetCode2022_12;

import java.util.Arrays;

public class k455 {
    public int findContentChildren(int[] g, int[] s) {
        int ans = 0;
        Arrays.sort(g);
        Arrays.sort(s);

        for (int i = 0; i < s.length && ans < g.length; i++){
            if (s[i] > g[ans])
                continue;
            ans += 1;
        }

        return ans;
    }
}
