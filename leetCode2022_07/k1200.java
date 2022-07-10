package leetcode.leetCode2022_07;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class k1200 {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> ans = new LinkedList<>();
        Arrays.sort(arr);
        int minDifference  = Integer.MAX_VALUE;
//        int index = 0;

//        for (int i = 0; i < arr.length - 1; i++) {
//            minDifference = Math.min(minDifference, arr[i + 1] - arr[i]);
//        }

        for (int i = 0; i < arr.length - 1; i++){
            int difference  = arr[i+1] - arr[i];
//            if (difference == minDifference){
//                List<Integer> subAns = new LinkedList<>();
//                subAns.add(arr[i]);
//                subAns.add(arr[i+1]);
//                ans.add(subAns);
//            }
            if (difference < minDifference){
                ans.clear();
                minDifference = difference;
                List<Integer> subAns = new LinkedList<>();
                subAns.add(arr[i]);
                subAns.add(arr[i+1]);
                ans.add(subAns);
            }else if (difference == minDifference){
                List<Integer> subAns = new LinkedList<>();
                subAns.add(arr[i]);
                subAns.add(arr[i+1]);
                ans.add(subAns);
            }
        }

        return ans;
    }
}
