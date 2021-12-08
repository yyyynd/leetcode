package leetCode2021_05_09;

import java.util.HashMap;
import java.util.Map;

public class k611 {
    HashMap<Integer,Integer> map;
    int[] edge;

    public int triangleNumber(int[] nums) {
        map = new HashMap<>();
        for(int n : nums) {
            if(n == 0)
                continue;
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        edge = new int[map.size()];
        int i = 0;
        for (Map.Entry<Integer,Integer> entry : map.entrySet())
            edge[i++] = entry.getKey();

        return countFun(-1,-1,0,0);
    }

    /**
     *
     * @param firstEdge 已经选择的第一条边
     * @param secondEdge 已经选择的第二条
     * @param selectedNum 已经选择的边数量
     * @param a_index 可以选择的边下标范围起点
     * @return
     */
    public int countFun(int firstEdge, int secondEdge, int selectedNum,int a_index) {
        int count = 0;

        for (int i = a_index; i < edge.length; i++) {
            //表示在该递归层次之前已经进行过两次选边了
            switch (selectedNum) {
                case 2:
                    if (firstEdge + secondEdge > edge[i] && firstEdge + edge[i] > secondEdge &&
                            secondEdge + edge[i] > firstEdge) {
                        //判断选择前两条边选择上是否为相同边
                        if (firstEdge == secondEdge)
                            count += map.get(edge[i]) * twoSameEdge(firstEdge);
                        else
                            count += map.get(edge[i]) * map.get(firstEdge) * map.get(secondEdge);
                    }
                    break;

                case 1:
                    if (map.get(edge[i]) >= 2 && firstEdge + edge[i] > edge[i] && edge[i] * 2 > firstEdge)
                        count += twoSameEdge(edge[i]) * map.get(firstEdge);
                    count += countFun(firstEdge, edge[i], 2, i + 1);
                    break;

                case 0:
                    if (map.get(edge[i]) >= 3)
                        count += threeSameEdge(edge[i]);
                    //当前边选择一次
                    count += countFun(edge[i], -1, 1, i + 1);
                    //当前边选择两次
                    count += countFun(edge[i], edge[i], 2, i + 1);
                    break;
            }
        }

        return count;
    }


    public int twoSameEdge(int v){
        int num = map.get(v);
        return num*(num-1)/2;
    }

    public int threeSameEdge(int v){
        int num = map.get(v);
        int count = 1;
        for (int i = 3; i < num; i++)
            count += i*(i-1)/2;

        return count;
    }

}
