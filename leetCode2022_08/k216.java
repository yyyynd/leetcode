package leetcode.leetCode2022_08;

import javax.swing.*;
import java.util.LinkedList;
import java.util.List;

public class k216 {
    public static void main(String[] args) {
        System.out.println(new k216().combinationSum3(2, 18));
    }

    List<List<Integer>> ans;
    LinkedList<Integer> cur;
    public List<List<Integer>> combinationSum3(int k, int n) {

        this.ans = new LinkedList<>();
        this.cur = new LinkedList<>();

        if ((float)n / k >= 9 && k != 1)
            return this.ans;

        dfs(n / k, 0, n, k);
        return this.ans;
    }

    public void dfs(int index, int sum, int n, int k){
        if (cur.size() == k && sum == n){
            ans.add(new LinkedList<>(cur));
            return;
        }

        for (int i = index; i <= 9; i++){
            if ( i > n - sum )
                break;
            cur.add(i);
            dfs(i + 1,sum + i, n ,k);
            cur.pollLast();
        }
    }
}
