package leetCode2021_05_09;

import java.util.*;

public class k797 {

    List<List<Integer>> ans;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        ans = new ArrayList<>();
        ArrayList<Integer> init = new ArrayList<>();
        dfs(0,init,graph);
        return ans;
    }

    public void dfs(int prePoint,ArrayList<Integer> curRoute,int[][] graph){
        curRoute.add(prePoint);

        if(prePoint == graph.length-1) {
            ans.add(new ArrayList<>(curRoute));
            return;
        }

        for(int nextPoint : graph[prePoint]){
            dfs(nextPoint,curRoute,graph);
            curRoute.remove(curRoute.size()-1);
        }
    }
}
