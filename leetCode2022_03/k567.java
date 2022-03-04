package leetcode.leetCode2022_03;

/**
 * 本质上就是k424的简化版了，
 */
public class k567 {
    public boolean checkInclusion(String s1, String s2) {
        int[] memo = new int[26];
        char[] s2_str;
        int left = 0;
        int right = 0;
        int a = 0;
        int b = 0;

        //如果s1.len > s2.len则必定不存在
        if (s1.length() > s2.length())
            return false;

        s2_str = s2.toCharArray();
        for (int i = 0; i < s1.length(); i++)
            memo[ s1.charAt(i) - 'a' ]++;
        for (int n : memo)
            if (n != 0)
                a++;
        //处理一次，让窗口的容量达到目标
        for (; right < s1.length(); right++)
            if(--memo[ s2_str[right] - 'a'] == 0)
                b++;
        //判断形成的窗口是否包含了符合条件的子串
        if ( a == b )
            return true;

        for (; right < s2.length(); right++, left++){
            if (--memo[ s2_str[right] - 'a'] == 0)
                b++;
            if (++memo[ s2_str[left] - 'a'] == 1)
                b--;
            if( a == b)
                return true;
        }

        return false;

    }
}
