package leetCode2021_05_09;

import java.util.Arrays;

/**
 * 如果要使得删减的数量最小，肯定希望是以各个小区间连接，因为越长的区间越容易和其他区间产生重叠
 *
 * 利用排序使得数据更方便处理计算
 */
public class k453 {

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->{
            return a[1]-b[1];
        });

        int count = 0;
        int lastIndex = 0;
        for (int i = 1; i < intervals.length-1; i++){
            if(intervals[i][0] < intervals[lastIndex][1])
                count++;
            else
                lastIndex = i;
        }
        return count;
    }

}
