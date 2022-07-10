package leetcode.leetCode2022_07;

public class k1375 {
    public int numTimesAllBlue(int[] flips) {
        int max = 0;
        int ans = 0;
        for (int i = 0; i < flips.length; i++){
            max = Math.max(flips[i], max);
            if (max <= i + 1)
                ans++;
        }

        return ans;

    }
}
