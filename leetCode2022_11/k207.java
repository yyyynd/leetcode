package leetcode.leetCode2022_11;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class k207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List[] lists = new List[numCourses];
        int[] degrees = new int[numCourses];
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++)
            lists[i] = new LinkedList<Integer>();

        for (int[] p : prerequisites){
            lists[p[1]].add(p[0]);
            degrees[p[0]] += 1;
        }

        int finishCount = 0;
        for (int i = 0; i < numCourses; i++){
            if (degrees[i] == 0) {
                queue.add(i);
                finishCount += 1;
            }
        }

        while (!queue.isEmpty()){
            int cur = queue.pollFirst();
            List<Integer> list = lists[cur];
            for (int p : list){
                degrees[p] -= 1;
                if (degrees[p] == 0) {
                    queue.add(p);
                    finishCount += 1;
                }
            }
        }
        return finishCount == numCourses;
    }
}
