package leetcode.leetCode2022_10;

import java.util.HashMap;

public class k790 {
    public static void main(String[] args) {
        System.out.println(new k790().numTilings(30));
    }

    int m = (int) 1e9 + 7;
    int[][] domino = new int[][]{{1,1},{0,2},{2,0}};
    int[][] tromino = new int[][]{{2,1},{1,2}};
    HashMap<Integer, Integer> memo = new HashMap<>();
    public int numTilings(int n) {
        return dfs(0,0, n) % m;
    }

    public int dfs(int first, int second, int target){
        if (first > target || second > target)
            return 0;
        if (first == target && second == target)
            return 1;
        int key = first * 10000 + second;
        if (memo.containsKey(key))
            return memo.get(key);

        int subAns = 0;
        //最终能成立的结果只能有三种，差为0,1,2
        if (Math.abs(first - second) == 1){
            //为1的时候可以插入一个tromino
            int[] mino = first > second ? tromino[1] : tromino[0];
            subAns += dfs(first + mino[0], second + mino[1], target);
            subAns %= m;
            //或者尝试在短的一行插入一个横着的domino
            mino = first > second ? domino[1] : domino[2];
            subAns += dfs(first + mino[0], second + mino[1], target);
            subAns %= m;
        }else if (first - second == 0) {
            //差为0的时候可以执行任意选项
            //首先是竖着的domino
            subAns += dfs(first + domino[0][0], second + domino[0][1], target);
            subAns %= m;
            //然后只执行一个横着的domino,只尝试一种
            subAns += dfs(first + domino[1][0], second + domino[1][1], target);
            subAns %= m;
            //最后执行全部的tromino
            for (int[] ints : tromino) {
                subAns += dfs(first + ints[0], second + ints[1], target);
                subAns %= m;
            }
        }else{
            //差为2的时候只能插入一个横着的domino
            int[] mino = first > second ? domino[1] : domino[2];
            subAns += dfs(first + mino[0], second + mino[1], target);
            subAns %= m;
        }
        memo.put(key, subAns);
        return subAns;
    }
}
