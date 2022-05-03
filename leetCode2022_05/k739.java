package leetcode.leetCode2022_05;

/**
 * 这题其实从后向前or从前向后应该都一样，不过从后往前逻辑更加通顺一些
 * 要注意的点就是第多少天后才比当天温度高，这个“多少天”其实就是可以帮助
 * 我们搜索的一个偏移量，意味着如果i天的温度比j天高，那么意味着 ans[j]天
 * 内是不可能有比i天温度高的天了，不需要再搜索了
 */
public class k739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] ans = new int[length];
        for (int i = length - 2; i >= 0; i--){
            int travel = i + 1;
            while (travel < length){
                if (temperatures[travel] <= temperatures[i]){
                    if (ans[travel] == 0)
                        break;
                    travel += ans[travel];
                }else {
                    ans[i] = travel - i;
                    break;
                }
            }//while
        }//for
        return ans;
    }
}
