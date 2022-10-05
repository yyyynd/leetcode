package leetcode.leetCode2022_10;

public class k921 {
    public int minAddToMakeValid(String s) {
        int ans = 0;
        int tmp = 0;
        char[] str = s.toCharArray();
        for (char c : str) {
            if (c == ')')
                tmp--;
            else
                tmp++;
            if (tmp < 0) {
                ans += -tmp;
                tmp = 0;
            }
        }//for
        ans += Math.abs(tmp);

        return ans;
    }
}
