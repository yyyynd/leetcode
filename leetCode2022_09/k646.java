package leetcode.leetCode2022_09;

import java.util.Arrays;
import java.util.Comparator;

public class k646 {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
//                if (o1[1] == o2[1])
//                    return o1[0] - o2[0];
                return o1[1] - o2[1];
            }
        });

        int tail = pairs[0][1];
        int ans = 1;
        for (int i = 1; i < pairs.length; i++){
            if (pairs[i][0] > tail){
                tail = pairs[i][1];
                ans++;
            }
        }

        return ans;
    }

//    public int dfs(int[][] pairs, int index){
//        for (int i = index + 1; i < pairs.length; i++){
//            if (pairs[index][1] < pairs[i][0]){
//
//            }
//        }
//    }
}
