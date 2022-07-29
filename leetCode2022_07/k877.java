package leetcode.leetCode2022_07;

import java.util.HashMap;

public class k877 {

    public boolean stoneGame(int[] piles) {
        int[][] dp = new int[piles.length + 2][piles.length + 2];

        for (int len = 1; len <= piles.length; len++){
            for (int l = 1; l + len - 1 <= piles.length; l++) {
                int r = l + len - 1;
                int left = piles[l - 1] - dp[l+1][r];
                int right = piles[r - 1] - dp[l][r-1];
                dp[l][r] = Math.max(left, right);
            }
        }

        return dp[1][piles.length] > 0;
    }

//    // alice first
//    public boolean dfs(int[] piles, int left, int right, int alice, int bob){
//
//        if (left > right){
//            return alice > bob;
//        }
//
//        if (dfs(piles, left + 1, right -1, alice + piles[left], bob + piles[right])
//            && dfs(piles, left + 2, right, alice + piles[left], bob + piles[left + 1])) {
//            return true;
//        }
//
//        if (dfs(piles, left + 1, right -1, alice + piles[right], bob + piles[left])
//                && dfs(piles, left, right + 2, alice + piles[right], bob + piles[right + 1]))
//            return true;
//
//        return false;
//    }
}
