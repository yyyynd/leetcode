package leetcode.leetCode2022_11;

import java.util.*;

public class k210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 1)
            return new int[]{0};

        int[] degrees = new int[numCourses];
        Set[] sets = new Set[numCourses];
        for (int i = 0; i < numCourses; i++)
            sets[i] = new HashSet<Integer>();

        for (int[] p : prerequisites) {
            degrees[p[0]] += 1;
            sets[p[1]].add(p[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < degrees.length; i++) {
            if (degrees[i] == 0)
                queue.offer(i);
        }

        int count = 0;
        int[] res = new int[numCourses];
        while (!queue.isEmpty()){
            int cur = queue.poll();
            res[count++] = cur;
            Set<Integer> set = sets[cur];
            for (int n : set){
                degrees[n] -= 1;
                if (degrees[n] == 0)
                    queue.offer(n);
            }
//
//            for (int[] p : prerequisites){
//                if (p[1] == cur) {
//                    degrees[p[0]] -= 1;
//                    if (degrees[p[0]] == 0)
//                        queue.offer(p[0]);
//                }
//            }
        }

        if (count < numCourses)
            return new int[0];

        return res;
    }
}
