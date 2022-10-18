package leetcode.leetCode2022_10;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 这里的队列无重复添加可以依靠Set来实现
 *
 * 主要的原理就是之前我考虑的每次把新加入的点加入一个队列来依次遍历
 * 就可以避免之前遇到的一个错误，即新加入的点不知道加入哪个并查集的问题
 * 而且之前的并查集是通过两个set实现的，其实可以直接通过一个数组来记录标记
 *
 *
 */

public class k785 {
    public boolean isBipartite(int[][] graph) {
        int[] memo = new int[graph.length];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < graph.length; i++){
            if (memo[i] != 0)
                continue;
            queue.offer(i);
            memo[i] = 1;
            while (!queue.isEmpty()){
                int v = queue.poll();
                for (int n : graph[v]){
                    if (memo[v] == memo[n])
                        return false;
                    if (memo[n] == 0) {
                        memo[n] = -memo[v];
                        queue.offer(n);
                    }
                }
            }//while
        }
        return true;
    }
}
