package leetCode2021_05_09;

import java.util.*;

/**
 * 其实用bfs就行，因为这里是有限制的寻找最短路径
 * 那么理论上只要在K步限制内所有内到底的路线找出来，其中有能到达目标点的路线
 * 则进行判断是否更新这个最小值，这就用到了动态规划的思想
 *
 * 这里bfs的队列放入的元素，包含的信息有（当前点，到达当前点是第几步，和到达当前点的路径长度）
 * 然后进行遍历的时候，就是继续遍历该点所连通的边，注意这里不需要防止环路，反正有k限制步数
 * 每次遍历相当于选择该边，所以要根据该边的值更新到达所选边终点的路径长度值，然后如果更新了
 * 则说明选择这条路径可能产生更短的选择，因此再次放入队列
 */
public class k787 {
    int[][] map;
    boolean[] visit;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Queue<int[]> queue = new LinkedList<>();
        List<int[]>[] edge = new List[n];
        int[] prices = new int[n];
        for(int i = 0; i < n; ++i){
            edge[i] = new ArrayList<>();
            prices[i] = Integer.MAX_VALUE;
        }
        for(int[] flight : flights){
            edge[flight[0]].add(new int[]{flight[1], flight[2]});
        }
        prices[src] = 0;
        queue.add(new int[]{src, 0, prices[src]});
        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            if(poll[1] > k) break;
            for(int[] next : edge[poll[0]]){
                if(prices[next[0]] > poll[2] + next[1]){
                    prices[next[0]] = poll[2] + next[1];
                    queue.add(new int[]{next[0], poll[1] + 1, prices[next[0]]});
                }
            }
        }
        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }

}
