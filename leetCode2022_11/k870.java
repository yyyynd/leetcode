package leetcode.leetCode2022_11;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class k870 {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        int[][] target = new int[nums2.length][2];
        for (int i = 0; i < nums2.length; i++){
            target[i][0] = nums2[i];
            target[i][1] = i;
        }

        Arrays.sort(target, Comparator.comparingInt(o -> o[0]));
        int[] ans = new int[nums2.length];
        int right = nums1.length - 1;
        int left = 0;
        for (int i = nums2.length - 1; i >= 0; i--){
            if (target[i][0] < nums1[right]){
                ans[target[i][1]] = nums1[right];
                right -= 1;
            }else {
                ans[target[i][1]] = nums1[left];
                left += 1;
            }
        }

        return ans;
    }
}
