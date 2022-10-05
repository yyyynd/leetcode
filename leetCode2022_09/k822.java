package leetcode.leetCode2022_09;

import java.util.HashSet;

public class k822 {
    public int flipgame(int[] fronts, int[] backs) {
        int ans = 2001;
        HashSet<Integer> memo = new HashSet<>();
        for (int i = 0; i < fronts.length; i++){
            if (fronts[i] == backs[i])
                memo.add(fronts[i]);
        }
        for (int i = 0; i < fronts.length; i++){
            if (fronts[i] < ans && !memo.contains(fronts[i]))
                ans = fronts[i];
            if (backs[i] < ans && !memo.contains(backs[i]))
                ans = backs[i];
        }

        return ans == 2001 ? 0 : ans;
    }
}
