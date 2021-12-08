package leetCode2021_11;

import java.util.HashMap;
import java.util.HashSet;

public class k1218 {

    public int longestSubsequence(int[] arr, int difference) {
        int N = 40009;
        int M = N / 2;
        int[] hash = new int[N];
        int ans = 1;
        for(int n : arr){
            hash[n + M] = hash[n + M - difference] + 1;
            ans = Math.max(ans, hash[n + M]);
        }

        return ans;
    }
}
