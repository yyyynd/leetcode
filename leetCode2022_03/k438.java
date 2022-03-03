package leetcode.leetCode2022_03;

import java.util.LinkedList;
import java.util.List;

/**
 * 这个思路就是维护一个词频数组，预先记录目标匹配字符串中的词频，记录出现字母个数
 * 然后统计窗口中和目标字符串相同字母相同词频的出现次数，相等就代表窗口中的子串符合条件
 *
 * 如果是非目标字母的词频，只会变成负数，能够恢复为0也是在窗口移动该字母不在窗口中时，因此不会影响
 * b的统计，理论上就是窗口中如果出现不需要的字母，会使得b不能达到目标值，、
 *
 * 为什么为1的时候就会执行频率减少，因为我们之前统计了词频，且词频为0是才会记录，那么如果词频重新变为1了
 * 意味着窗口滑动丢弃了一个目标字母，不满足条件了
 *
 * 非目标字母的值只能是<= 0, 目标字母的词频只能是 >= 0（在统计数组中
 * 同时因为非目标字母的初始词频为0，意味着永远不可能在计算右侧新增字母抵消词频的时候达到0，只能是负数
 * 
 */

public class k438 {
    public List<Integer> findAnagrams(String s, String p) {

        char[] p_str = p.toCharArray();
        char[] s_str = s.toCharArray();
        int[] memo = new int[26];// 记录字母数量
        int a = 0;// 统计目标匹配字符串字母种类数量
        int b = 0;// 统计当前滑动窗口中子串的字母种类数量
        int left = 0;
        int right = 0;
        List<Integer> res = new LinkedList<>();

        if(s.length() < p.length())
            return res;

        for (char c : p_str)
            memo[c - 'a']++;

        for (int i : memo)
            if (i != 0)
                a++;

        //预处理一次
        for (int i = 0; i < p.length(); i++) {
            if(--memo[s_str[i] - 'a'] == 0)
                b++;
            right++;
        }
        //预处理完一次判断一次是否成立
        if (a == b)
            res.add(0);

        for (int i = right; i < s.length(); i++){
            if(--memo[s_str[i] - 'a'] == 0)
                b++;
            if(++memo[s_str[left] - 'a'] == 1)
                b--;
            left++;
            right++;
            if(a == b)
                res.add(left);
        }

        return res;
    }
}
