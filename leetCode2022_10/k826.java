package leetcode.leetCode2022_10;

import java.util.Arrays;
import java.util.Comparator;

public class k826 {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int ans = 0;
        int[][] a = new int[difficulty.length][2];
        for (int i = 0; i < difficulty.length; i++){
            a[i][0] = difficulty[i];
            a[i][1] = profit[i];
        }
        Arrays.sort(worker);
        Arrays.sort(a, Comparator.comparingInt(o -> o[1]));

        int mission = difficulty.length - 1;
        for (int i = worker.length - 1; i >= 0; i--){
            if (a[mission][0] > worker[i]){
                while (mission >= 0 && worker[i] < a[mission][0])
                    mission--;

                if (mission == -1)
                    break;
            }
            ans += a[mission][1];
        }

        return ans;
    }
}
