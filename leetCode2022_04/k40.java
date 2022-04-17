package leetcode.leetCode2022_04;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class k40 {
    public static void main(String[] args) {
        System.out.println(new k40().combinationSum2(new int[]{2,5,2,1,2}, 5));
    }

    List<List<Integer>> ans = new LinkedList<>();
    List<Integer> combine = new LinkedList<>();
    int len;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates.length == 0)
            return ans;

        this.len = candidates.length;
        Arrays.sort(candidates);
        dfs(0, target, candidates);
        return ans;
    }

    public void dfs(int index, int target, int[] candidates){
        if (target < 0)
            return;
        else if(target == 0){
            List<Integer> newRes = new LinkedList<>(combine);
            ans.add(newRes);
            return;
        }

        HashSet<Integer> memo = new HashSet<>();
        for (int i = index; i < this.len; i++){
            if (! memo.add(candidates[i]))
                continue;
            combine.add(candidates[i]);
            dfs(i + 1, target - candidates[i], candidates);
            combine.remove(combine.size() - 1);
        }
    }
}
