package leetcode.leetCode2022_08;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class k57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        LinkedList<int[]> list = new LinkedList<>();
        int i = 0;
        while (i < intervals.length){
            if (intervals[i][1] < newInterval[0]) {
                list.add(intervals[i]);
                i++;
            } else if (intervals[i][1] >= newInterval[0])
                break;
        }
        //如果就是直接遍历完了都没有停下
        if (i == intervals.length){
            list.add(newInterval);
            return list.toArray(new int[0][0]);
        }

        if (intervals[i][0] > newInterval[1]) {//首先判断分离
            list.add(newInterval);
            list.add(intervals[i]);
            i++;
        }else { //相交了
            newInterval[0] = Math.min(newInterval[0] , intervals[i][0]);
            while (i < intervals.length){
                if (intervals[i][1] < newInterval[1])
                    i++;
                else
                    break;
            }

            //如果就是直接遍历完了都没有停下
            if (i == intervals.length){
                list.add(newInterval);
                return list.toArray(new int[0][0]);
            }

            if (intervals[i][0] <= newInterval[1]) {//如果和这个块相交
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
                i++;
            }else
                newInterval[1] = Math.max(newInterval[1], intervals[i - 1][1]);

            list.add(newInterval);
        }

        while (i < intervals.length){
            list.add(intervals[i]);
            i++;
        }
        return list.toArray(new int[0][0]);
    }

}
