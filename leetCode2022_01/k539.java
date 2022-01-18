package leetCode2022_01;

import java.util.HashSet;
import java.util.List;

/**
 * 这种比较类的题目，如果情况有限完全可以用下述的桶排序方法来减少计算量
 * 并且这里时间还涉及到跨天问题(可以理解为数据是环形的），用偏移量来模拟如果把当前时间跨天
 *
 * 这种就是明显的情况有限，可以利用偏移量计算来实现左右对比的
 */
public class k539 {
    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();
        if (n > 1440)
            return 0;
        int[] cnts = new int[1440 * 2 + 10];
        for (String s : timePoints) {
            String[] ss = s.split(":");
            int h = Integer.parseInt(ss[0]), m = Integer.parseInt(ss[1]);
            cnts[h * 60 + m]++;
            cnts[h * 60 + m + 1440]++;
        }
        int ans = 1440, last = -10000;
        for (int i = 0; i <= 1440 * 2; i++) {
            if (cnts[i] == 0)
                continue;
            if (cnts[i] > 1)
                return 0;
            ans = Math.min(ans, i - last);
            last = i;
        }
        return ans;

    }
}
