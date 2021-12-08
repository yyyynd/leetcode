package leetCode2021_05_09;

import java.util.Arrays;

/**
 * 这题选择数的方式是限制两端选择，所以和之前的选数题还是有所区别的
 *
 * 本质上就是希望在当前剩余数中选取出一个形成最大值的组合
 * 每个对手选择出来的数都可以看做是负数，因为要求总和大于对方才算赢
 *
 * 这里的思路就是每层递归都是在找当前剩余数中，左右选择下选取出最大结果值（对面和本方选择的数的累加）
 *
 */
public class k486 {

    public static void main(String[] args) {
        int[] t = {1,5,2};
        System.out.println(new k486().PredictTheWinner(t));
    }

    public boolean PredictTheWinner(int[] nums) {
        int len = nums.length;
        int[] memo = new int[1 << len];

        Arrays.fill(memo,Integer.MIN_VALUE);
        return dfs(nums, 0, len - 1, memo,0) >= 0;
    }

    private int dfs(int[] nums, int i, int j, int[] memo,int num) {
        if (i > j) {
            return 0;
        }

        if (memo[num] != Integer.MIN_VALUE) {
            return memo[num];
        }

        int chooseLeft = nums[i] - dfs(nums, i + 1, j, memo,num | (1 << nums.length - i - 1));
        int chooseRight = nums[j] - dfs(nums, i, j - 1, memo,num | (1 << nums.length - j - 1));
        memo[num] = Math.max(chooseLeft, chooseRight);
        return memo[num];
    }
}
