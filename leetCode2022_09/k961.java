package leetcode.leetCode2022_09;

import java.util.HashSet;

public class k961 {
    public int repeatedNTimes(int[] nums) {
        HashSet<Integer> memo = new HashSet<>();
        for (int n : nums){
            if (memo.contains(n))
                return n;
            memo.add(n);
        }
        return 0;
    }
}
