package leetcode.leetCode2022_09;

import java.util.Objects;

public class k28 {
    public int strStr(String haystack, String needle) {
        if (Objects.equals(needle, ""))
            return 0;

        if (needle.length() > haystack.length())
            return -1;
        int h_len = haystack.length();
        int n_len = needle.length();

        int index = 0;
        int ans = 0;
        while (index < h_len && index + n_len - 1 < h_len) {
            if (haystack.charAt(index) == needle.charAt(0)){
                ans = index;
                index++;
                int travel = 1;
                while (travel < n_len && haystack.charAt(index) == needle.charAt(travel)) {
                    index++;
                    travel++;
                }
                if (travel == n_len)
                    return ans;
                else
                    index = ans + 1;
            }else
                index++;

        }

        return -1;
    }
}
