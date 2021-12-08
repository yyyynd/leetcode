package leetCode2021_12;

import java.util.Arrays;
import java.util.HashMap;

public class k506 {
    public String[] findRelativeRanks(int[] score) {
        int length = score.length;
        String[] ans = new String[length];
        String[] title = new String[]{"Gold Medal","Silver Medal","Bronze Medal"};
        int[] copy = Arrays.copyOf(score, length);
        HashMap<Integer, String> map = new HashMap<>();
        Arrays.sort(copy);

        for (int i = length; i >= length - 2 && i >= 1; i--)
            map.put(copy[i-1], title[length - i]);

        for (int i = length - 3; i >= 1; i--)
            map.put(copy[i-1], String.valueOf(length - i + 1) );

        for (int i = 0; i < length; i++)
            ans[i] = map.get(score[i]);

        return ans;
    }
}
