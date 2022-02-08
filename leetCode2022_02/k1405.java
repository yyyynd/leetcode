package leetcode.leetCode2022_02;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 目前的思路就是利用dp来“遍历”所有情况得出最大解
 *
 * 实际解就是通过贪心每次选择剩余数量最多的字符加入
 */
public class k1405 {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder ans = new StringBuilder();
        int c1 = -1,c2 = -1;
        int[][] chars = new int[][]{{0,a},{1,b},{2,c}};
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        queue.addAll(Arrays.asList(chars));

        while (true){
            int[] cur_char = queue.poll();
            //判断是否组成三连情况
            if(c1 == cur_char[0] && c2 == cur_char[0]){
                int[] next_char = queue.poll();
                if(next_char[1] == 0)
                    break;
                c1 = c2;
                c2 = next_char[0];
                next_char[1]--;
                ans.append((char) ('a' + next_char[0]));
                queue.add(next_char);
            } else {
                if(cur_char[1] == 0)
                    break;
                c1 = c2;
                c2 = cur_char[0];
                cur_char[1]--;
                ans.append((char) ('a' + cur_char[0]));
            }
            queue.add(cur_char);
        }

        return ans.toString();
    }
}
