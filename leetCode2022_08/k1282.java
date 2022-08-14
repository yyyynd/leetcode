package leetcode.leetCode2022_08;

import javax.swing.plaf.IconUIResource;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class k1282 {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        int[][] group = new int[groupSizes.length][2];
        for (int i = 0; i < groupSizes.length; i++) {
            group[i][0] = groupSizes[i];
            group[i][1] = i;
        }
        Arrays.sort(group, (o1, o2) -> o1[0] - o2[0]);

        List<List<Integer>> ans = new LinkedList<>();
        int count = 1;
        int limit = group[0][0];
        List<Integer> cur = new LinkedList<>();
        cur.add(group[0][1]);
        for (int i = 1; i < groupSizes.length; i++){
            //判断当前组是否可以加入新元素
            if (limit == count || group[i][0] != limit){
                ans.add(cur);
                cur = new LinkedList<>();
                cur.add(group[i][1]);
                count = 1;
                limit = group[i][0];
            }else {
                cur.add(group[i][1]);
                count++;
            }
        }

        ans.add(cur);
        return ans;
    }
}
