package leetcode.leetCode2022_10;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class k554 {
    public int leastBricks(List<List<Integer>> wall) {
        int sum = 0;
        List<Integer> list = wall.get(0);
        for (int n : list)
            sum += n;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (List<Integer> w : wall){
            int count = 0;
            for (int n : w){
                count += n;
                map.put(count, map.getOrDefault(count, 0) + 1);
            }
        }
        map.remove(sum);

        int ans = 0;
        for (int n : map.values())
            ans = Math.max(n, ans);

        return wall.size() - ans;
    }
}
