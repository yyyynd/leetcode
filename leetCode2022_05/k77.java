package leetcode.leetCode2022_05;

import java.util.LinkedList;
import java.util.List;

public class k77 {
    List<List<Integer>> ans = new LinkedList<>();

//    public static void main(String[] args) {
//        System.out.println(new k77().combine(4,2));
//    }
    public List<List<Integer>> combine(int n, int k) {
        dfs(0,n,k,new LinkedList<>(), 0);
        return ans;
    }

    public void dfs(int len, int n, int k, LinkedList<Integer> combine, int pre){
        if (len == k) {
            ans.add(new LinkedList<>(combine));
            return;
        }

        for (int i = pre; i < n; i++){
            combine.add(i+1);
            dfs( len + 1, n, k, combine, i + 1);
            combine.removeLast();
        }
    }
}
