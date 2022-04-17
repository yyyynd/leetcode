package leetcode.leetCode2022_04;

import java.util.ArrayList;

import java.util.List;

/**
 * 这题的难点就在于如何去重这个问题，因为本题是不记顺序的，
 * 那么应对的方法就是人为的去除重复情况，即手动设置可选情况
 * 例如候选1 2 5 7，因为我们构建的过程可以看做一颗树，那么第一层我们
 * 是 1 2 5 7，那么以1为开头，再用1 2 5 7继续构建，以2为开头的时候
 * 你要是再以1 2 5 7，显然 12 21这两个就已经重复了，那么应该2的候选选择为 2 5 7
 * 即我们应该让同一个层次的构建时，依次减少可选队列来达到避免重复的情况
 */
public class k39 {
    List<List<Integer>> res = new ArrayList<>(); //记录答案
    List<Integer> path = new ArrayList<>();  //记录路径

    public static void main(String[] args) {
        new k39().combinationSum(new int[]{1,2,5,7}, 7);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates,0, target);
        return res;
    }
    public void dfs(int[] c, int u, int target) {
        if(target < 0) return ;
        if(target == 0)
        {
            res.add(new ArrayList(path));
            return ;
        }
        for(int i = u; i < c.length; i++){
            if( c[i] <= target)
            {
                path.add(c[i]);
                dfs(c,i,target -  c[i]); // 因为可以重复使用，所以还是i
                path.remove(path.size()-1); //回溯，恢复现场
            }
        }
    }

}
