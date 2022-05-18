package leetcode.leetCode2022_05;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class k349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> memo = new HashSet<>();
        HashSet<Integer> memo2 = new HashSet<>();

        for (int i : nums1)
            memo.add(i);

        for (int i : nums2){
            if (memo.contains(i))
                memo2.add(i);
        }

        int[] res = new int[memo2.size()];
        int i = 0;
        for (Integer integer : memo) {
            res[i++] = integer;
        }

        return res;
    }
}
