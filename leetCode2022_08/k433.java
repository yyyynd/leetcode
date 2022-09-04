package leetcode.leetCode2022_08;

import java.util.*;

/**
 * 利用哈希来实现快速判断基因是否存在于基因组中
 * 本质上就相当于一种回溯算法，只不过这里是通过queue和map来实现了信息的记录和一定的剪枝
 * 不过这比回溯差的地方就在于，为了记录遍历过程需要消耗巨大的内存（尤其是迭代到中后期时，不过在这题里还好）
 */

public class k433 {
    static char[] items = new char[]{'A', 'C', 'G', 'T'};
    public int minMutation(String start, String end, String[] bank) {
        Set<String> set = new HashSet<>(Arrays.asList(bank));
        Deque<String> d = new ArrayDeque<>();
        Map<String, Integer> map = new HashMap<>();
        d.addLast(start);
        map.put(start, 0);
        while (!d.isEmpty()) {
            int size = d.size();
            while (size-- > 0) {
                String s = d.pollFirst();
                char[] cs = s.toCharArray();
                int step = map.get(s);
                for (int i = 0; i < 8; i++) {
                    for (char c : items) {
                        if (cs[i] == c)
                            continue;
                        char[] clone = cs.clone();
                        clone[i] = c;
                        String sub = String.valueOf(clone);
                        if (!set.contains(sub))
                            continue;
                        if (map.containsKey(sub))
                            continue;
                        if (sub.equals(end))
                            return step + 1;
                        map.put(sub, step + 1);
                        d.addLast(sub);
                    }
                }
            }
        }
        return -1;
    }
}
