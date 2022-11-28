package leetcode.leetCode2022_11;

import java.util.Arrays;

public class k809 {
    public static void main(String[] args) {
        System.out.println(new k809().expressiveWords("heeellooo" , new String[]{"axxxrrzzz"}));
    }
    public int expressiveWords(String s, String[] words) {
        int ans = 0;
        int len_s = s.length();
        int same_count;
        boolean extend_count;
        for (String w : words){
            int index_s = 0;
            int index_w = 0;
            int len_w = w.length();
            extend_count = false;
            same_count = 1;
            while (index_s < len_s && index_w < len_w){
                //每次记录相同字符在s连续出现的长度
                if (index_s != 0){
                    //如果继续连续相同，意味着还可能会是w在扩展匹配s
                    if (s.charAt(index_s) == s.charAt(index_s - 1))
                        same_count += 1;
                    else { //如果不连续相同了，w肯定也无法扩展匹配s了，因此判断之前的匹配部分是否长度大于等于3
                        if (extend_count && same_count < 3)
                            break;
                        same_count = 1;
                        extend_count = false;
                    }
                }
                //如果出现了不同的字符
                if (s.charAt(index_s) != w.charAt(index_w)) {
                    //w退一位，查看上一位是否和s当前的相同，相当于判断是否能通过
                    //扩展w的上一位来完成匹配,如果不行就代表无法完成匹配，同时标记发生了扩展
                    if (index_w > 0 && s.charAt(index_s) == w.charAt(index_w - 1)) {
                        index_s += 1;
                        extend_count = true;
                    } else
                        break;
                }else { //出现相同字符就继续进位
                    index_s += 1;
                    index_w += 1;
                }
            }

            //如果s没遍历完，w遍历完了，即w最后一位还有拓展可能性
            if (index_s < len_s && index_w == len_w) {//最后判断一下结尾是否完全连续
                while (index_s < len_s && s.charAt(index_s - 1) == s.charAt(index_s)) {
                    index_s += 1;
                    same_count += 1;
                }
                if (same_count >= 3 && index_s == len_s)
                    ans += 1;
            }else if (index_s == len_s && index_w == len_w) //如果两个都完成了全部遍历
                ans += 1;

        }
        return ans;
    }
}
