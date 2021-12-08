package leetCode2021_05_09;

import java.util.Arrays;

/**
 * 这里数对的定义是p[0] < p[1]，一开始的想法是那么就按照p[0]排序，但这样就浪费了这个定义了
 * 应该用p[1]进行排序，这样同样利用了数对的定义，p[0]必定是小于p[1]了，我们希望链接的更长
 * 肯定就是希望当前选择的元素的p[1]小，那么按照p[1]排序即可，在遍历的时候，p[0]的作用也只是判断
 * 能否链接
 *
 * 主要的思路就是，为了能链接更多，肯定每次要选择p[1]最小的，这样才能保证有更多的可链接选项
 */
public class k646 {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(a,b)->a[1]-b[1]);
        int n=pairs.length;
        int res=1;
        int curr=pairs[0][1];
        for(int i=1;i<n;++i){
            if(curr<pairs[i][0]){
                curr=pairs[i][1];
                res++;
            }
        }
        return res;
    }

//    //保存剩余元素能组成的最长数链长度
//    Integer[] dp;
//    int length;
//    public int findLongestChain(int[][] pairs) {
//        length = pairs.length;
//        dp = new Integer[length];
//        int ans = 0;
//
//        Arrays.sort(pairs,(a, b)->{
//            if(a[0] > b[0])
//                return 1;
//            else if(a[0] < b[0])
//                return -1;
//
//            return 0;
//        });
//
//        for (int i = 0; i < length; i++) {
//            if(ans >= length - i)
//                break;
//            ans = Math.max(ans, dfs(i, pairs));
//        }
//
//        return ans;
//    }
//
//    /**
//     *
//     * @param index 当前遍历所选的数对下标
//     * @return 返回当前选择的最大值
//     */
//    public int dfs(int index,int[][] pairs){
//        if(dp[index] != null)
//            return dp[index];
//
//        //当前所选数对算上计数1
//        int count = 1;
//        for (int i = index+1; i <= length-1;i++) {
//            if(pairs[index][1] < pairs[i][0])
//                count = Math.max(count, dfs(i,pairs) + 1);
//        }
//
//        dp[index] = count;
//        return count;
//    }
}
