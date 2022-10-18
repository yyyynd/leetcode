package leetcode.leetCode2022_10;

import java.util.Arrays;
import java.util.Comparator;

public class k452 {
    public static void main(String[] args) {
        System.out.println(new k452().findMinArrowShots(new int[][]{{9,12},{1,10},{4,11},{8,12},{3,9},{6,9},{6,7}}));
    }
    public int findMinArrowShots(int[][] points) {
        if (points.length == 1)
            return 1;

        Arrays.sort(points, (o1, o2) -> o1[0] < o2[0] ? -1 : 1);

        int ans = 0;
        int right = points[0][1];

        for (int i = 1; i < points.length; i++){
            if (points[i][0] > right){
                ans++;
                right = points[i][1];
            }else if (points[i][1] < right){
                right = points[i][1];
            }
        }

        return ++ans;
    }
}
