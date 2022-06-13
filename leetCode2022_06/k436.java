package leetcode.leetCode2022_06;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;

public class k436 {
    public int[] findRightInterval(int[][] its) {
        int n = its.length;
        int[][] clone = new int[n][2];
        for (int i = 0; i < n; i++) clone[i] = new int[]{its[i][0], i};
        Arrays.sort(clone, (a,b)->a[0]-b[0]);
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int l = 0, r = n - 1;
            while (l < r) {
                int mid = l + r >> 1;
                if (clone[mid][0] >= its[i][1]) r = mid;
                else l = mid + 1;
            }
            ans[i] = clone[r][0] >= its[i][1] ? clone[r][1] : -1;
        }
        return ans;
    }
//    public int[] findRightInterval(int[][] intervals) {
//        int[] ans = new int[intervals.length];
//        int[][] left = new int[intervals.length][2];
//        HashMap<Integer,Integer> memo = new HashMap<>();
//
//        for (int i = 0; i < intervals.length; i++) {
//            left[i][0] = intervals[i][0];
//            left[i][1] = i;
//        }
//
//        Arrays.sort(left, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o1[0] - o2[0];
//            }
//        });
//
//        for (int i = 0; i < intervals.length; i++){
//            if (memo.containsKey(intervals[i][1])){
//                ans[i] = memo.get(intervals[i][1]);
//                continue;
//            }
//
//            ans[i] = find(intervals[i][1], left);
//            memo.put(intervals[i][1], ans[i]);
//        }
//
//        return ans;
//    }
//
//    public int find(int target, int[][] nums){
//        int left = 0;
//        int right = nums.length - 1;
//        while (left < right){
//            int mid = left + (right - left) / 2;
//            if (nums[mid][0] < target)
//                left = mid + 1;
//            else if (nums[mid][0] >= target)
//                right = mid;
//        }
//
//        return nums[left][0] >= target ? nums[left][1] : -1;
//    }
}
