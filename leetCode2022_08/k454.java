package leetcode.leetCode2022_08;

import java.util.HashMap;

public class k454 {

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> mapA = new HashMap<>();
        for (int i : nums1){
            for (int j : nums2)
                mapA.put(i + j, mapA.getOrDefault(i + j, 0) + 1);
        }

        int ans = 0;
        for (int i : nums3){
            for (int j : nums4){
                if (mapA.containsKey(-(i+j)))
                    ans += mapA.get(-(i+j));
            }
        }

        return ans;
    }
}
