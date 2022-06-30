package leetcode.leetCode2022_06;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

/**
 * 1. 如果当前匹配的子串长度大于比较对象，直接为独特子序列
 * 2. 如果长度等于或者小于对方，才开始判断，如果为公共的直接不进行后序的组合判断的（即从最长的子序列开始判断）
 */
public class k522 {
    public static void main(String[] args) {
        System.out.println(new k522().findLUSlength(new String[]{"abc", "aaa"}));
    }
    public int findLUSlength(String[] strs) {
//        int ans = -1;
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });

        //记忆相同的字符串减少迭代数量(长度相同的比较时才进行记忆）
        HashSet<Integer> memo = new HashSet<>();
        for (int i = 0; i < strs.length; i++){
            if (memo.contains(i))
                continue;
            String cur = strs[i];
            int j = 0;
            for (; j < strs.length; j++){
                if (j == i)
                    continue;
                String comp = strs[j];
                //如果当前串的长度比对比串的长度大
                if (cur.length() > comp.length())
                    return cur.length();
                else if (cur.length() == comp.length()) {
                    int k = 0;
                    for (; k < cur.length();k++){
                        if (cur.charAt(k) != comp.charAt(k))
                            break;
                    }
                    if (k == cur.length()) {
                        memo.add(i);
                        memo.add(j);
                        break;
                    }
                }else {
                    int m = 0; // cur index
                    int n = 0;// comp index
                    while (m < cur.length() && n < comp.length()){
                        if (cur.charAt(m) == comp.charAt(n))
                            m++;
                        n++;
                    }
                    if (m == cur.length())
                        break;
                }
            }//for(j
            //如果未提前结束了循环
            if (j == strs.length)
                return cur.length();
        }//for(i

        return -1;
    }

}
