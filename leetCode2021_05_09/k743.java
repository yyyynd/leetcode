package leetCode2021_05_09;

import java.util.*;

public class k743 {

    //用链式前向星存储图
    //链表头边
    int[] he;
    //下一条边
    int[] ne;
    //边指向的节点
    int[] e;
    //边的值
    int[] eValue;
    //边下标
    int index = 0;

    //e[0]头，e[1]尾，e[2]边长度
    public void add(int[] edge){
        e[index] = edge[1];
        eValue[index] = edge[2];
        ne[index] = he[edge[0]];
        he[edge[0]] = index;
        index++;
    }

    public static void main(String[] args) {
        int[][] test ={{2,1,1},{2,3,1},{3,4,1}};
        System.out.println(new k743().networkDelayTime(test,4,2));
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        int edgeNums = times.length;
        this.he = new int[n+1];
        this.ne = new int[edgeNums];
        this.e = new int[edgeNums];
        this.eValue = new int[edgeNums];
        Arrays.fill(this.he,-1);
        for (int[] e : times)
            add(e);
        //答案
        int ans = 0;
        int count = 1;
        int[] length = new int[n+1];
        boolean[] visit = new boolean[n+1];
        HashMap<Integer,Integer> map = new HashMap<>();
        visit[k] = true;
        int prePoint = k;
        int preValue = 0;

        int t = he[k];
        while (t != -1){
            map.put(e[t], Math.min(preValue+eValue[t], map.getOrDefault(e[t],Integer.MAX_VALUE)));
            t = ne[t];
        }

        while (!map.isEmpty()) {
            int min = Integer.MAX_VALUE;
            for(Map.Entry<Integer,Integer> e : map.entrySet()){
                if(min > e.getValue()){
                    prePoint = e.getKey();
                    min = e.getValue();
                }
            }
            //选择该点
            map.remove(prePoint);
            visit[prePoint] = true;
            count++;
            preValue = min;
            ans = Math.max(ans,preValue);

            int edgeIndex = he[prePoint];
            while (edgeIndex != -1){
                if( !visit[e[edgeIndex]] ){
                    //判断通过新加入的结点获取的边能否产生更小的路径
                    map.put(e[edgeIndex], Math.min(preValue+eValue[edgeIndex],
                            map.getOrDefault(e[edgeIndex],Integer.MAX_VALUE)));
                }
                edgeIndex = ne[edgeIndex];
            }
        }

        return count == n ? ans : -1;

    }
}
