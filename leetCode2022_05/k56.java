package leetcode.leetCode2022_05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class k56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        ArrayList<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        int travel = 0;
        for (int i = 1; i < intervals.length; i++){
            int[] comp = list.get(travel);
            if (intervals[i][0] <= comp[1] && intervals[i][1] >= comp[1]){
                list.get(travel)[1] = intervals[i][1];
            }else if (intervals[i][0] > comp[1]){
                list.add(intervals[i]);
                travel++;
            }
        }

        int[][] ans = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++){
            ans[i][0] = list.get(i)[0];
            ans[i][1] = list.get(i)[1];
        }


        return ans;
    }
}
