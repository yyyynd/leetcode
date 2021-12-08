package leetCode2021_05_09;

import java.util.*;

/**
 * java中一些提供的排序（升序），比较器反1，代表该数（第一个参数）更大，要排到后面
 * 反-1则意味着该数更小排后面
 * 所以只要重写比较器，a>b时反-1就可以做到降序排序了（意味着a<b返回1
 */
public class k451 {

    class Node {
        char c;
        int v;

        Node(char _c, int _v) {
            c = _c;
            v = _v;
        }
    }

    public String frequencySort(String s) {

        char[] cs = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();

        for (char c : cs) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Node> q = new PriorityQueue<>((a, b) -> {
                if (b.v != a.v) return b.v - a.v;
                return a.c - b.c;
            });

        for (char c : map.keySet()) {
            q.add(new Node(c, map.get(c)));
        }

        StringBuilder sb = new StringBuilder();

        while (!q.isEmpty()) {
            Node poll = q.poll();
            int k = poll.v;
            while (k-- > 0) sb.append(poll.c);
        }

        return sb.toString();
    }
}

