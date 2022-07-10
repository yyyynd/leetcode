package leetcode.leetCode2022_07;

public class k1217 {

    public int minCostToMoveChips(int[] position) {
        int count_odd = 0;
        int count_even = 0;
        for (int n : position){
           if (n % 2 == 0)
               count_even++;
           else
               count_odd++;
        }

        return Math.min(count_even, count_odd);
    }
}
