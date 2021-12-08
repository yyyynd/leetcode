package leetCode2021_09;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 这题的思路是很明显的，需要重复遍历整个数组进行组合得出结果
 *
 * 需要注意的是优化问题，这题很明显是遍历，额但我们并不需要存储下每一轮的遍历结果
 * 后再次遍历这个结果得出答案，完完全可以遍历完一次（以某个点为中心点）后直接计算结果
 *
 * 上述思路还可以进一步优化（也就是下面这个写法还可以优化），就是在这次遍历更新map的同时我们
 * 可以同步更新结果，而不需要等到这个距离所有点的总数得出再更新结果（换成每次新加入一个点，更新结果）
 */
public class k447 {
    public int numberOfBoomerangs(int[][] points) {

        int ans = 0;
        Map<Double, Integer> curMap = new HashMap<>();
        for (int[] a : points) {
            for (int[] b : points) {
                double x_d = a[0] - b[0];
                double y_d = a[1] - b[1];
                double distant = x_d * x_d + y_d * y_d;
                curMap.put(distant, curMap.getOrDefault(distant, 0) + 1);
            }//for
            for (Integer i : curMap.values()){
                if(i > 1)
                    ans += (i-1) * i;
            }//for
            curMap.clear();
        }//for

        return ans;
    }
}
