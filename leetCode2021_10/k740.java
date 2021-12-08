package leetCode2021_10;

import java.util.*;

/**
 * 这题再将数据进行总结后，其实就是个不取相邻点的问题，
 */
public class k740 {
    public static void main(String[] args) {
        System.out.println(new k740().deleteAndEarn(new int[]{3,1}));
    }
    public int deleteAndEarn(int[] nums) {
        int max = 0;
        int[] sortedNums;
        int[] dp;
        for (int n : nums)
            max = Math.max(n,max);

        sortedNums = new int[max + 1];
        dp = new int[max + 1];

        for (int n : nums)
            sortedNums[n] += n;

        dp[1] = sortedNums[1];
        for (int i = 2; i <= max; i++)
            dp[i] = Math.max(dp[i-2] + sortedNums[i], dp[i-1]);

        return dp[max];

//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int i : nums)
//            map.put(i,map.getOrDefault(i,0)+i);
//
//        ArrayList<int[]> list = new ArrayList<>();
//        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
//            int[] i = new int[]{entry.getKey(), entry.getValue()};
//            list.add(i);
//        }
//
//        list.sort(Comparator.comparingInt(a -> a[0]));
//
//        int[] dp = new int[list.size()+1];
//        dp[1] = list.get(0)[1];
//        for (int i = 2; i <= list.size(); i++) {
//            if(list.get(i-1)[0] - list.get(i-2)[0] != 1)
//                dp[i] = list.get(i - 1)[1] + dp[i - 1];
//            else
//                dp[i] = Math.max(list.get(i - 1)[1] + dp[i - 2], dp[i - 1]);
//        }
//
//        return dp[list.size()];
    }
}
