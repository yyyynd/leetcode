package leetCode2021_05_09;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * 反向图，把所有点的出度逆置为入度，这样终点点的入度必为0，这个这个时候执行拓补排序即可得出结果
 *
 * 下面是递归+剪枝
 */
public class k802 {

    public static void main(String[] args) {
        int[][] i = new int[2][];
        System.out.println(i[0] == null);
    }
    Boolean[] dp;
    HashSet<Integer> set;

    public List<Integer> eventualSafeNodes(int[][] graph) {
        this.dp = new Boolean[graph.length];
        this.set = new HashSet<>();

        List<Integer> ans = new LinkedList<>();

        for(int i = 0; i < graph.length;i++){
            if(this.dp[i] == null)
                dfs(i,graph);
        }

        for(int i = 0; i < graph.length;i++){
            if(this.dp[i])
                ans.add(i);
        }
        return ans;
    }

    public boolean dfs(int nextPoint,int[][] graph){
        //首先判断剪枝
        if(this.dp[nextPoint] != null)
            return this.dp[nextPoint];

        //判断该点是否有边，无边则代表其为终点了
        if(graph[nextPoint] == null){
            this.dp[nextPoint] = true;
            return true;
        }
        //把当前点加入遍历过的集合中，来判断环路
        if(!set.add(nextPoint))
            return false;
        for(int i = 0; i < graph[nextPoint].length; i++){
            //遍历该点所有可以走的边，需要所有边都可以到达终点
            if ( !dfs(graph[nextPoint][i],graph) ){
                this.dp[nextPoint] = false;
                this.set.remove(nextPoint);
                return false;
            }
        }

        this.dp[nextPoint] = true;
        this.set.remove(nextPoint);
        return true;
    }
}
