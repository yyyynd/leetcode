package leetCode2021_05_09;

import java.util.Arrays;

public class k473 {
    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for (int matchstick : matchsticks) {
            sum += matchstick;
        }
        if (sum % 4 != 0) return false;
        int target = sum / 4;
        Arrays.sort(matchsticks);
        return backtrack(matchsticks, target, matchsticks.length - 1, new int[4]);
    }

    private boolean backtrack(int[] matchsticks, int target, int index, int[] len) {
        if (index == -1) {
            return len[0] == len[1] && len[1] == len[2] && len[2] == len[3];
        }
        for (int i = 0; i < 4; i++) {
            if (len[i] + matchsticks[index] > target || (i > 0 && len[i] == len[i - 1]))
                continue;
            len[i] += matchsticks[index];
            if (backtrack(matchsticks, target, index - 1, len))
                return true;
            len[i] -= matchsticks[index];
        }
        return false;
    }
}
